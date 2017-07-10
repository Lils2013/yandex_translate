package alexander.tsoy;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phrase");
        String input = scanner.nextLine();
        List<String> output = Translator.translate(input);
        if (output == null) {
            System.out.println("Could not translate!!");
        } else {
            System.out.println(output);
        }
    }
}
