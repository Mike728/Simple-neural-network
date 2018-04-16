import java.util.ArrayList;

public class Perceptron extends AbstractResult {
    private final String name;
    private double[] weights;
    private final ArrayList<AbstractNeuron> NeuronList = new ArrayList<>();

    public Perceptron() {
        name = "Perceptron";
    }

    public void addNeuron(AbstractNeuron NL) {
        NeuronList.add(NL);
    }

    public void train(double[] x, double expectedAnswer, double learnRate) {
        NeuronList.forEach(n -> n.train(x, expectedAnswer, learnRate));
    }

    @Override
    public double result(double[] x) {
        if (NeuronList.get(0).result(x) > 0 || NeuronList.get(1).result(x) < 0) {
            return 1;
        } else
            return 0;
    }

    @Override
    public String getName() {
        return name;
    }


}
