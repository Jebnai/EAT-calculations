import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author jenai
 * Class to do my Operating Systems coursework.
 */
public class AccessTime {
    /**
     * Calculates EAT QUESTION 2
     * @param r RAM size in GiB
     * @param d Disk size in MiB/s
     * @return Returns the 'Effective Access Time'
     */
    public static double calculateEAT(double r, double d) {
        double eat = 200E-9 + ((1.7E-6 + (4.6E-5 / r)) * ((1.2E-4 + (0.39 / d))));
        BigDecimal eatSig = new BigDecimal(eat);
        eatSig = eatSig.round(new MathContext(3));
        double roundedEAT = eatSig.doubleValue();

        return eat;
    }

    /**
     * Calculates performance degradation QUESTION 3
     * @param eat 'Effective Access Time'
     * @return Returns the degradation as a percentage
     */
    public static double performanceDegradation(double eat){
        double degradation = ((eat) - (200E-9))/(200E-9);
        BigDecimal degSig = new BigDecimal(degradation);
        degSig = degSig.round(new MathContext(3));
        double rounded = degSig.doubleValue();
        return rounded*100;
    }

    public static void main(String[] args) {
        System.out.println(calculateEAT(4, 420));
        System.out.println(performanceDegradation(calculateEAT(4, 120)));
    }
}

