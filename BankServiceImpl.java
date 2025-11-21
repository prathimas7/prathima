package com.smartbank.service;
import com.smartbank.exception.*;
import com.smartbank.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class BankServiceImpl implements BankService {
    private Map<String, Account> accounts = new HashMap<>();
    @Override
    public void createAccount(String name, String accNo, double amount) {
        Account acc = new Account(accNo, name, amount);
        accounts.put(accNo, acc);
        System.out.println("Account Created Successfully!");
    }
    @Override
    public void deposit(String accNo, double amount) throws AccountNotFoundException {
        Account acc = searchAccount(accNo);
        acc.setBalance(acc.getBalance() + amount);
        acc.addTransaction(new Transaction(UUID.randomUUID().toString(), "DEPOSIT", amount));
        System.out.println("Deposit Successful!");
    }
    @Override
    public void withdraw(String accNo, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = searchAccount(accNo);
        if (acc.getBalance() < amount) throw new InsufficientBalanceException("Not enough balance!");
        acc.setBalance(acc.getBalance() - amount);
        acc.addTransaction(new Transaction(UUID.randomUUID().toString(), "WITHDRAW", amount));
        System.out.println("Withdraw Successful!");
    }
    @Override
    public void transfer(String fromAcc, String toAcc, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account sender = searchAccount(fromAcc);
        Account receiver = searchAccount(toAcc);
        if (sender.getBalance() < amount) throw new InsufficientBalanceException("Transfer failed!");
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        sender.addTransaction(new Transaction(UUID.randomUUID().toString(), "TRANSFER OUT", amount));
        receiver.addTransaction(new Transaction(UUID.randomUUID().toString(), "TRANSFER IN", amount));
        System.out.println("Transfer Successful!");
    }
    @Override
    public Account searchAccount(String accNo) throws AccountNotFoundException {
        if (!accounts.containsKey(accNo)) throw new AccountNotFoundException("Invalid Account!");
        return accounts.get(accNo);
    }
    @Override
    public void showTransactions(String accNo) throws AccountNotFoundException {
        Account acc = searchAccount(accNo);
        System.out.println("Transaction History:");
        acc.getTransactions().forEach(System.out::println);
    }
}
