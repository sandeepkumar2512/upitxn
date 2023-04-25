package com.example.upitxn.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UpiTransactionService {
	
	private final int MAX_ALLOWED_TXN = 10;
	
	private volatile int txnCount = 0;
	private volatile LocalDate systemDate = LocalDate.now();
	private final Object LOCK = new Object();
	
	public void doUpiTransaction() {
		
		synchronized(LOCK) {
			if(isTransactionAllowed(txnCount)) {
				txnCount++;
				systemDate = LocalDate.now();
				System.out.println("Total transactions done : "+txnCount);
			}else {
				System.out.println("Max transaction limit reached.. try again next day");
				resetTxnCount(systemDate);
			}
		}
	}
	
	private boolean isTransactionAllowed(int currentTxnCount) {
		return currentTxnCount < MAX_ALLOWED_TXN;
	}
	
	private void resetTxnCount(LocalDate lastTxnDate) {
		if(LocalDate.now().isAfter(lastTxnDate)) {
			txnCount=0;
		}
	}

}
