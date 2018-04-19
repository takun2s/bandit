package bandit;

import org.apache.commons.math3.distribution.BetaDistribution;


/**
 * Created by takun on 17/04/2018.
 */
public class ThompsonSampling extends AbstractBandit {

    public ThompsonSampling(int k) {
        super(k);
    }

    public ThompsonSampling(int k, long seed) {
        super(k, seed);
    }

    protected double[] expections() {
        double x = random.nextDouble() ;
        double[] y = new double[k] ;
        for(int i = 0; i < k; i++) {
            double a = 1 + cumulateScore(i) ;
            double b = 1 + trial(i) - cumulateScore(i) ;
            BetaDistribution beta = new BetaDistribution(a, b) ;
            y[i] = beta.inverseCumulativeProbability(x) ;
        }
        return y ;
    }
}