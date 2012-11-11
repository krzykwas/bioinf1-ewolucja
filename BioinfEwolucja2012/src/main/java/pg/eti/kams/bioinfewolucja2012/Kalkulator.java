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

    public Kalkulator(List<Symbol> symbole, double[][] prawdopodobienstwa) {
        for (Symbol symbol : symbole) {
            dodajSymbol(symbol);
        }

        R.resize(this.symbole.size(), this.symbole.size());

        for (int i = 0; i < prawdopodobienstwa.length; i++) {
            for (int j = 0; j < prawdopodobienstwa[i].length; j++) {
                R.put(new int[]{i}, j, prawdopodobienstwa[i][j]);
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
        DoubleMatrix P = MatrixFunctions.expm(R);
        DoubleMatrix column = P.getColumn(0);

        double suma = 0;
        for (double d : column.data) {
            suma += d;
        }

        for (int i = 0; i < column.data.length; i++) {
            symbole.get(i).setPrawdopodobienstwo(column.data[i] / suma);
        }
    }

    public double obliczCzas(List<Symbol> nicA, List<Symbol> nicB) {
        double czasEwolucji = 0;
        double maksP = -Double.MAX_VALUE;

        for (double t = 0.1; t < 50; t += 0.1) {
            DoubleMatrix P = MatrixFunctions.expm(R.mul(t));
            double p = oszacujPrawdopodobienstwo(P, nicA, nicB);
            System.out.println(p);

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
