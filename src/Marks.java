import java.util.Scanner;

/**
 * @author crkimberley on 05/09/2016.
 */
public class Marks {
    private final static int MINIMUM = 0;
    private final static int MAXIMUM = 100;
    private final static int DISTINCTION = 70;
    private final static int PASS = 50;
    private final static int LIST_END = -1;

    public static void main(String[] args) {
        Marks marks = new Marks();
        marks.launch();
    }

    private void launch() {
        Scanner input = new Scanner(System.in);
        int mk;
        int markCount = 0;
        int invalidCount = -1;
        int distinctionCount = 0;
        int passCount = 0;
        int failCount = 0;
        do {
            System.out.print("Enter mark (-1 to stop): ");
            mk = input.nextInt();
            if (mk < MINIMUM || mk > MAXIMUM) {
                invalidCount++;
            } else {
                markCount++;
                if (mk >= DISTINCTION) {
                    distinctionCount++;
                } else if (mk >= PASS) {
                    passCount++;
                } else {
                    failCount++;
                }
            }
        } while (mk != LIST_END);
        System.out.println("Total number of marks = " + markCount);
        System.out.println("Distinctions: " + distinctionCount);
        System.out.println("Passes: " + passCount);
        System.out.println("Fails: " + failCount);
        System.out.println("Invalid: " + invalidCount);
    }
}
