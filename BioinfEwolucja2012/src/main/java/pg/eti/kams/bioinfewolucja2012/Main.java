package pg.eti.kams.bioinfewolucja2012;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        DoubleMatrix matrix = new DoubleMatrix(2, 2);
        matrix.put(0, 1.3);
        matrix.put(1, 2.4);
        matrix.put(2, 0.7774);
        matrix.put(3, 3.4);

        System.out.println(matrix);

        matrix = MatrixFunctions.expm(matrix);
        System.out.println(matrix);
    }
}
