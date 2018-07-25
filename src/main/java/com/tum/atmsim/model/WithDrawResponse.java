package com.tum.atmsim.model;

import java.util.Date;

public class WithDrawResponse {

    private Integer withDrawAmount;

    private Integer withDrawBank20Bath;

    private Integer withDrawBank50Bath;

    private Date responseTime;

    private Integer remainBank20Bath;

    private Integer remainBank50Bath;

    private Integer remainAmount;

    public Integer getWithDrawAmount() {
        return withDrawAmount;
    }

    public void setWithDrawAmount(Integer withDrawAmount) {
        this.withDrawAmount = withDrawAmount;
    }

    public Integer getWithDrawBank20Bath() {
        return withDrawBank20Bath;
    }

    public void setWithDrawBank20Bath(Integer withDrawBank20Bath) {
        this.withDrawBank20Bath = withDrawBank20Bath;
    }

    public Integer getWithDrawBank50Bath() {
        return withDrawBank50Bath;
    }

    public void setWithDrawBank50Bath(Integer withDrawBank50Bath) {
        this.withDrawBank50Bath = withDrawBank50Bath;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getRemainBank20Bath() {
        return remainBank20Bath;
    }

    public void setRemainBank20Bath(Integer remainBank20Bath) {
        this.remainBank20Bath = remainBank20Bath;
    }

    public Integer getRemainBank50Bath() {
        return remainBank50Bath;
    }

    public void setRemainBank50Bath(Integer remainBank50Bath) {
        this.remainBank50Bath = remainBank50Bath;
    }

    public Integer getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Integer remainAmount) {
        this.remainAmount = remainAmount;
    }
}
