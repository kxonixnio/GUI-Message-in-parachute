import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Stream;

public class MyFrame
        extends Frame
        implements ConstantData{

    private static Circle circle;
    private static Line line;
    private static SoComePaintMyWorld soComePaintMyWorld;

    public static void main(String[] args) {
        new MyFrame();

        Stream<String> args_stream = Stream.of(args);
        args = args_stream.map((s -> s.toUpperCase().trim())).        //trim -> usunięcie zbędnych spacji
                toArray(s -> new String[s]);

        RecognizeLetters recognizeLetters = new RecognizeLetters(args);
        List<Letter> selected_letters = recognizeLetters.return_selected_letters();

        for(Letter letter : selected_letters)       //używany iterator, choć nie jest nigdzie jawnie zapisany
            System.out.println(letter);

        circle = new Circle(args);
        line = new Line(args);
        soComePaintMyWorld = new SoComePaintMyWorld(selected_letters, args);
    }

    public MyFrame(){
        setSize(dimension, dimension);
        setVisible(true);
        setBackground(new Color(65, 73, 96));

        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                }
        );
    }

    public void paint(Graphics g){
        try{
            soComePaintMyWorld.color_all_segments(g);
            line.draw_all_lines(g);
            circle.draw_all_circles(g);
        }catch (NullPointerException npe){
            paint(g);
        }
    }
}