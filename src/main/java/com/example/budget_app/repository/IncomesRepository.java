package com.example.budget_app.repository;


import com.example.budget_app.dto.IncomeSummary;
import com.example.budget_app.model.Incomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomesRepository extends JpaRepository<Incomes,Long> {
    List<Incomes> findByUserId(Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.IncomeSummary(LEFT(i.incomeMonth, 3), SUM(i.incomeAmount)) " +
            "FROM Incomes i WHERE i.user.id = :userId GROUP BY i.incomeMonth")
    List<IncomeSummary> getTotalIncomeByMonth(@Param("userId") Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.IncomeSummary(" +
            "CASE WHEN i.incomeMonth IN ('JANUARY', 'FEBRUARY', 'MARCH') THEN 'JAN-MAR' " +
            "     WHEN i.incomeMonth IN ('APRIL', 'MAY', 'JUNE') THEN 'APR-JUN' " +
            "     WHEN i.incomeMonth IN ('JULY', 'AUGUST', 'SEPTEMBER') THEN 'JUL-SEPT' " +
            "     WHEN i.incomeMonth IN ('OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'OCT-DEC' END, " +
            "SUM(i.incomeAmount)) " +
            "FROM Incomes i WHERE i.user.id = :userId GROUP BY " +
            "CASE WHEN i.incomeMonth IN ('JANUARY', 'FEBRUARY', 'MARCH') THEN 'JAN-MAR' " +
            "     WHEN i.incomeMonth IN ('APRIL', 'MAY', 'JUNE') THEN 'APR-JUN' " +
            "     WHEN i.incomeMonth IN ('JULY', 'AUGUST', 'SEPTEMBER') THEN 'JUL-SEPT' " +
            "     WHEN i.incomeMonth IN ('OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'OCT-DEC' END")
    List<IncomeSummary> getTotalIncomeByQuarter(@Param("userId") Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.IncomeSummary(" +
            "CASE " +
            "   WHEN i.incomeMonth IN ('JANUARY', 'FEBRUARY', 'MARCH', 'APRIL', 'MAY', 'JUNE') THEN 'JAN_JUNE' " +
            "   WHEN i.incomeMonth IN ('JULY', 'AUGUST', 'SEPTEMBER', 'OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'JULY_DEC' " +
            "END, " +
            "SUM(i.incomeAmount)) " +
            "FROM Incomes i WHERE i.user.id = :userId GROUP BY " +
            "CASE " +
            "   WHEN i.incomeMonth IN ('JANUARY', 'FEBRUARY', 'MARCH', 'APRIL', 'MAY', 'JUNE') THEN 'JAN_JUNE' " +
            "   WHEN i.incomeMonth IN ('JULY', 'AUGUST', 'SEPTEMBER', 'OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'JULY_DEC' " +
            "END")
    List<IncomeSummary> getTotalIncomeByHalfYear(@Param("userId") Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.IncomeSummary('Total', SUM(i.incomeAmount)) " +
            "FROM Incomes i WHERE i.user.id = :userId")
    List<IncomeSummary> getTotalIncomeByYear(@Param("userId") Long userId);

}
