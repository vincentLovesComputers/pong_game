
import java.awt.Graphics;
import java.awt.Color;



public class Ball {
    public int x_pos = Pong.WINDOW_WIDTH / 2, y_pos = Pong.WINDOW_HEIGHT / 2;
    private int ball_diam = 20;

    private int x_velocity = 5, y_velocity = -5;
    private int reverse_dir = x_velocity;

    public int computer_score = 0;
    public int player_score = 0;

    Player user = new Player();
    Computer cpu = new Computer(null);
    public void update() {
        // update ball's position
        x_pos += x_velocity;
        y_pos += y_velocity;

        if (x_pos + ball_diam > Pong.WINDOW_WIDTH - 7) {

            //increase player score
            player_score = player_score + 1;

            //reset position favour computer
            x_pos = Pong.WINDOW_WIDTH - 7 - (cpu.comp_x_pos + cpu.width);

            x_velocity = -reverse_dir;
        }
        if (x_pos < 0) {
            //increment computer score
            computer_score = computer_score + 1;

            //reset position favour player
            x_pos = user.x_pos + user.width;

            x_velocity = reverse_dir;
        }

        if (y_pos + ball_diam > Pong.WINDOW_HEIGHT - 33) {
            y_velocity = -reverse_dir;
        }

        if (y_pos < 0) {
            y_velocity = reverse_dir;
        }
    }

    public void paint(Graphics g) {

        g.setColor(Color.YELLOW);
        g.fillOval(x_pos, y_pos, ball_diam, ball_diam);

    }

    /************************************** set up getters for x, y, width and height*************************/

    public int getX()
    {
        return x_pos;
    }
    public int getY()
    {
        return y_pos;
    }


    private void reverseDirection()
    {
        x_velocity = -x_velocity;
    }

    public void collisionDetection(Player player)
    {
        if(this.x_pos > player.getX() && this.x_pos < player.getX() + player.getWidth() )
        {
            if(this.y_pos > player.getY() && this.y_pos < player.getY() + player.getHeight())
            {
                reverseDirection();
            }
        }
    }

    public void collisionDetection(Computer cpu)
    {
        if(this.x_pos > cpu.getX() && this.x_pos < cpu.getX() + cpu.getWidth() )
        {
            if(this.y_pos > cpu.getY() && this.y_pos < cpu.getY() + cpu.getHeight())
            {
                reverseDirection();
            }
        }
    }



    }


