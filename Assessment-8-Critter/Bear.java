package Critters;

/*
    make object/definition instead of main -> don't change main
    use exact heder di spec assessment
    Minimize the number of fields and objects that  I don't need
    no loop
    janlup header class comment, method comments, parameter n return comments
    cuma perlu declare private class. - public, final, static gperlu
    janlup reflection
    bole pke advanced material for your Husky.java Critter
    default = gaperlu bikin code tntg itu
    dia auto keloop sendiri, jdi dibbrp kondisi say w set "moves" sebagai posisi awal sebelom
    belok, itu set jdi 0 sebelom return biar di next loop dia start dri 0 lgi bs - tpi w gaharus tulis loopny
*/
import java.awt.*;

public class Bear extends Critter
{
    private boolean colorBoolean;
    private int move;

    public Bear(boolean polar)
    {
        colorBoolean = polar;
    }

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
