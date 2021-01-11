package com.nkompchristian.rest.model;

import java.net.URISyntaxException;
import java.util.Date;

import org.springframework.http.ResponseEntity;

//Interfaccia in cui dichiaro i miei metodi da implementare nella classe BalanceOperatioImpl
public interface BalanceOperation {
	  public ResponseEntity<Object> balanceRead(int accountId) throws URISyntaxException;
	  public ResponseEntity<String> transfert(int accountId) throws URISyntaxException;
	  public ResponseEntity<Object> transactionRead(int accountId, Date fromAccountingDate, Date toAccountingDate) throws URISyntaxException;
}


