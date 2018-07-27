package com.tum.atmsim.controller;

import com.tum.atmsim.repository.entity.AtmDetail;
import com.tum.atmsim.service.AtmDetailGetService;
import com.tum.atmsim.service.AtmDetailUpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    @Mock
    private AtmDetailGetService getService;

    @Mock
    private AtmDetailUpdateService updateService;

    @Test
    public void home() {
        Model model = mock(Model.class);
        String view = mainController.home(model);
        verify(model).addAttribute(eq("atms"), anyList());
        assertEquals("index", view);
    }

    @Test
    public void atmView() {
        Model model = mock(Model.class);
        String view = mainController.atmView(model, 1L);
        verify(model).addAttribute(eq("atm"), any());
        assertEquals("atm", view);
    }

    @Test
    public void withdrawView() {
        Model model = mock(Model.class);
        when(getService.getAtmDetail(eq(1L))).thenReturn(mockAtmDetail());
        String view = mainController.withdrawView(model, 1L);
        verify(model).addAttribute(eq("atm"), any());
        verify(model).addAttribute(eq("amount"), any());
        assertEquals("withdraw", view);
    }

    @Test
    public void postAtmConfigView() {
        Model model = mock(Model.class);
        String view = mainController.postAtmConfigView(model, 1L, new AtmDetail());
        verify(model).addAttribute(eq("atm"), any());
        assertEquals("config", view);
    }

    @Test
    public void getAtmConfigView() {
        Model model = mock(Model.class);
        String view = mainController.getAtmConfigView(model, 1L);
        verify(model).addAttribute(eq("atm"), any());
        assertEquals("config", view);
    }

    private AtmDetail mockAtmDetail() {
        AtmDetail atmDetail = new AtmDetail();
        atmDetail.setId(1L);
        return atmDetail;
    }
}