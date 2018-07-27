package com.tum.atmsim.util;

import com.tum.atmsim.repository.entity.AtmDetail;

public final class AtmDetailUtils {

    private AtmDetailUtils() {
        //intentional
    }

    public static int getTotalAmount(AtmDetail atmDetail) {
        return atmDetail.getNumOfBath50()*50 + atmDetail.getNumOfBath20()*20;
    }
}
