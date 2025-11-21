package com.smartbank.service;
import com.smartbank.exception.*;
import com.smartbank.model.Account;
public interface BankService {
    void createAccount(String name, String accNo, double amount);
    void deposit(String accNo, double amount) throws AccountNotFoundException;
    void withdraw(String accNo, double amount) throws AccountNotFoundException, InsufficientBalanceException;
    void transfer(String fromAcc, String toAcc, double amount) throws AccountNotFoundException, InsufficientBalanceException;
    Account searchAccount(String accNo) throws AccountNotFoundException;
    void showTransactions(String accNo) throws AccountNotFoundException;
}
