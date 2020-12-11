import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player
{
    private int x = 0;
    private int y = 0;
    private static final int XSIZE = 50;
    private static final int YSIZE = 35;
    private Color color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());

    public Player(int a, int b)
    {
        x = a;
        y = b;
    }
    public Color getColor(){
        return color;
    }
    public void move(Rectangle2D bounds, int c)
    {
        x += Math.random()*c;
    }

    public Rectangle2D getShape()
    {
        return new Rectangle2D.Double(x, y, XSIZE, YSIZE);
    }

    public int getX()
    {
        return x + 50;
    }
}