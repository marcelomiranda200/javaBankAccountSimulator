package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Account;
import model.Holder;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> bankAccounts;

	public static void main(String[] args) {
        bankAccounts = new ArrayList<Account>();
        principalMenu();
		
	}
	
	public static void principalMenu() {
	System.out.println("Hy, what do you want?");
	System.out.println("1 - Login to my account");
	System.out.println("2 - Create a new account");
	System.out.println("3 - exit");
	int choice = sc.nextInt();
	sc.nextLine();
	if(choice == 1) {
		loggedAccountMenu();
	}else if(choice ==2) {
		createAccountMenu();
		} else if (choice ==3){
	System.out.println("See you later...");
	System.exit(0);
	}else {
		System.out.println("invalid option");
	}
  }
	
	
	public static void loggedAccountMenu(){
		System.out.println("Welcome to your bank account, what do you need to do?");
		System.out.println("1 - Withdraw");
		System.out.println("2 - Deposit");
		System.out.println("3 - Balance inquiry");
		System.out.println("4 - Generate extract file");
		System.out.println("5 - Exit");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			withdraw();
			break;
		case 2:
			deposit();
			break;
		case 3:
			balanceInquiry();
			break;
		//case 4:
		//	account.generateExtractFile(); or just generateExtractFile(); ??
		//	break;
		case 5:
			principalMenu();
			break;
		default:
			System.out.println("Invalid option, please restart system");
			principalMenu();
		}
	}
	
	
	
	public static void createAccountMenu() {
		System.out.print("Type your name: ");
		String holderName = sc.nextLine();
        Holder holder = new Holder(holderName);

        Account account = new Account(holder);

        bankAccounts.add(account);
        System.out.println("account created successfully");

        principalMenu();
	}





private static Account findAccount(int accountNumber) {
    Account account = null;
    if(bankAccounts.size() > 0) {
        for(Account accountt : bankAccounts) {
            if(accountt.getAccountNumber() == accountNumber) {
                account = accountt;
            }
        }
    }
    return account;
}

public static void deposit() {
    System.out.println("Account Number: ");
    int accountNumber = sc.nextInt();
    
    Account account = findAccount(accountNumber);

    if(account != null) {
        System.out.println("How much money do you want to deposit?  ");
        Double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("you successfully deposit "+depositValue+" reais");

        
    }else {
    	System.out.println("account not found");
    }

    loggedAccountMenu();

}







public static void withdraw() {
    System.out.println("Account Number: ");
    int accountNumber = sc.nextInt();

    Account account = findAccount(accountNumber);

    if(account != null) {
        System.out.println("How much money do you want to withdraw? ");
        Double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
    }else {
        System.out.println("account not found");
    }

    loggedAccountMenu();

}



public static void balanceInquiry() {
    System.out.println("Account Number: ");
    int accountNumber = sc.nextInt();

    Account account = findAccount(accountNumber);
    
    if(account != null) {
    	  System.out.println("Your currently balance is "+account.getBalance());

    }else {
        System.out.println("account not found");
    }

    loggedAccountMenu();
    
}


}
