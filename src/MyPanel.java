import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
    private int xCoord;
    private int yCoord;
    private int deltaX = 10;
    private int deltaY = 10;

    private int r;
    private int g;
    private int b;

    private int width;
    private int height;

    public MyPanel(int xCoord, int yCoord, int r, int g, int b, int width, int height){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.r = r;
        this.g = g;
        this.b = b;
        this.width = width;
        this.height = height;

    }

    public void updatePosition(){
        if(xCoord < 0 || (xCoord + this.width) > super.getSize().getWidth()) {
            deltaX = -deltaX;
        }

        if (yCoord < 0 || (yCoord + this.height) > super.getSize().getHeight()) {
            deltaY = -deltaY;
        }
        xCoord += deltaX;
        yCoord += deltaY;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(this.r == 255){
            r =(int) (Math.random() * 255);
        }
        if(this.g == 255){
            this.g =(int) (Math.random() * 255);
        }
        if(this.b == 255){
            this.b =(int) (Math.random() * 255);
        }

        g.setColor(new Color(this.r++, this.g++, this.b++));
        g.fillOval(xCoord, yCoord, this.width, this.height);

    }
}
