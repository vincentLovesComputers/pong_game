/*set up window of the game*/

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JFrame{

    public static final int WINDOW_WIDTH = 607;
    public static final int WINDOW_HEIGHT = 483;


    public Pong()
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Pong();
    }

}
