package com.example.budget_app.dto;

import com.example.budget_app.enums.Months;

public class IncomeSummary {
    private String month;
    private Long totalIncome;

    public IncomeSummary(String month, Long totalIncome) {
        this.month = month;
        this.totalIncome = totalIncome;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }
}
