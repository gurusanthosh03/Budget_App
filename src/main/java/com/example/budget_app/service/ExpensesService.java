package com.example.budget_app.service;

import com.example.budget_app.dto.ExpensesDto;
import com.example.budget_app.model.Expenses;
import com.example.budget_app.model.User;
import com.example.budget_app.repository.ExpensesRepository;
import com.example.budget_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpensesRepository expensesRepository;
    @Transactional
    public void addExpense(ExpensesDto expensesDto, Long userId) {
        User userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expenses expenses = new Expenses();
        expenses.setExpenseName(expensesDto.getExpenseName());
        expenses.setExpenseAmount(expensesDto.getExpenseAmount());
        expenses.setExpenseMonth(expensesDto.getExpenseMonth());
        expenses.setUser(userEntity);

        expensesRepository.save(expenses);

    }

    public List<Expenses> getAllTransactions(Long userId) {
        return expensesRepository.findByUserId(userId);
    }
}
