package com.example.budget_app.dto;

import com.example.budget_app.enums.Months;

public class ExpenseSummary {
    private String month;
    private Long totalExpense;


    public ExpenseSummary(String month, Long totalExpense) {
        this.month = month;
        this.totalExpense = totalExpense;
    }


    public ExpenseSummary(Long totalExpense) {
        this.totalExpense = totalExpense;
    }

    public ExpenseSummary(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Long totalExpense) {
        this.totalExpense = totalExpense;
    }
}
