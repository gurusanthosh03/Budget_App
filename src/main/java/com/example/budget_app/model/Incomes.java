package com.example.budget_app.model;

import com.example.budget_app.enums.Months;
import jakarta.persistence.*;

@Entity
public class Incomes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private String incomeName;
    private Long incomeAmount;

    @Enumerated(EnumType.STRING)
    private Months incomeMonth;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
