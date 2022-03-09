package Critters;

// Student Hansen C. Saputra
// 3.8.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Lion
// Represents a Critter in the simulation called Lion, which
// shifts randomly between the color of either red, green, or blue every 3 moves,
// diplays "L", infects enemy (i.e., other than Lion) in front of it, turns left if there's a wall in front or 
// the right side, turns right if there's another Lion in front, and hops if none of those
// is the case

import java.awt.*;
import java.util.*;
public class Lion extends Critter
{
    private Random rand;
    private int moves;
    private int color;

    public Lion()
    {
        rand = new Random();
        moves = 0;
        color = rand.nextInt(3);
    }

    // returns randomly between color of red, green, and blue color every 3 moves
    public Color getColor()
    {        
        if (color == 0)
        {
            return Color.RED;
        } else if (color == 1)
        {
            return Color.GREEN;
        } else 
        {
            return Color.BLUE;
        }
    }

    // returns the display of "L"
    public String toString()
    {
        return "L";
    }

    // returns infect action in case an enemy is in front
    // returns turning left  action in case a wall is in front or to the right
    // returns turning right action in case it meets the same species (Lion)
    // returns hop action in case none of the cases occurs
    // Parameter:
    //      CritterInfo info - object utilized to know what's around giant
    public Action getMove(CritterInfo info)
    {
        moves++;
        
        // every 3 moves 012 345 678 -> 0 3 6 ...
        if (moves % 3 == 0 ) 
        {
            color = rand.nextInt(3);
        }

        if (info.getFront() == Neighbor.OTHER)
        {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL ||
                   info.getRight() == Neighbor.WALL)
        {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME)
        {
            return Action.RIGHT;
        } else 
        {
            return Action.HOP;
        }
    }
}
