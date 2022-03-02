package Personality;

// Student Hansen C. Saputra
// 3.1.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Personality
// Decides the personality type of people whose names are in file inputted
// based on their answers in a personality quiz
// Then, prints the results, alongisde with name and percentage of answers, in an output file

import java.util.*;
import java.io.*;
public class Personality 
{
    public static final int NUM_OF_DIMENSIONS = 4;

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner inputConsole = new Scanner(System.in);   
        printIntro();

        System.out.print("input file name? ");
        Scanner inputFile = new Scanner(new File(inputConsole.nextLine()));

        System.out.print("output file name? ");
        PrintStream outputFile = new PrintStream(new File(inputConsole.nextLine()));

        // reading file
        while (inputFile.hasNextLine())
        {
            int[] bCounts = new int[NUM_OF_DIMENSIONS];
            int[] aCounts = new int[NUM_OF_DIMENSIONS];
            
            String name = inputFile.nextLine();
            String testAnswers = inputFile.nextLine();

            countAllTestIndicators(testAnswers, aCounts, bCounts);
            
            int[] bPercentage = new int[NUM_OF_DIMENSIONS];
            countBPercentage(aCounts, bCounts, bPercentage);

            String personalityType = decidePersonalityType(bPercentage, 0, "E", "I");
            personalityType += decidePersonalityType(bPercentage, 1, "S", "N");
            personalityType += decidePersonalityType(bPercentage, 2, "T", "F");
            personalityType += decidePersonalityType(bPercentage, 3, "J", "P");
 
            outputFile.println(name + ": " + Arrays.toString(bPercentage) + " = " + personalityType);
        }
    }

    // Prints out the introduction of the Keirsey Temperament Sorter program in console        
    public static void printIntro()
    {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    // Counts, for each personality category, how many As and Bs are in the answers in the file
    // Parameters:
    //    String testAnswers - the file comprising the test answers
    //    int[] aCounts - Array storing the count of As for each category
    //    int[] bCounts - Array storing the count of Bs for each category
    public static void countAllTestIndicators(String testAnswers, int[] aCounts, int[] bCounts)
    {
        for (int i = 0; i < 7; i++)
        {
            for (int j = i; j < 70; j += 7) 
            {
                if (i == 0)
                {
                    countATestIndicator(testAnswers, aCounts, bCounts, j, 0);
                } else if (i == 1 || i == 2)
                {
                    countATestIndicator(testAnswers, aCounts, bCounts, j, 1);
                } else if (i == 3 || i == 4)
                {
                    countATestIndicator(testAnswers, aCounts, bCounts, j, 2);
                } else // i == 5 || i == 6
                { 
                    countATestIndicator(testAnswers, aCounts, bCounts, j, 3);
                }                
            }
        }
    }

    // Decides if the user answer B, A, or skip a question. 
    // Then, count it as either b or a into the counter 
    // Parameters:
    //    String testAnswers - the file comprising the test answers
    //    int[] aCounts - Array storing the count of As for each category
    //    int[] bCounts - Array storing the count of Bs for each category
    //    int index - the index of the string to help the program count As and Bs 
    //    int element - element of the array to help the program count in the correct category
    public static void countATestIndicator(String testAnswers, int[] aCounts, int[] bCounts,
                                           int index, int element)
    {
        if (testAnswers.charAt(index) != '-')
        {
            if (testAnswers.charAt(index) == 'B' || testAnswers.charAt(index) == 'b')
            {
                bCounts[element]++;
            } else
            {
                aCounts[element]++;
            }
        }
    }

    // calculates the percentage of B out of the answers (A & B) 
    // Parameters:
    //    int[] bPercentage - Array storing the percentage of B
    //    int[] aCounts - Array storing the count of As for each category
    //    int[] bCounts - Array storing the count of Bs for each category
    public static void countBPercentage(int[] aCounts, int[] bCounts, int[] bPercentage)
    {
        for (int i = 0; i < 4; i++)
        {
            bPercentage[i] = (int)Math.round((bCounts[i] / ((double)bCounts[i] + aCounts[i])) * 100);
        }
    }

    // decides the personality type based on percentage of the answers.
    // returns either the personality type of "X" in case 
    // the type can't be determined (indicators being equal)
    // Parameters:
    //    int[] bPercentage - Array storing the percentage of B
    //    String resultA - The first-possible personality type
    //    String resultB - The second-possible personality type
    //    int element - element of bPercentage array 
    public static String decidePersonalityType(int[] bPercentage, int element,
                                               String resultA, String resultB)
    {
        String personalityType = "";
        if (bPercentage[element] > 50)
        {
            personalityType = resultB;
        } else if (bPercentage[element] == 50)
        {
            personalityType = "X";
        } else //bPercentage[0] < 50
        {
            personalityType = resultA;
        }
        return personalityType;
    }

}
