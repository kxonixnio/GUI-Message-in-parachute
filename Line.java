import java.awt.*;

public class Line
implements ConstantData{

    private String[]args;

    public Line(String[]args){
        this.args = args;
    }

    public void draw_all_lines(Graphics g){

        double fi = 0.0;
        double stepFi = ((2*Math.PI) / (get_amount_of_segments(args) * amount_of_single_elements_in_one_sector));        // (2PI) / (6*10)

        for (int i = 0; i < get_amount_of_segments(args) * amount_of_single_elements_in_one_sector; i++) {

            if(i % amount_of_single_elements_in_one_sector == 0){
                g.setColor(Color.BLUE);
            }else{
                g.setColor(Color.DARK_GRAY);
            }

            g.drawLine(start_x, start_y,
                    (int) (start_x - (Math.sin(fi) * radius)),
                    (int)(start_y - (Math.cos(fi) * radius))
            );

            fi+=stepFi;
        }
    }
}

/*
    Jeden segment => 360 / max_length
    Jeden segment składa się z 10 "elementów" -> 360 /(max_length / 10)
 */