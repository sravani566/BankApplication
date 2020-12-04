package com.bankapp.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.webbeans.DepositBeans;
import com.bankapp.webbeans.TransferBeans;
import com.bankapp.webbeans.WithdrawBeans;


@Controller
public class AccountMgtController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountMgtController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@GetMapping("/")
	public String Home() {
		return "redirect:/allservices";
	}
	
	@GetMapping("allservices")
	public String Services() {
		return "allservices";
	}

	@GetMapping("/transfer")
	public String AccountsTransferGet(ModelMap map) {
		map.addAttribute("transfer", new TransferBeans());
		return "transfer";
		
	}
	
	@PostMapping("/transfer")
	public String AccountsTransfer(@ModelAttribute(name="transferbeans") TransferBeans transferbean) {
		
		int fromaccountId=transferbean.getFromAccountId();
		int toaccountId=transferbean.getToAccountId();
		double amount=transferbean.getAmount();
        accountService.transferMoney(fromaccountId, toaccountId, amount);
        return "redirect:/allservices";
	}
	
	@GetMapping("/deposit")
	public String AccountDepositGet(ModelMap map) {
		map.addAttribute("deposit", new DepositBeans());
		return "deposit";
		
	}
	
	@PostMapping("/deposit")
	public String AccountDepositPost(@ModelAttribute(name="depositbeans") DepositBeans depositbean) {
		int deaccountId=depositbean.getDeAccountId();
		Account accountde=accountService.getAccountById(deaccountId);
		double deAmount=depositbean.getDeAmount();
		accountService.depositMoney(deaccountId, deAmount);
		accountService.updateAccount(accountde);
		return "redirect:/allservices";
	}
	
	@GetMapping("/withdraw")
	public String AccountWithdrawGet(ModelMap map) {
		map.addAttribute("withdraw", new WithdrawBeans());
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public String AccountWithdrawPost(@ModelAttribute(name="withdrawbeans") WithdrawBeans withdrawbeans) {
		int wdaccounId=withdrawbeans.getWdAccountId();
		Account accountwd=accountService.getAccountById(wdaccounId);
	    double wdAmount=withdrawbeans.getWdAmount();
		accountService.withdrawMoney(wdaccounId, wdAmount);
		accountService.updateAccount(accountwd);
		return "redirect:/allservices";
	
	}

}
