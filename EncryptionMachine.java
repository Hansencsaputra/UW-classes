// Student Hansen C. Saputra
// 1.25.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Encryption Machine
// Encrypts texts given by user  
// Then, prints out encrypted inputs 
import java.util.*;

public class EncryptionMachine 
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3; 
    
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        printIntro();
        encryptKey(console); 
        encryptWord(console);
    }

    // Prints out introduction part of the output
    public static void printIntro()
    {
        System.out.println("Welcome to the CSE142 Encryption Machine!");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key so your recipient can decrypt.");
        System.out.println();
    }

    // Accepts and encrypts given text
    // Prints the encrypted text out, alongside with the plain text 
    // Parameters:
    //      String userText - the text to be encrypted
    public static void encryptText(String userText)
    {
        String encryptText = "";

        for (int i = 0; i < userText.length(); i++)
        {
            char letter = userText.charAt(i);
            int index = ALPHABET.indexOf(letter);
             
            int encryptIndex = (index + SHIFT) % ALPHABET.length(); 
            encryptText = encryptText + ALPHABET.charAt(encryptIndex);
        } 

        System.out.println("    " + '"' + userText + '"' + " " +
             "has been encrypted to: " + encryptText);
    }

    // Asks for a "key" word from user
    // Encrypts and prints it, encrypted version of it, and a blank line out
    // Parameters:
    //      Scanner console - prompter for the input of user
    public static void encryptKey(Scanner console)
    {
        System.out.println("Encrypted messages use a shared keyword to decrypt.");
        System.out.print("  Enter key: ");
        String userText = console.next();

        encryptText(userText);
        System.out.println();
    }

    // Asks for one or multiple words from user
    // Encrypts and prints them, encrypted version 
    // of them, blank line, and outro out
    // Parameters:
    //      Scanner console - prompter for the input of user
    public static void encryptWord(Scanner console)
    {
        System.out.print("How many words are in your message? ");
        int wordNum = console.nextInt();

        for (int i = 1; i <= wordNum; i++)
        {
            System.out.print("  Next word: ");
            String userText = console.next();
            encryptText(userText);
        }
    
        System.out.println();
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
}
