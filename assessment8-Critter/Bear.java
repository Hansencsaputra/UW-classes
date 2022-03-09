package Critters;

// Student Hansen C. Saputra
// 3.8.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Bear
// Represents a Critter in the simulation called Bear, which
// shows white or black depending on the input, shifts between "/" and
// "\" on each move, infects the enemy (i.e., other than bear) in case it is in front, 
// hops to the empty spot in front, and, otherwise, turns left.

import java.awt.*;
public class Bear extends Critter
{
    private boolean colorBoolean;
    private int move;

    public Bear(boolean polar)
    {
        colorBoolean = polar;
    }

    // returns the display of "/" when it has moved
    // for even quantity of times.
    // otherwise, returns the display of "\"
    public String toString()
    {
        if (move % 2 == 0)
        {
            return "/";
        } else
        {
            return "\\";
        }
    }

    // returns infect action in case an enemy is in front
    // returns hop action in case nothing is in front
    // otherwise, returns turning left action
    // Parameter:
    //      CritterInfo info - object utilized to know what's around giant
    public Action getMove(CritterInfo info)
    {
        move++;
        if (info.getFront() == Neighbor.OTHER)
        {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY)
        {
            return Action.HOP;
        } else
        {
            return Action.LEFT;
        }
    }

    // returns white color in case the input is true
    // otherwise, returns black
    public Color getColor()
    {
        if (colorBoolean)
        {
            return Color.WHITE;
        } else
        {
            return Color.BLACK;
        }
    }
}
