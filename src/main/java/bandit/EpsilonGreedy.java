package bandit;


/**
 * Created by takun on 19/04/2018.
 */
public class EpsilonGreedy extends AbstractBandit {

    private double epsilon ;
    public EpsilonGreedy(int k, double epsilon) {
        super(k);
        this.epsilon = epsilon ;
    }

    public EpsilonGreedy(int k, double epsilon, long seed) {
        super(k, seed);
        this.epsilon = epsilon ;
    }

    protected double[] expections() {
        double r = random.nextDouble() ;
        double[] y = new double[k] ;
        if(r > epsilon) {
            for(int i = 0; i < k; i++) {
                y[i] = score(i) ;
            }
        }else{
            int random_next = random.nextInt(k) ;
            y[random_next] = 0.1 ;
        }
        return y;
    }
}
