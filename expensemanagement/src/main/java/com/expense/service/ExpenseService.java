package com.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.entity.Expense;

public interface ExpenseService {
	public void saveExpense(Expense expense);
	public List<Expense> viewUserExpenses(Long userId);
	public Expense getById(Long id);
	public void deleteById(Long id);
}
