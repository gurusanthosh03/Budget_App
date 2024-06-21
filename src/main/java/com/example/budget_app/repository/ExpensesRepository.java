package com.example.budget_app.repository;

import com.example.budget_app.dto.ExpenseSummary;
import com.example.budget_app.dto.IncomeSummary;
import com.example.budget_app.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    List<Expenses> findByUserId(Long userId);
    @Query("SELECT NEW com.example.budget_app.dto.ExpenseSummary(LEFT(i.expenseMonth, 3), SUM(i.expenseAmount)) " +
            "FROM Expenses i WHERE i.user.id = :userId GROUP BY i.expenseMonth")
    List<ExpenseSummary> getTotalExpenseByMonth(@Param("userId") Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.ExpenseSummary(" +
            "CASE WHEN i.expenseMonth IN ('JANUARY', 'FEBRUARY', 'MARCH') THEN 'JAN-MAR' " +
            "     WHEN i.expenseMonth IN ('APRIL', 'MAY', 'JUNE') THEN 'APR-JUN' " +
            "     WHEN i.expenseMonth IN ('JULY', 'AUGUST', 'SEPTEMBER') THEN 'JUL-SEPT' " +
            "     WHEN i.expenseMonth IN ('OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'OCT-DEC' END, " +
            "SUM(i.expenseAmount)) " +
            "FROM Expenses i WHERE i.user.id = :userId GROUP BY " +
            "CASE WHEN i.expenseMonth IN ('JANUARY', 'FEBRUARY', 'MARCH') THEN 'JAN-MAR' " +
            "     WHEN i.expenseMonth IN ('APRIL', 'MAY', 'JUNE') THEN 'APR-JUN' " +
            "     WHEN i.expenseMonth IN ('JULY', 'AUGUST', 'SEPTEMBER') THEN 'JUL-SEPT' " +
            "     WHEN i.expenseMonth IN ('OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'OCT-DEC' END")
    List<ExpenseSummary> getTotalExpenseByQuarter(@Param("userId") Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.ExpenseSummary(" +
            "CASE " +
            "   WHEN i.expenseMonth IN ('JANUARY', 'FEBRUARY', 'MARCH', 'APRIL', 'MAY', 'JUNE') THEN 'JAN_JUNE' " +
            "   WHEN i.expenseMonth IN ('JULY', 'AUGUST', 'SEPTEMBER', 'OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'JULY_DEC' " +
            "END, " +
            "SUM(i.expenseAmount)) " +
            "FROM Expenses i WHERE i.user.id = :userId GROUP BY " +
            "CASE " +
            "   WHEN i.expenseMonth IN ('JANUARY', 'FEBRUARY', 'MARCH', 'APRIL', 'MAY', 'JUNE') THEN 'JAN_JUNE' " +
            "   WHEN i.expenseMonth IN ('JULY', 'AUGUST', 'SEPTEMBER', 'OCTOBER', 'NOVEMBER', 'DECEMBER') THEN 'JULY_DEC' " +
            "END")
    List<ExpenseSummary> getTotalExpenseByHalfYear(@Param("userId") Long userId);

    @Query("SELECT NEW com.example.budget_app.dto.ExpenseSummary('Total', SUM(i.expenseAmount)) " +
            "FROM Expenses i WHERE i.user.id = :userId")
    List<ExpenseSummary> getTotalExpenseByYear(@Param("userId") Long userId);

}
