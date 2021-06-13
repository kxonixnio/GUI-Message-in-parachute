import java.util.*;

public class RecognizeLetters {

    private final String[] args;

    RecognizeLetters(String[] args) {
        this.args = args;
    }

    public List<Letter> return_selected_letters(){

        List<Character> singleLetters = transform_arg_to_single_list();
        List<Letter> selected_letters = new ArrayList<>();

        for (int i = 0; i < singleLetters.size(); i++) {
            switch(singleLetters.get(i)){
                case 'A' -> {
                    selected_letters.add(new Letter("A", "0000001"));
                }
                case 'B' -> {
                    selected_letters.add(new Letter("B", "0000010"));
                }
                case 'C' -> {
                    selected_letters.add(new Letter("C", "0000011"));
                }
                case 'D' -> {
                    selected_letters.add(new Letter("D", "0000100"));
                }
                case 'E' -> {
                    selected_letters.add(new Letter("E", "0000101"));
                }
                case 'F' -> {
                    selected_letters.add(new Letter("F", "0000110"));
                }
                case 'G' -> {
                    selected_letters.add(new Letter("G", "0000111"));
                }
                case 'H' -> {
                    selected_letters.add(new Letter("H", "0001000"));
                }
                case 'I' -> {
                    selected_letters.add(new Letter("I", "0001001"));
                }
                case 'J' -> {
                    selected_letters.add(new Letter("J", "0001010"));
                }
                case 'K' -> {
                    selected_letters.add(new Letter("K", "0001011"));
                }
                case 'L' -> {
                    selected_letters.add(new Letter("L", "0001100"));
                }
                case 'M' -> {
                    selected_letters.add(new Letter("M", "0001101"));
                }
                case 'N' -> {
                    selected_letters.add(new Letter("N", "0001110"));
                }
                case 'O' -> {
                    selected_letters.add(new Letter("O", "0001111"));
                }
                case 'P' -> {
                    selected_letters.add(new Letter("P", "0010000"));
                }
                case 'Q' -> {
                    selected_letters.add(new Letter("Q", "0010001"));
                }
                case 'R' -> {
                    selected_letters.add(new Letter("R", "0010010"));
                }
                case 'S' -> {
                    selected_letters.add(new Letter("S", "0010011"));
                }
                case 'T' -> {
                    selected_letters.add(new Letter("T", "0010100"));
                }
                case 'U' -> {
                    selected_letters.add(new Letter("U", "0010101"));
                }
                case 'V' -> {
                    selected_letters.add(new Letter("V", "0010110"));
                }
                case 'W' -> {
                    selected_letters.add(new Letter("W", "0010111"));
                }
                case 'X' -> {
                    selected_letters.add(new Letter("X", "0011000"));
                }
                case 'Y' -> {
                    selected_letters.add(new Letter("Y", "0011001"));
                }
                case 'Z' -> {
                    selected_letters.add(new Letter("Z", "0011010"));
                }
                default -> {
                    selected_letters.add(new Letter(" ", " "));     //spacja
                }
            }
        }
        return selected_letters;
    }

    public List<Character> transform_arg_to_single_list(){
        int amount_of_words = args.length;
        List<Character> message_separeted_to_single_letters = new ArrayList<>();

        for (int i = 0; i < amount_of_words; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                message_separeted_to_single_letters.add(args[i].charAt(j));
            }
            if(i != amount_of_words - 1){
                message_separeted_to_single_letters.add(' ');   //wyeliminowanie spacji po ostatnim wyrazie
            }
        }

        return message_separeted_to_single_letters;
    }
    
}

/*
    1. Przekształcenie args na listę pojedynczych znaków
    2. Przekształcenie listy pojedynczych znaków, na listę Letter, gdzie każda litera "otrzymuje" dodatkowo swój kod
 */