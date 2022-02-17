import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame  = new JFrame("Screen Saver");
        new Main(100, 100, frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public Main(int xStarting, int yStarting, JFrame frame){

        int[] values = {(int) (Math.random()* 255),(int) (Math.random()* 255),(int) (Math.random()* 255)};
        MyPanel root = new MyPanel(xStarting, yStarting, values[0], values[1], values[2], 200, 200);

        frame.getContentPane().add(root);

        Timer timer = new Timer(10, e ->{
            root.updatePosition();
            root.repaint();

            for(int i = 0 ; i <values.length; i ++){
                if(values[i] == 255){
                    values[i] = (int) (Math.random()* 255);
                }
            }

            root.setBackground(new Color(values[0]++,values[1]++, values[2]++));
        });
        timer.setRepeats(true);
        timer.start();
    }
}
