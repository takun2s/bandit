package bandit;

/**
 * Created by takun on 19/04/2018.
 */
public interface Bandit {

    double score(int i) ;

    double cumulateScore(int i) ;

    int select() ;

    void update(int i, double reward) ;
}
