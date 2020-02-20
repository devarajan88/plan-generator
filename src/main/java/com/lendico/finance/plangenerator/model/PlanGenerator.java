package com.lendico.finance.plangenerator.model;

import com.lendico.finance.plangenerator.bean.InputParameter;
import com.lendico.finance.plangenerator.bean.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanGenerator {

    public List<ResponseEntity> calculate(InputParameter inputs) {
        double annuity = roundOff(calculateAnnuity(Double.valueOf(inputs.getLoanAmount()), inputs.getDuration(),
                Double.valueOf(inputs.getNominalRate())));
        double loanAmount = Double.valueOf(inputs.getLoanAmount());
        LocalDate startDate = inputs.getStartDate();
        List<ResponseEntity> list = new ArrayList<ResponseEntity>();
        while (loanAmount > 0) {
            ResponseEntity response = new ResponseEntity();
            double interest = roundOff(calculateInterest(Double.valueOf(inputs.getNominalRate()), loanAmount));
            double principal = roundOff(calculatePrincipal(annuity, interest));
            response.setInitialOutstandingPrincipal(loanAmount);
            loanAmount = roundOff(loanAmount - principal);
            startDate = startDate.plusMonths(1);
            response.setDate(startDate);
            response.setBorrowerPaymentAmount(annuity);
            response.setInterest(interest);

            if (loanAmount < 0) loanAmount = 0;
            response.setRemainingOutstandingPrincipal(loanAmount);
            response.setPrincipal(principal);
            list.add(response);
        }
        return list;
    }

    public double calculateAnnuity(double loanAmount, int duration, double interestRate) {
        interestRate /= 100.0;
        double monthlyRate = interestRate / 12.0;
        double monthlyPayment =
                (loanAmount * monthlyRate) /
                        (1 - Math.pow(1 + monthlyRate, -duration));
        return monthlyPayment;
    }

    public double calculatePrincipal(double annuity, double interest) {
        double principal = annuity - interest;
        return principal;
    }

    public double calculateInterest(double interestRate, double initialOutstandingPrincipal) {
        int daysInYear = 360;
        int daysInMonth = 30;
        double interest = (interestRate * daysInMonth * initialOutstandingPrincipal) / daysInYear;
        return interest / 100.0;
    }

    double roundOff(double value) {
        return Math.round(value * 100D) / 100D;
    }
}
