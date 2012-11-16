/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pg.eti.kams.bioinfewolucja2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

/**
 *
 * @author krzykwas
 */
public class Kalkulator {

    private final List<Symbol> symbole = new ArrayList<Symbol>();
    private final Map<Symbol, Integer> reverse = new HashMap<Symbol, Integer>();
    private final DoubleMatrix R = new DoubleMatrix();

    public Kalkulator(List<Symbol> symbole, double[][] R) {
        for (Symbol symbol : symbole) {
            dodajSymbol(symbol);
        }

        this.R.resize(this.symbole.size(), this.symbole.size());

        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[i].length; j++) {
                this.R.put(new int[]{i}, j, R[i][j]);
            }
        }

        obliczPrawdopodobienstwoSymboli();
    }

    public List<Symbol> getSymbole() {
        return symbole;
    }

    public Symbol getSymbol(String s) {
        for (Symbol symbol : symbole) {
            if (symbol.getSymbol().equals(s)) {
                return symbol;
            }
        }

        return null;
    }

    private void dodajSymbol(Symbol symbol) {
        if (!reverse.containsKey(symbol)) {
            int n = symbole.size();
            symbole.add(symbol);
            reverse.put(symbol, n);
        }
    }

    private void obliczPrawdopodobienstwoSymboli() {
        DoubleMatrix A = MatrixFunctions.expm(R);
        final double E = 1e-5;

        for (int t = 2; t < 1000; t++) {
            final DoubleMatrix B = MatrixFunctions.expm(R.mul(t));

            if (Math.abs(B.distance2(A)) < E) {
                break;
            } else {
                A = B;
            }
        }

        DoubleMatrix column = A.getColumn(0);

        double suma = 0;
        for (double d : column.data) {
            suma += d;
        }

        for (int i = 0; i < column.data.length; i++) {
            symbole.get(i).setPrawdopodobienstwo(column.data[i] / suma);
        }
    }

    public double obliczCzas(List<Symbol> nicA, List<Symbol> nicB, double x, double y, double krok, List<Double> prawdopodobienstwa) {
        double czasEwolucji = 0;
        double maksP = -Double.MAX_VALUE;

        for (double t = x; t < y; t += krok) {
            DoubleMatrix P = MatrixFunctions.expm(R.mul(t));
            double p = oszacujPrawdopodobienstwo(P, nicA, nicB);
            prawdopodobienstwa.add(p);

            if (p > maksP) {
                maksP = p;
                czasEwolucji = t;
            }
        }

        return czasEwolucji;
    }

    private double oszacujPrawdopodobienstwo(DoubleMatrix P, List<Symbol> nicA, List<Symbol> nicB) {
        double p = 0;

        for (int i = 0; i < nicA.size(); i++) {
            final Symbol xi = nicA.get(i);
            final Symbol yi = nicB.get(i);

            p += Math.log(xi.getPrawdopodobienstwo() * P.get(reverse.get(yi), reverse.get(xi)));
        }

        return p;
    }
}
