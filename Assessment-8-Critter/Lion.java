package Critters;

import java.awt.*;
import java.util.*;

public class Lion extends Critter
{
    private Random rand;
    private int moves;

    public Lion()
    {
        rand = new Random();
        moves = 0;
    }

    public Color getColor()
    {
        int color = 0; 
        
        // every 3 moves 012 345 678 -> 0 3 6 ...
        if (moves % 3 == 0)
        {
            color = rand.nextInt(3);
        }

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

    public String toString()
    {
        return "L";
    }

    public Action getMove(CritterInfo info)
    {
        moves++;
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
