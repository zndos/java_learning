import javax.swing.*;
import java.awt.*;

class RaceComponent extends JPanel
{
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    private static Color color = Color.GRAY;
    private static Player[] players = new Player[3];

    public Color getColor(){
        return color;
    }
    public static void add(Player a, Player b, Player c)
    {
        players[0] = a;
        players[1] = b;
        players[2] = c;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Player b : players)
        {
            if (b != null)
            {
                g2.setPaint(b.getColor());
                g2.fill(b.getShape());
                if (b.getX() >= DEFAULT_WIDTH)
                {
                    this.setBackground(b.getColor());
                    color = b.getColor();
                    //g2.setPaint(Color.GREEN);
                    g2.fill(b.getShape());
                }
            }
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

