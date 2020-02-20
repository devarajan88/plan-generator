package com.lendico.finance.plangenerator.bean;

import java.time.LocalDate;

public class InputParameter {

    private int duration;

    private String nominalRate;

    private String loanAmount;

    private LocalDate startDate;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(String nominalRate) {
        this.nominalRate = nominalRate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
