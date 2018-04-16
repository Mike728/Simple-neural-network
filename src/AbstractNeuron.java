abstract class AbstractNeuron {

    abstract public double result(double[] x);
    abstract public String getName();
    abstract public void train(double[] x, double expectedAnswer, double learnRate);
}
