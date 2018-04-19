package bandit;


import java.util.Random;

/**
 * Created by takun on 16/04/2018.
 */
public abstract class AbstractBandit implements Bandit{

    private double[] values;
    private int[] trials;
    protected int k ;
    protected Random random ;

    protected AbstractBandit(int k) {
        this(k, System.currentTimeMillis()) ;
    }

    protected AbstractBandit(int k, long seed) {
        values = new double[k] ;
        trials = new int[k] ;
        this.k = k ;
        random = new Random(seed) ;
    }

    public double score(int i) {
        if(trials[i] == 0) return 0.0 ;
        return values[i] / trials[i];
    }

    public double cumulateScore(int i) {
        return values[i] ;
    }

    public int trial(int i) {
        return trials[i] ;
    }

    public int select() {
        int maxI = 0 ;
        double[] y = expections() ;
        for(int i = 1; i < k; i++) {
            if(y[i] > y[maxI]) {
                maxI = i ;
            }
        }
        trials[maxI] += 1 ;
        return maxI ;
    }

    public void update(int i, double reward) {
        values[i] += reward ;
    }

    protected abstract double[] expections() ;

}
