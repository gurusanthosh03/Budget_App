package com.example.budget_app.controller;

import com.example.budget_app.dto.IncomesDto;
import com.example.budget_app.dto.IncomeSummary;
import com.example.budget_app.model.Incomes;
import com.example.budget_app.repository.IncomesRepository;
import com.example.budget_app.service.IncomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/income")
public class IncomesController {
    @Autowired
    private IncomesService incomesService;
@Autowired
private IncomesRepository incomesRepository;
    @PostMapping("/addIncome")
    public ResponseEntity<String> addIncome(@RequestBody IncomesDto incomeDTO, @RequestParam Long userId) {
        incomesService.addIncome(incomeDTO, userId);
        return ResponseEntity.ok("Income added successfully");
    }

    @GetMapping("/getTransactions/{userId}")
    public ResponseEntity<List<Incomes>> getAllTransactions(@PathVariable Long userId)
    {
        List<Incomes> transactionList = incomesService.getAllTransactions(userId);
        return ResponseEntity.ok(transactionList);
    }
    @GetMapping("/monthly")
    public ResponseEntity<List<IncomeSummary>> getTotalIncomeByMonth(@RequestParam Long userId) {
        List<IncomeSummary> incomeSummaryList = incomesRepository.getTotalIncomeByMonth(userId);
        return ResponseEntity.ok(incomeSummaryList);
    }
    @GetMapping("/quarterly")
    public List<IncomeSummary> getQuarterlyIncome(
            @RequestParam(name = "userId") Long userId) {
        return incomesRepository.getTotalIncomeByQuarter(userId);
    }
    @GetMapping("/halfyearly")
    public List<IncomeSummary> getHalfYearlyIncome(
            @RequestParam(name = "userId") Long userId) {
        return incomesRepository.getTotalIncomeByHalfYear(userId);
    }
    @GetMapping("/yearly")
    public List<IncomeSummary> getYearlyIncome(
            @RequestParam(name = "userId") Long userId) {
        return incomesRepository.getTotalIncomeByYear(userId);
    }
}
