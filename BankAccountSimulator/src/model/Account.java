package model;

import java.util.Scanner;

import utils.Utils;




public class Account {
	Scanner sc = new Scanner(System.in);
	private double balance;
	private int accountNumber;
	private Holder holder;
	private static int accountCounter = 1;

    

	public Account(Holder holder) {
        this.accountNumber = Account.accountCounter;
        this.holder = holder;
        this.updateBalance();
        Account.accountCounter += 1;
	}

	public int getAccountNumber() {
        return accountNumber;
    }
    public Holder getClient() {
        return holder;
    }
    public void setClient(Holder holder) {
        this.holder = holder;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private void updateBalance() {
        this.balance = this.getBalance();
    }
	
    public String toString() {

        return "\nBank account: " + this.getAccountNumber() +
                "\nClient: " + this.holder.getName() +
                "\nBalance: " + Utils.doubleToString(this.getBalance()) +
                "\n" ;
    }
	
	//withdraw method
	public void withdraw(Double value) {
		if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
        }else {
            System.out.println("it was not possible to perform the withdrawal");
        }

	}
	
	//deposit method
	public void deposit(Double value) {
        if(value > 0) {
            setBalance(getBalance() + value);
            System.out.println("deposit made successfully");
        }else {
            System.out.println("it was not possible to make the deposit");
        }
	};
	
	
	//Balance inquiry method
	//public void balanceInquiry() {
	//	System.out.println("Your currently balance is "+balance);
	//}
	
	//Generate Extract file method
	//public void generateExtractFile() {
	//	code..
	//}

}
