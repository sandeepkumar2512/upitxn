package com.example.upitxn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.upitxn.service.UpiTransactionService;

@RestController
@RequestMapping("/upi")
public class UpiTxnController {
	
	@Autowired private UpiTransactionService upiTransactionService;
	
	@PostMapping("/doBasicTransaction")
	public void doBasicUpiTraction() {
		upiTransactionService.doUpiTransaction();
	}
}
