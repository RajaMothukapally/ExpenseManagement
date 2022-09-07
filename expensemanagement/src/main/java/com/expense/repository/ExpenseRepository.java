package com.expense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByUserId(Long UserId);

}
