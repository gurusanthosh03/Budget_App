package com.example.budget_app.dto;

import com.example.budget_app.enums.Months;
import com.example.budget_app.model.User;

public class IncomesDto {
    private String incomeName;
    private Long incomeAmount;
    private Months incomeMonth;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public Long getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Long incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Months getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(Months incomeMonth) {
        this.incomeMonth = incomeMonth;
    }
}
