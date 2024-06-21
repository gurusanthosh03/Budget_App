package com.example.budget_app.controller;

import com.example.budget_app.dto.ExpenseSummary;
import com.example.budget_app.dto.ExpensesDto;
import com.example.budget_app.model.Expenses;
import com.example.budget_app.repository.ExpensesRepository;
import com.example.budget_app.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/expenses")
public class ExpensesController {
    @Autowired
    private ExpensesService expensesService;
    @Autowired
    private ExpensesRepository expensesRepository;

    @PostMapping("/addExpense")
    public ResponseEntity<String> addExpense(@RequestBody ExpensesDto expensesDTO, @RequestParam Long userId) {
        expensesService.addExpense(expensesDTO, userId);
        return ResponseEntity.ok("Expense added successfully");
    }

    @GetMapping("/getTransactions/{userId}")
    public ResponseEntity<List<Expenses>> getAllTransactions(@PathVariable Long userId)
    {
        List<Expenses> transactionList = expensesService.getAllTransactions(userId);
        return ResponseEntity.ok(transactionList);
    }
    @GetMapping("/monthly")
    public ResponseEntity<List<ExpenseSummary>> getTotalExpenseByMonth(@RequestParam Long userId) {
        List<ExpenseSummary> expenseSummaryList = expensesRepository.getTotalExpenseByMonth(userId);
        return ResponseEntity.ok(expenseSummaryList);
    }
    @GetMapping("/quarterly")
    public List<ExpenseSummary> getQuarterlyExpense(
            @RequestParam(name = "userId") Long userId) {
        return expensesRepository.getTotalExpenseByQuarter(userId);
    }
    @GetMapping("/halfyearly")
    public List<ExpenseSummary> getHalfYearlyExpense(
            @RequestParam(name = "userId") Long userId) {
        return expensesRepository.getTotalExpenseByHalfYear(userId);
    }
    @GetMapping("/yearly")
    public List<ExpenseSummary> getYearlyExpense(
            @RequestParam(name = "userId") Long userId) {
        return expensesRepository.getTotalExpenseByYear(userId);
    }
}
