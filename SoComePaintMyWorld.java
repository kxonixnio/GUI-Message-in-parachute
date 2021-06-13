import java.awt.*;
import java.util.List;
import java.util.function.Predicate;

public class SoComePaintMyWorld
    implements ConstantData{

    private List<Letter> selected_letters;
    private String[]args;

    SoComePaintMyWorld(List<Letter> selected_letters, String[]args){
        this.selected_letters = selected_letters;
        this.args = args;
    }

    double fi = 0.0;
    double stepFi = ((2*Math.PI) / 36000);      //0,01 stopnia
    double amount_of_angles_per_one_strip;

    public void color_all_segments(Graphics g){

        color_comment_elements_of_segments(g);

        amount_of_angles_per_one_strip = (((2*Math.PI) / (get_amount_of_segments(args) * amount_of_single_elements_in_one_sector)) * (1822*Math.PI)); //5724
        //TBH no idea dlaczego 5724 / 1822*Math.PI, wyszło mi to przypadkiem metodą prób i błędów chcąc jakoś udoskonalić ten kod niżej
        //ale matematycznie "na kartce" dobrze wychodzi (ma to powiązanie z 36000 przy stepFi)
        //5725 ~ 1822*Math.PI
        //((360) / (get_amount_of_segments(args) * amount_of_single_elements_in_one_sector) * (36000 / 360) )
        int circle = 0;
        Predicate<String> check_if_space = sign -> sign.equals(" ");

        for (int i = 0; i < selected_letters.size(); i++) {

            if(check_if_space.test(selected_letters.get(i).getSign())){      //selected_letters.get(i).getSign().equals(" ")
                color_three_strips(g, circle);
                circle++;
                fi+=stepFi * (amount_of_angles_per_one_strip) * 3;        //*3, bo "cofamy" trzy szare stripy

            }else{
                color_three_strips(g, circle);
                color_seven_strips(g, circle, i);
            }
        }
        g.setColor(Color.BLACK);
    }


    private void color_three_strips(Graphics g, int circle){
        g.setColor(new Color(96, 102, 122));

        for (int i = 0; i < 3; i++) {
            fill_strip(g, circle);
        }
    }

    private void color_seven_strips(Graphics g, int circle, int word_index){

        for (int i = 0; i < 7; i++) {
            if(selected_letters.get(word_index).getBinary_code().charAt(i) == '0'){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(Color.RED);
            }

            fill_strip(g, circle);
        }
    }

    private void fill_strip(Graphics g, int circle){

        for (int j = 0; j < (amount_of_angles_per_one_strip); j++) {
            g.drawLine(
                    (int) (start_x - (circle)*(Math.sin(fi) * (radius/get_amount_of_circles(args)))),
                    (int) (start_y - (circle)*(Math.cos(fi) * (radius/get_amount_of_circles(args)))),
                    (int) (start_x - (Math.sin(fi) * (circle + 1) * (radius/get_amount_of_circles(args)))),
                    (int) (start_y - (Math.cos(fi) * (circle + 1) * (radius/get_amount_of_circles(args))))
            );

            fi-=stepFi;
        }
    }

    private void color_comment_elements_of_segments(Graphics g){
        //Największy ogrąg - "zakomentowanie" pustych fragmentów (DARE....)
        Circle circle = new Circle(args);
        g.setColor(new Color(95, 62, 81));
        g.fillOval(
                (circle.getX()), (circle.getY()),
                (int)(radius*2), (int)(radius*2)
        );
    }
}