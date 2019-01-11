package mandatory2.src.test.java.no.uib.ii.inf102.f18.mandatory2;

import mandatory2.src.main.java.no.uib.ii.inf102.f18.mandatory2.BigOpartII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Torstein Strømme
 */
public class BigOpartIITest {

    private BigOpartII bigO;

    @BeforeEach
    void createArray() {
        this.bigO = new BigOpartII();
    }

    @Test
    void testA() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                this.bigO.p(i, j);
                System.out.printf("n = %d, m = %d, steps = %d, logn = %d, fact = %d%n",
                        i, j, bigO.tally(), (int) (Math.log(i)/Math.log(2)), factorial(i+j));
//                assertEquals(funcA(i, j), this.bigO.tally());
            }
        }
    }

    private int funcA(int n, int m) {
        return 1 + (m * factorial(n - 1));
    }

    int factorial(int n){
        if (n == 0) return 0;
        else return(n * factorial(n-1));
    }
}

/*
n = 3, m = 4, steps = 21, logn = 1, fact = 0
n = 3, m = 5, steps = 31, logn = 1, fact = 0
n = 4, m = 1, steps = 4, logn = 2, fact = 0
n = 4, m = 2, steps = 15, logn = 2, fact = 0
n = 4, m = 3, steps = 40, logn = 2, fact = 0
n = 4, m = 4, steps = 85, logn = 2, fact = 0
n = 4, m = 5, steps = 156, logn = 2, fact = 0
n = 5, m = 1, steps = 5, logn = 2, fact = 0
n = 5, m = 2, steps = 31, logn = 2, fact = 0
n = 5, m = 3, steps = 121, logn = 2, fact = 0
n = 5, m = 4, steps = 341, logn = 2, fact = 0
n = 5, m = 5, steps = 781, logn = 2, fact = 0
 */
