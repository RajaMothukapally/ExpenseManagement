package com.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expense.entity.Expense;
import com.expense.service.ExpenseService;
import com.expense.service.UserService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String viewExpenses(Model model)
	{
		List<Expense> listExpenses = expenseService.viewUserExpenses(userService.getLoggedInUser().getId());
		model.addAttribute("listExpenses", listExpenses);
		return "index1";
	}
	@RequestMapping("/newexpense")
	public String createExpense(Model model)
	{
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		return "addexpense";
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveExpenseDetails(@ModelAttribute("expense") Expense expense){
		expense.setUser(userService.getLoggedInUser());
		expenseService.saveExpense(expense);
		return "redirect:/";	
	}
	@RequestMapping("edit/{id}")
	public ModelAndView showEditExpensePage(@PathVariable(name="id") Long id)
	{
		ModelAndView mav = new ModelAndView("editexpense");
		Expense expense = expenseService.getById(id);
		mav.addObject("expense", expense);
		return mav;
	}
	@RequestMapping("delete/{id}")
	public String deleteUserExpense(@PathVariable(name="id") Long id)
	{
		expenseService.deleteById(id);
		return "redirect:/";
	}

}
