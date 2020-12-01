import javax.swing.*;
import java.awt.*;

class DrawingComponentArAdd extends JPanel {

    int xg[] ;
    int yg[] ;
    int ng = 5;
    public DrawingComponentArAdd(int x[], int y[]){
        this.xg=x;
        this.yg=y;
    }
    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;


        int step = 20;
        //ось у
        drp.drawLine(0+step, 600-step, 0+step, 0+step);
        //ось х
        drp.drawLine(0+step, 600-step, 800-step, 600-step);
        drp.drawPolyline(xg, yg, ng);
        //начало координат
        drp.drawString( Integer.toString((650-580-70)*10), 0 ,580 );
        //отметки на оси х
        String s[]= {"10","100","1000","10000","100000"};
        int stepX=0;
        for (int i=0;i<5;i++) {
            drp.drawString(s[i], xg[i], 605);
            stepX+=50;
        }
        //отметки на оси y
        for (int i=0;i<s.length;i++) {
            drp.drawString( Integer.toString((650-yg[i]-70)*10), step, yg[i]);
            stepX+=50;
        }

    }
}