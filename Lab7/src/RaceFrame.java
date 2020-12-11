import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RaceFrame extends JFrame
{
    private RaceComponent comp;
    JLabel winner = new JLabel("", SwingConstants.CENTER);
    public static Boolean flag = false;

    public RaceFrame ()
    {
        comp = new RaceComponent();
        comp.setBackground(comp.getColor());
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                flag =false;
                startRace();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });

		/*addButton(buttonPanel, "Turbo", new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				f=true;
			}
		})*/;

        add(buttonPanel, BorderLayout.SOUTH);
        add(winner, BorderLayout.NORTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void startRace()
    {
        winner.setVisible(false);
        Player racer1 = new Player(0,20);
        Player racer2 = new Player(0,80);
        Player racer3 = new Player(0,140);
        RaceComponent.add(racer1, racer2, racer3);
        Thread t = new Thread(new BallRunnable(comp, racer1, racer2, racer3, winner));
        t.start();
    }
}
