package bandit;

/**
 * Created by takun on 17/04/2018.
 */
public class UCB extends AbstractBandit {

    public UCB(int k) {
        super(k);
    }

    public UCB(int k, long seed) {
        super(k, seed);
    }

    protected double[] expections() {
        double[] y = new double[k] ;
        int n = 0 ;
        for(int i = 0; i < k; i++) {
            n += trial(i) ;
        }
        for(int i = 0; i < k; i++) {
            int trial = 1 + trial(i) ;
            double lnt = 2 * Math.log(n) ;
            double bonus = Math.sqrt(lnt / trial) ;
            y[i] = score(i) + bonus ;
        }
        return y ;
    }
}
