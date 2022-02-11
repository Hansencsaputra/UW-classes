// First take-home assessment
// Hansen Christian Saputra
// 1.8.2022
// CSE 142 Section BI
// TA: TA: Kyler Gray
// Song
// prints a song as the output
public class Song
{

    public static void main(String[] args)
    {
        verse1();
        System.out.println();
        verse2();
        System.out.println();
        verse3();
        System.out.println();
        verse4();
        System.out.println();
        verse5();
        System.out.println();
        verse6();
        System.out.println();
        verse7();
    }

    // prints out the first verse of the song  
    public static void verse1()
    {
        System.out.println("There was an old woman who swallowed a fly.");
        repeatedLines();       
    }

    // prints out the second verse of the song  
    public static void verse2()
    {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        combination0();       
    }

    // prints out the third verse of the song  
    public static void verse3()
    {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        combination1();       
    }

    // prints out the fourth verse of the song  
    public static void verse4()
    {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        combination2();       
    }

    // prints out the fifth verse of the song  
    public static void verse5()
    {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        combination3();       
    }

    // prints out the sixth verse of the song  
    public static void verse6()
    {
        System.out.println("There was an old woman who swallowed a komodo dragon,");
        System.out.println("It makes her fly to the moon.");
        System.out.println("She swallowed the komodo dragon to catch the dog,");
        combination3();       
    }
    
    // prints out the seventh verse of the song  
    public static void verse7()
    {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.") ;      
    }

    // prints out repeated lines related to things printed by 
    // "repeatedLines" method and swallowing spider to catch fly 
    public static void combination0()
    {
        System.out.println("She swallowed the spider to catch the fly,");
        repeatedLines();       
    }

    // prints out repeated lines related to things printed by 
    // "combination0" method and swallowing bird to catch spider
    public static void combination1()
    {
        System.out.println("She swallowed the bird to catch the spider,");
        combination0();       
    }

    // prints out repeated lines related to things printed by 
    // "combination1" method and swallowing cat to catch bird  
    public static void combination2()
    {
        System.out.println("She swallowed the cat to catch the bird,");
        combination1();       
    }

    // prints out repeated lines related to things printed by 
    // "combination2" method and swallowing dog to catch cat 
    public static void combination3()
    {
        System.out.println("She swallowed the dog to catch the cat,");
        combination2();       
    }

    // prints out repeated lines related to the possibility of a woman dying
    public static void repeatedLines()
    {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die."); 
    }

}
