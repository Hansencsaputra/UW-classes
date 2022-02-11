// Student Hansen C. Saputra
// 2.1.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Budgeter
// Accepts the amount of income and expense per month to determine 
// what type of person the user is financially
// Then, prints the type name out
import java.util.*;

public class Budgeter 
{
    public static final int DAYS_IN_MONTH = 31;
    
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        
        printIntro();

        double incomeAmount = getTotal(console, "income");
        double expenseAmount = getExpenseAmount(console);
        printTotal(incomeAmount, expenseAmount);
        printType(incomeAmount - expenseAmount);
    }
    
    // Prints out the introduction of the program
    public static void printIntro()
    {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    } 

    // Calculates total amount of either income or expense, provided
    // that the user inputs monthly amount
    // Returns the total amount
    // Parameters:
    //      Scanner console - user prompter
    //      String statementType - the word of either "income" or "expense"
    public static double getTotal(Scanner console, String statementType)
    {
        System.out.print("How many categories of " + statementType + "? ");
        int categories = console.nextInt();

        double amount = 0;
        for (int i = 1; i <= categories; i++)
        {
            System.out.print("    Next " + statementType + " amount? $");
            amount = amount + console.nextDouble();
        }
        System.out.println();

        return amount;
    }

    // Calculates total amount of expense, provided that
    // user inputs either daily or monthly expenses
    // Returns the total amount of expense
    // Parameters:
    //      Scanner console - user prompter
    public static double getExpenseAmount(Scanner console)
    {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int amountInterval = console.nextInt();
        
        double expenseAmount = getTotal(console, "expense");
        if (amountInterval == 2)
        {
            expenseAmount = expenseAmount * DAYS_IN_MONTH;
        }

        return expenseAmount;
    }

    // Calculates and Prints out the both total monthly and daily income and expenses
    // Parameters:
    //      double incomeAmount - the amount of monthly income
    //      double expenseAmount - the amount of monthly expense
    public static void printTotal(double incomeAmount, double expenseAmount)
    {
        System.out.println("Total income = $" + roundToCent(incomeAmount) +
             " ($" + roundToCent(incomeAmount / DAYS_IN_MONTH) + "/day)");
        System.out.println("Total expenses = $" + roundToCent(expenseAmount) +
             " ($" + roundToCent(expenseAmount / DAYS_IN_MONTH) + "/day)");
        System.out.println();
    }

    // Determines and Prints out the financial type of user based
    // on the difference of total income and expense
    // Parameters:
    //      double difference - the amount of total income substracted by total expense
    public static void printType(double difference)
    {
        if (difference > 0)
        {
            System.out.println("You earned $" + roundToCent(difference) +
                 " more than you spent this month.");
            
            if (difference <= 250)
            {
                System.out.println("You're a saver.");
                System.out.println("Congratulations! You can save more though :)");
            } else // difference > 250
            {
                System.out.println("You're a big saver.");
                System.out.println("Keep it up!");
            }
        } else // difference <= 0
        {
            System.out.println("You spent $" + roundToCent(-difference) +
                 " more than you earned this month.");

            if (difference > -250)
            {
                System.out.println("You're a spender.");
                System.out.println("Don't overthink! Being a spender is normal." + 
                    "Just focus on the next month.");
            } else // difference <= -250
            {
                System.out.println("You're a big spender.");
                System.out.println("Red flag. Please cut your spending");
            }
        }
    }

    // Rounds numbers to the nearest cent
    // Returns the rounded figure
    // Parameters:
    //      double num - decimal numbers to be rounded
    public static double roundToCent(double num) 
    {
        return Math.round(num * 100.0) / 100.0;
    }
}
