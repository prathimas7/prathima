package com.smartbank.main;
import com.smartbank.service.*;
import com.smartbank.exception.*;
import java.util.Scanner;
public class SmartBankApp {
    public static void main(String[] args) {
        BankService service = new BankServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== SMART BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Search Account");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            try {
                switch (ch) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Account No: ");
                        String accNo = sc.nextLine();
                        System.out.print("Initial Amount: ");
                        double amt = sc.nextDouble();
                        service.createAccount(name, accNo, amt);
                        break;
                    case 2:
                        System.out.print("Account No: ");
                        service.deposit(sc.next(), sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Account No: ");
                        service.withdraw(sc.next(), sc.nextDouble());
                        break;
                    case 4:
                        System.out.print("From Acc: ");
                        String f = sc.next();
                        System.out.print("To Acc: ");
                        String t = sc.next();
                        System.out.print("Amount: ");
                        double a = sc.nextDouble();
                        service.transfer(f, t, a);
                        break;
                    case 5:
                        System.out.println(service.searchAccount(sc.next()));
                        break;
                    case 6:
                        service.showTransactions(sc.next());
                        break;
                    case 7:
                        System.out.println("Thank You for Using SmartBank!");
                        return;
                    default:
                        System.out.println("Invalid Option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
