package Critters;

// Student Hansen C. Saputra
// 3.6.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Giant
// Represents a Critter in the simulation called Giant, which
// displays 4 different appearances every 6 moves, infects anyone in front
// of it, moves forward if no one's there, turns right if the previous cases don't
// occur, and has gray color.
import java.awt.*;
public class Giant extends Critter
{
    private int moves;
    private int counter;
    
    public Giant()
    {
        moves = 0;
        counter = 0;
    }

    // decides the critter's color
    // returns the color of the critter
    public Color getColor()
    {
        return Color.GRAY;
    }

    // decides the next action of the critter 
    // returns the action the action of the critter
    // Parameter:
    //      CritterInfo info - object whose behaviors and constants are used
    public Action getMove(CritterInfo info)
    {
        moves++;
        if (info.getFront() == Neighbor.OTHER)
        {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY)
        {
            return Action.HOP;
        } else 
        {
            return Action.RIGHT;
        }
    }

    // decides the appearances of critter
    // returns the appearance that the critter should show
    public String toString()
    {
        String[] name = {"fee", "fie", "foe", "fum"};
        
        if (moves % 24 == 0)
        {
            counter = 0;
        }
        if (moves % 6 == 0 && moves != 0) // 0, 6, 12, 18, 24, ..
        {
            counter++;
        }

        return name[counter];
    }
}
