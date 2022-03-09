package Critters;

// Student Hansen C. Saputra
// 3.8.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Husky
// Represents a Critter in the simulation called Husky, which
// displays "Y" every 5 simulation moves, otherwise, "K" every 4 simulation moves, otherwise
// "S" every 3 simulation moves, otherwise, "U" every 2 simulation moves, and, if none is the case, "H", 
// holds its position, turns right in case another Husky is in front, infects in other cases, and
// has either  blue or red, randomly chosen in favor to Red in 3:1 ratio

import java.util.*;
import java.awt.*;
public class Husky extends Critter 
{
    private Random r;
    private int moves;
    
    public Husky()
    {
        r = new Random();
        moves = 0;
    }

    // returns "Y" every 5 simulation moves
    // otherwise, returns "K" every 4 simulation moves
    // otherwise, return  "S" every 3 simulation moves
    // otherwise, "return U" every 2 simulation moves
    // if none is the case, returns "H"
    public String toString()
    {   
        if (moves % 5 == 0)
        {
            return "Y";
        } else if (moves % 4 == 0)
        {
            return "K";
        } else if (moves % 3 == 0)
        {
            return "S";
        } else if (moves % 2 == 0)
        {
            return "U";
        } else
        {
            return "H";
        }
    }

    // holds its position
    // returns turning right action when there's another husky in front
    // otherwise, returns infect action 
    // Parameter:
    //      CritterInfo info - object utilized to know what's around giant
    public Action getMove(CritterInfo info)
    {
        moves++;
        if (info.getFront() == Neighbor.SAME)
        {
            return Action.RIGHT;
        } else
        {
            return Action.INFECT;
        }
    }

    // returns color of blue or red, randomly chosen in favor to Red in 3:1 ratio
    public Color getColor()
    {
        int colorNum = r.nextInt(4);

        if (colorNum == 2)
        {
            return Color.BLUE;
        } else
        {
            return Color.RED;
        }
    }
}
