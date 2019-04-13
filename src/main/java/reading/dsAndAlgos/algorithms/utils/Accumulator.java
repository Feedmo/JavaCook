package reading.dsAndAlgos.algorithms.utils;

/**
 * Created by simpl on 2018/2/6.
 */
public class Accumulator {
    private double total;
    private int N;

    public void addValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return (total/N);
    }

    @Override
    public String toString() {
        return "Mean ("+N+" values): "+String.format("%7.5f", mean());
    }
}
