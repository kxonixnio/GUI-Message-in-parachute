import java.awt.*;

public class Circle
    implements ConstantData{

    private int x = 100;
    private int y = 100;
    double local_radius = radius;
    private String[]args;

    public Circle(String[]args){
        this.args = args;
    }

    public void draw_all_circles(Graphics g){

        double four_percentage_difference = start_x * (4.0/100.0);
        g.setColor(Color.BLACK);
        //Najmniejszy, środkowy okrąg
        g.drawOval(
                (int)(start_x - four_percentage_difference), (int)(start_y - four_percentage_difference),
                (int)(2*four_percentage_difference), (int)(2*four_percentage_difference)
        );
        g.fillOval(
                (int)(start_x - four_percentage_difference), (int)(start_y - four_percentage_difference),
                (int)(2*four_percentage_difference), (int)(2*four_percentage_difference)
        );

        double difference = local_radius / get_amount_of_circles(args);
        for (int i = 0; i < get_amount_of_circles(args); i++) {
            g.drawOval(x, y, (int)local_radius*2, (int)local_radius*2);
            x += difference;
            y += difference;
            local_radius -= difference;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

