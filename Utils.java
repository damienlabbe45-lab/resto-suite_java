import java.util.Scanner;

public class Utils {
    public static int InputInt(Scanner input) {
        while (!input.hasNextInt()) {
            input.next();
        }
        return input.nextInt();
    }

    public static int InputChoice(Scanner input, int max) {
        int choiceuser = InputInt(input);
        while (choiceuser < 1 || choiceuser > max) {
            choiceuser = InputInt(input);
        }
        return choiceuser - 1;
    }
}
