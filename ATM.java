import java.io.*;
import java.util.Scanner;

class Account 
{
    private BankAccount bankAccount;

    public Account(BankAccount bankAccount) 
    {
        this.bankAccount = bankAccount;
    }
    Scanner scanner = new Scanner(System.in);

    public void withdraw() 
    {
    	System.out.print("Enter how much money do you want to Withdraw: ");
    	int withdraw_amount = scanner.nextInt();
        if (withdraw_amount > 0 && withdraw_amount <= bankAccount.getBalance()) 
        {
            bankAccount.setBalance(bankAccount.getBalance() - withdraw_amount);
            System.out.println("Withdrawal successful. Current balance: " + bankAccount.getBalance());
        } 
        else 
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit() 
    {
    	System.out.print("Enter how much money do you want to Deposit: ");
    	int deposit_amount = scanner.nextInt();
        if (deposit_amount > 0) 
        {
            bankAccount.setBalance(bankAccount.getBalance() + deposit_amount);
            System.out.println("Deposit successful. Current balance: " + bankAccount.getBalance());
        } 
        else 
        {
            System.out.println("Invalid amount.");
        }
    }

    public void checkBalance() 
    {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }
}

class BankAccount 
{
    private double balance;

    public BankAccount(double balance) 
    {
        this.balance = balance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
}

class ATM 
{
	public static void main(String[] args)
	{
		BankAccount bankAccount = new BankAccount(1000.0);
        Account acc = new Account(bankAccount);

		int choice;
        Scanner scanner = new Scanner(System.in);
		do 
		{
			System.out.println("\n_*_*_*_*_*_*_ATM_*_*_*_*_*_*_");
			System.out.println("1.Withdraw Amount");
			System.out.println("2.Deposit Amount");
			System.out.println("3.Balance Enquiry");
			System.out.println("4.Exit");
			System.out.print("Enter your Choice from the above displayed Menu: ");
			choice = scanner.nextInt();
			System.out.println();
			switch (choice) 
			{
				case 1:
					acc.withdraw();
					break;
				case 2:
					acc.deposit();
					break;
				case 3:
					acc.checkBalance();
					break;
				case 4:
					System.out.println("-----THANK YOU-----");
					break;
				default:
					System.out.println("Invalid Choice Entered!!!");
					break;
			}
		} while (choice != 4);
	}
}