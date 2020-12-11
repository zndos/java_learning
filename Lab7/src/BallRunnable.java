import javax.swing.*;
import java.awt.*;

class BallRunnable implements Runnable
{
    private Player player1, player2, player3;
    private Component component;
    public static final int DELAY = 5;
    JLabel winner = new JLabel("Congratulations", SwingConstants.CENTER);

    public BallRunnable(Component aComponent, Player aPlayer1, Player aPlayer2, Player aPlayer3, JLabel win)
    {
        component = aComponent;
        player1 = aPlayer1;
        player2 = aPlayer2;
        player3 = aPlayer3;
        winner = win;
    }

    public void run()
    {
        try
        {
            while(  //пока не пересекли финишную черту
                    (player1.getX() < component.getBounds().getWidth()) &&
                    (player2.getX() < component.getBounds().getWidth()) &&
                    (player3.getX() < component.getBounds().getWidth()) )
            {
                if(!RaceFrame.flag){
                    //двигаем машинки TODO что за условие?
                    player1.move(component.getBounds(),3);
                    player2.move(component.getBounds(),3);
                    player3.move(component.getBounds(),3);
                    component.repaint();
                    Thread.sleep(DELAY);
                }
                else {
                    double y=Math.random()*2+1;
                    switch ((int)y)
                    {
                        case 1:{
                            player1.move(component.getBounds(),5);
                            player2.move(component.getBounds(),3);
                            player3.move(component.getBounds(),3);
                            component.repaint();
                            Thread.sleep(DELAY);
                        }
                        case 2:{
                            player1.move(component.getBounds(),3);
                            player2.move(component.getBounds(),5);
                            player3.move(component.getBounds(),3);
                            component.repaint();
                            Thread.sleep(DELAY);
                        }
                        case 3:{
                            player1.move(component.getBounds(),3);
                            player2.move(component.getBounds(),3);
                            player3.move(component.getBounds(),5);
                            component.repaint();
                            Thread.sleep(DELAY);
                        }
                    }
                }

            }


        }
        catch(InterruptedException e)
        {
        }
        if (player1.getX() >= component.getBounds().getWidth())
        {
            winner.setVisible(true);
            winner.setText("Победил Первый");
        }
        if (player2.getX() >= component.getBounds().getWidth())
        {
            winner.setVisible(true);
            winner.setText("Победил Второй");
        }
        if (player3.getX() >= component.getBounds().getWidth())
        {
            winner.setVisible(true);
            winner.setText("Победил Третий");
        }
    }
}
