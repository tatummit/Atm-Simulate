package com.tum.atmsim.model;

public class AtmDetail {

    private long id;
    private int NumOfBath20;
    private int NumOfBath50;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumOfBath20() {
        return NumOfBath20;
    }

    public void setNumOfBath20(int numOfBath20) {
        NumOfBath20 = numOfBath20;
    }

    public int getNumOfBath50() {
        return NumOfBath50;
    }

    public void setNumOfBath50(int numOfBath50) {
        NumOfBath50 = numOfBath50;
    }
}
