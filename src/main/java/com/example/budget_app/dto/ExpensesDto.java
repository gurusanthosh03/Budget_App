package com.example.budget_app.dto;

import com.example.budget_app.enums.Months;

public class ExpensesDto {

    private String expenseName;
    private Long expenseAmount;
    private Months expenseMonth;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Long getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Long expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Months getExpenseMonth() {
        return expenseMonth;
    }

    public void setExpenseMonth(Months expenseMonth) {
        this.expenseMonth = expenseMonth;
    }
}
