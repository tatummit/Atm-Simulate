package com.tum.atmsim.service;

import com.tum.atmsim.exception.InvalidRequestException;
import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.model.SolutionWithdrawMoney;
import com.tum.atmsim.model.WithDrawRequest;
import com.tum.atmsim.model.WithDrawResponse;
import com.tum.atmsim.repository.AtmDetailRepository;
import com.tum.atmsim.repository.entity.AtmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class AtmWithdrawService {

    @Autowired
    private AtmDetailRepository atmDetailRepository;

    @Transactional(rollbackOn = Exception.class)
    public WithDrawResponse withdrawMoney(long id,WithDrawRequest request) {
        AtmDetail atmDetail = getSafeAtmDetail(id);

        int requestWithDraw = request.getAmount();

        int numOfRemainBath20 = atmDetail.getNumOfBath20();
        int numOfRemainBath50 = atmDetail.getNumOfBath50();

        SolutionWithdrawMoney solution = findSolution(requestWithDraw, numOfRemainBath20, numOfRemainBath50);

        atmDetail.setNumOfBath20(atmDetail.getNumOfBath20() - solution.getUsageBank20Bath());
        atmDetail.setNumOfBath50(atmDetail.getNumOfBath50() - solution.getUsageBank50Bath());
        atmDetail.setLastUpdatedDate(new Date());
        atmDetailRepository.save(atmDetail);

        WithDrawResponse response = new WithDrawResponse();
        response.setRemainAmount(atmDetail.getNumOfBath20() * 20 + atmDetail.getNumOfBath50() * 50);
        response.setRemainBank20Bath(atmDetail.getNumOfBath20());
        response.setRemainBank50Bath(atmDetail.getNumOfBath50());
        response.setResponseTime(new Date());
        response.setWithDrawAmount(request.getAmount());
        response.setWithDrawBank20Bath(solution.getUsageBank20Bath());
        response.setWithDrawBank50Bath(solution.getUsageBank50Bath());
        return response;
    }

    private SolutionWithdrawMoney findSolution(int request, int numOfRemainBath20, int numOfRemainBath50) {

        int usageBank50Bath;
        int usageBank20Bath;

        usageBank50Bath = getUsageBank(request, numOfRemainBath50, 50);

        for (int i = usageBank50Bath; i >= 0; i --) {
            int remainWithDraw = request;

            remainWithDraw = remainWithDraw - i * 50;

            usageBank20Bath = getUsageBank(remainWithDraw, numOfRemainBath20, 20);

            remainWithDraw = remainWithDraw - usageBank20Bath * 20;

            if (remainWithDraw == 0) {
                SolutionWithdrawMoney solutionWithdrawMoney = new SolutionWithdrawMoney();
                solutionWithdrawMoney.setUsageBank20Bath(usageBank20Bath);
                solutionWithdrawMoney.setUsageBank50Bath(i);
                return solutionWithdrawMoney;
            }
        }

        throw new InvalidRequestException("no bank note to support "+ request + " baths");
    }

    private int getUsageBank(int request, int numOfRemainNote, int type) {
        int usageBankNote;
        usageBankNote = request / type;
        return (usageBankNote > numOfRemainNote) ? numOfRemainNote : usageBankNote;
    }

    private AtmDetail getSafeAtmDetail(long id) {
        return atmDetailRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("atm id not found"));
    }
}
