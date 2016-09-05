import java.util.Scanner;

/**
 * @author crkimberley on 05/09/2016.
 */
public class Marks {
    public static void main(String[] args) {
        Marks marks = new Marks();
        marks.launch();
    }

    private void launch() {
        Scanner input = new Scanner(System.in);
        int mk;
        int markCount = -1;
        int invalidCount = 0;
        int distinctionCount = 0;
        int passCount = 0;
        int failCount = 0;
        do {
            System.out.print("Enter mark (-1 to stop): ");
            mk = input.nextInt();
            markCount++;
            if (mk < -1 || mk > 100) {
                invalidCount++;
            } else if (mk >= 70) {
                distinctionCount++;
            } else if (mk >= 50) {
                passCount++;
            } else if (mk >= 0) {
                failCount++;
            }
        } while (mk != -1);
        System.out.println("Total number of marks = " + markCount);
        System.out.println("Distinctions: " + distinctionCount);
        System.out.println("Passes: " + passCount);
        System.out.println("Fails: " + failCount);
        System.out.println("Invalid: " + invalidCount);
    }
}
