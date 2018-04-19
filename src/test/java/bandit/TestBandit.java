package bandit;

import java.util.Random;

/**
 * Created by takun on 17/04/2018.
 */
public class TestBandit {

    static long seed = System.currentTimeMillis() ;
    static Random random = new Random(seed) ;

    public static int bernoulli(double p) {
        double r = random.nextDouble() ;
        if(r < p) {
            return 1 ;
        }
        return 0 ;
    }

    public static double score(AbstractBandit b, int[] win, int i) {
        if(b.trial(i) == 0) return 0.0 ;
        return (double) win[i] / b.trial(i) ;
    }

    public static void main(String[] args) {
        int k = 5 ;
        double[] p = new double[k] ;
        for(int i = 0 ; i < k ; i++) {
            p[i] = random.nextDouble() ;
            System.out.println(p[i]);
        }
        int[] win = new int[k] ;

        System.out.println("======================================");
//        AbstractBandit ts = new ThompsonSampling(k) ;
//        AbstractBandit ts = new UCB(k) ;
        AbstractBandit ts = new EpsilonGreedy(k, 0.3) ;
        for(int i = 0; i < 1000; i++) {
            int n = ts.select() ;
            int b = bernoulli(p[n]) ;
            win[n] += b ;
            ts.update(n, b);
        }
        for(int i = 0; i < k; i++) {
            System.out.println(score(ts, win, i) + "   : trials " + ts.trial(i) + "  , value: " + ts.score(i));

        }
    }

}