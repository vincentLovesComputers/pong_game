
import java.awt.Color;
import java.awt.Graphics;

public class Player
{
    public int width = 20, height = 70,x_pos = 20, y_pos =  Pong.WINDOW_HEIGHT/2 , y_velocity  = 0, reverse_dir = y_velocity;

    public void update()
    {
        y_pos += y_velocity;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(x_pos, y_pos, width, height);
    }

    public void setYVelocity(int speed)
    {
        y_velocity = speed;
    }

    /**************************************set up getters for x, y, width and height*************************/
    public int getX()
    {
        return x_pos;
    }
    public int getY()
    {
        return y_pos;
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