// Student Hansen C. Saputra
// 1.18.2022
// CSE 142 Section BI
// TA: Kyler Gray
// SpaceNeedle
// prints out the Space Needle figure 
// can print out different sizes by changing one number in the code
public class SpaceNeedle
{

    public static final int SIZE = 4;
    public static void main(String[] args)
    {
        printStraightPole();
        printExpandingPart();
        printShrinkingPart();
        printStraightPole();
        printBiggerPole();
        printExpandingPart();
    }

    //prints out a figure of vertical pole
    public static void printStraightPole()
    {
        for (int line = 1; line <= SIZE; line++)
        {
            for(int space = 1; space <= SIZE * 3; space++)
            {
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }

    //prints out the expanding part at the upper and bottom part
    // of Space Needle figure
    public static void printExpandingPart()
    {
        for (int line = 1; line <= SIZE; line++)
        {
            for(int space = 1; space <= -3 * line + SIZE * 3; space++)
            {
                System.out.print(" ");
            }
            System.out.print("__/");
            for(int innerLayer = 1; innerLayer <= 3 * line - 3; innerLayer++)
            {
                System.out.print(":");
            }
            System.out.print("||");
            for(int innerLayer = 1; innerLayer <= 3 * line - 3; innerLayer++)
            {
                System.out.print(":");
            }
            System.out.println("\\__");
        }

        System.out.print("|");
        for(int i = 1; i <= SIZE * 6;i++)
        {
            System.out.print('"');
        }
        System.out.println("|");
    }
    
    // prints out the upper, shrinking part of Space Needle figure
    public static void printShrinkingPart()
    {
        for (int line = 1; line <= SIZE; line++)
        {
            for(int space = 1; space <= 2 * line - 2; space++)
            {
                System.out.print(" ");
            }
            System.out.print("\\_/");
            for(int innerLayer = 1; innerLayer <= -2 * line + SIZE * 3; innerLayer++)
            {
                System.out.print("\\/");
            }
            System.out.println("\\_/");
        }
    }

    // prints out the bigger pole of Space Needle figure  
    public static void printBiggerPole()
    {
        for (int line = 1; line <= SIZE * SIZE; line++)
        {
            for(int space = 1; space <= 2 * SIZE + 1; space++)
            {
                System.out.print(" ");
            }
            System.out.print("|");
            for(int innerPole = 1; innerPole <= SIZE - 2; innerPole++)
            {
                System.out.print("%");
            }
            System.out.print("||");
            for(int innerPole = 1; innerPole <= SIZE - 2; innerPole++)
            {
                System.out.print("%");
            }
            System.out.println("|");
        }
    }
}

