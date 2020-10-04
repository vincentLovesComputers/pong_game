
import java.awt.Color;
import java.awt.Graphics;

public class Computer {

    public int width = 20, height = 70, comp_x_pos = 35, comp_y_pos =  Pong.WINDOW_HEIGHT/2 , y_velocity  = 0, reverse_dir = y_velocity;

    /** give computer access to game panel*/
    /** field is a variable which points to game panel*/
    private GamePanel field;

    /**computer class takes arguments from game panel*/
    /** computer has access to the field we are pointing on to keep track of varibales we need*/

    public Computer(GamePanel game)
    {
        //pass in game panel to computer
        this.field = game;
    }



    /*************************************update the position of computer by incrementing it with its velocity*******/
    public void update()
    {
        //if the ball is above computer move computer up
        if(field.getBall().getY() < this.comp_y_pos)
        {
            y_velocity = -4;
        }

        //if the ball is below computer move computer up
        else if(field.getBall().getY() > this.comp_y_pos)
        {
            y_velocity = 4;
        }

        comp_y_pos += y_velocity;
    }

    /**************************************set up how computer looks on screen*********************************/
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(Pong.WINDOW_WIDTH - 7 - (comp_x_pos + width), comp_y_pos, width, height);
    }

    /************************************set up getters for x, y, width and height*****************************/
    public int getX()
    {
        return Pong.WINDOW_WIDTH -7 -(comp_x_pos + width);
    }
    public int getY()
    {
        return comp_y_pos;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }

}