// Student Hansen C. Saputra
// 3.6.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Giant
// Represents a Critter in the simulation called Giant, which
// displays 4 different appearances ("fee, "fie", "fore, "fum") every 6 moves, 
// infects anyone in front of it, 
// moves forward if no one's there, turns right if the previous cases don't
// occur, and has gray color. 
import java.awt.*;
public class Giant extends Critter
{
    private int moves;
    
    public Giant()
    {
        moves = 0;
    }

    // returns the color of gray
    public Color getColor()
    {
        return Color.GRAY;
    }

    // returns infect action in case an enemy  (i.e., other than giant) is  in front
    // returns hop action in case no one is in front
    // returns turning right action if none is the case
    // Parameter:
    //      CritterInfo info - object utilized to know what's around giant
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

    // returns the display of "fee", "fie", "foe", and "fum" which change every 6 moves
    public String toString()
    {
        String[] name = {"fee", "fie", "foe", "fum"};
        
        if (moves % 24 == 0)
        {
            moves = 0;
            return name[0];
        } else if (moves / 6 == 0) // 0, 6, 12, 18, 24, ..
        {
            return name[0];
        } else if (moves / 6 == 1)
        {
            return name[1];
        } else if (moves / 6 == 2)
        {
            return name[2];
        } else // moves / 6 == 3
        {
            return name[3];
        } 
    }
}
