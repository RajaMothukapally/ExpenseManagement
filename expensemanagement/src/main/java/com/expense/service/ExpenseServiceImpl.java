package com.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.repository.ExpenseRepository;
@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;
	@Override
	public void saveExpense(Expense expense) {
		expenseRepository.save(expense);
	}
	@Override
	public List<Expense> viewUserExpenses(Long userId) {
		return expenseRepository.findByUserId(userId);
		
	}
	@Override
	public Expense getById(Long id) {
		return expenseRepository.findById(id).get();
	}
	@Override
	public void deleteById(Long id) {
	expenseRepository.deleteById(id);	
	}
	

}
