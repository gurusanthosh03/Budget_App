package com.example.budget_app.service;

import com.example.budget_app.dto.IncomesDto;
import com.example.budget_app.model.Incomes;
import com.example.budget_app.model.User;
import com.example.budget_app.repository.IncomesRepository;
import com.example.budget_app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomesService {

    @Autowired
    private IncomesRepository incomesRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addIncome(IncomesDto incomeDto, Long userId) {
        User userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Incomes income = new Incomes();
        income.setIncomeName(incomeDto.getIncomeName());
        income.setIncomeAmount(incomeDto.getIncomeAmount());
        income.setIncomeMonth(incomeDto.getIncomeMonth());
        income.setUser(userEntity);

        incomesRepository.save(income);
    }

    public List<Incomes> getAllTransactions(Long userId) {
        return incomesRepository.findByUserId(userId);
    }

}
