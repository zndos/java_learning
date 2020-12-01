
import javax.swing.*;
import java.awt.*;



public class ArrayListAdd extends JFrame{

    public  static int x[] =  {100+20,150+20,200+20,250+20,300+20};
    public  static int y[] =  {191+70,478+70,109+70,92+70,53+70};

    public static int n = 5;

    public void Translate() {
        for (int j = 0; j < 5; j++) {
            y[j] = 650 - y[j];
        }
    }

    public ArrayListAdd() {
        super("ArrayList_Среднее_время_добавления");
        JPanel jcp = new JPanel(new BorderLayout());
        this.Translate();
        setContentPane(jcp);
        jcp.add(new DrawingComponentArAdd(this.x,this.y), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}