import java.util.ArrayList;

public class ConsoleLogger {

    private final ArrayList<AbstractResult> responders = new ArrayList<>();

    public void addResponder(AbstractResult ans) {
        responders.add(ans);
    }

    public void printResults() {
        printNames();

        for (double y = 1.0; y > -1.1; y -= 0.1) {
            for (AbstractResult ans : responders) {
                for (double x = -1.0; x < 1.0; x += 0.1) {
                    printSingleAnswer(ans, x, y);
                }
                System.out.print("    ");
            }
            System.out.println("");
        }
    }

    private void printSingleAnswer(AbstractResult ans, double x, double y) {
        double[] d = new double[2];
        d[0] = x;
        d[1] = y;
        if (ans.result(d) == 1 || ans.result(d) == -1) {
            System.out.print("X ");
        } else {
            System.out.print("| ");
        }
    }

    private void printNames() {
        System.out.println("");
        responders.forEach(n -> System.out.print(String.format("%-46s", n.getName())));
        System.out.println("");
    }
}
