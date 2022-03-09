package Critters;

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

    public Action getMove(CritterInfo info)
    {
        moves++;
        return Action.INFECT;
    }

    public Color getColor()
    {
        int colorNum = r.nextInt(4);

        if (colorNum != 2)
        {
            return Color.BLUE;
        } else
        {
            return Color.RED;
        }
    }
}
