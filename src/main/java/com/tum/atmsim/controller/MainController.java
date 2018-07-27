package com.tum.atmsim.controller;


import com.tum.atmsim.repository.entity.AtmDetail;
import com.tum.atmsim.service.AtmDetailGetService;
import com.tum.atmsim.service.AtmDetailUpdateService;
import com.tum.atmsim.util.AtmDetailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private AtmDetailGetService getService;

    @Autowired
    private AtmDetailUpdateService updateService;

    @GetMapping({"home", "/"})
    public String home(Model model) {
        model.addAttribute("atms", getService.getAllAtmDetailList());
        return "index";
    }

    @GetMapping("/atm/{id}/view")
    public String atmView(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("atm", getService.getAtmDetail(id));
        return "atm";
    }

    @GetMapping("/atm/{id}/withdraw")
    public String withdrawView(Model model, @PathVariable(value = "id") long id) {
        AtmDetail detail = getService.getAtmDetail(id);
        model.addAttribute("atm", detail);
        model.addAttribute("amount", AtmDetailUtils.getTotalAmount(detail));
        return "withdraw";
    }

    @PostMapping("/atm/{id}/config")
    public String postAtmConfigView(Model model, @PathVariable(value = "id") long id,
                                    @ModelAttribute("data") @Valid AtmDetail atmDetail) {
        AtmDetail detail = updateService.updateAtmDetail(id, atmDetail);
        model.addAttribute("atm", detail);
        return "config";
    }

    @GetMapping("/atm/{id}/config")
    public String getAtmConfigView(Model model, @PathVariable(value = "id") long id) {
        AtmDetail detail = getService.getAtmDetail(id);
        model.addAttribute("atm", detail);
        return "config";
    }
}
