public interface ConstantData {

    int dimension = 800;
    int start_x = (dimension / 2);
    int start_y = (dimension / 2);
    double radius = (dimension / 2) - 100;
    int amount_of_single_elements_in_one_sector = 10;

    default int get_amount_of_circles(String[]args){
        return args.length;
    }

    default int get_amount_of_segments(String[]args){
        int max_length = 0;

        for (int i = 0; i < args.length; i++) {
            max_length = Math.max(max_length, args[i].length());
        }

        return max_length;
    }
}
