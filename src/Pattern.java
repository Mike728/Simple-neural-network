import java.util.ArrayList;
import java.util.Random;

public class Pattern extends AbstractResult {
    private static final Random R = new Random();
    private final ArrayList<AbstractResult> responders = new ArrayList<>();
    private String name;

    public void addBarrier(AbstractResult ans) {
        responders.add(ans);
    }

    public Pattern(String name) {
        this.name = name;
    }

    public double getRandom() {
        return R.nextDouble() * 2 - 1;
    }

    @Override
    public double result(double[] x) {
        boolean result = false;

        for (AbstractResult ans : responders) {
            if (ans.result(x) == 1) {
                return 1; // Drukuj 1
            } else if (ans.result(x) == -1) {
                return -1; // Drukuj 0
            } else
                return 0;
        }
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

}
