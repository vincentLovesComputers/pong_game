
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.event.KeyEvent;

/** communication space for player and ball class*/

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Ball ball = new Ball();
    Player player = new Player();
    Computer computer = new Computer(this);

    public GamePanel()
    {
        //update frame every 40 milliseconds
        Timer timer = new Timer(40,this);
        timer.start();

        this.addKeyListener(this);
        this.setFocusable(true);
    }

    /******************************update individual classes on the game panel********************************/
    public void update()
    {
        player.update();

        ball.update();
        computer.update();

        ball.collisionDetection(player);
        ball.collisionDetection(computer);
    }

    /*************************************************set up how computer sees the ball on the game panel******/
    /**get information about the ball*/
    public Ball getBall()
    {
        return ball;
    }

    /***************action listener looks at what action performed, says it must do and action performed calls on update method*******************/
    public void actionPerformed(ActionEvent e)
    {
        update();
        repaint();


    }

    public void paintComponent(Graphics g)
    {
        //every milliseconds game updates
        //set color of game's background
        g.setColor(Color.BLACK);

        //set up how the game fits in the window
        g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);

        ball.paint(g);
        player.paint(g);
        computer.paint(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Created by Vincent Masuku", 5,Pong.WINDOW_HEIGHT-50);

        //set up score board against player
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Player: "  + ball.player_score, Pong.WINDOW_WIDTH/4,20);

        //set up score board against computer
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Computer: "  + ball.computer_score, (Pong.WINDOW_WIDTH/2)+(Pong.WINDOW_WIDTH/4),20);

        //build a court
        g.setColor(Color.WHITE);
        g.drawLine(0, 30 , Pong.WINDOW_WIDTH, 30);
        g.drawLine(Pong.WINDOW_WIDTH/2, 30 , Pong.WINDOW_WIDTH/2, Pong.WINDOW_HEIGHT);
        g.drawOval(Pong.WINDOW_WIDTH/2 - 25, Pong.WINDOW_HEIGHT/2 -25, 50, 50);
    }

    /******************************************listen to player key inputs*********************************************/
    public void keyPressed(KeyEvent k)
    {
        int keyCode = k.getKeyCode();
        //go up when up arrow is pressed
        if(keyCode == KeyEvent.VK_UP)
        {
            player.setYVelocity(-5);
        }
        //go down when down arrow is pressed
        else if(keyCode == KeyEvent.VK_DOWN)
        {
            player.setYVelocity(5);
        }
    }

    public void keyReleased(KeyEvent k)
    {
        int keyCode = k.getKeyCode();

        //stop moving if up arrow is released
        if(keyCode == KeyEvent.VK_UP)
        {
            player.setYVelocity(0);
        }

        //stop moving if down arrow is released
        else if(keyCode == KeyEvent.VK_DOWN)
        {
            player.setYVelocity(0);
        }
    }

    public void  keyTyped(KeyEvent k)
    {

    }


}