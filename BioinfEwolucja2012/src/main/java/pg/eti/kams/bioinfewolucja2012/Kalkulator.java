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

        for (Symbol symbol : symbole) {
            System.out.println(symbol.getPrawdopodobienstwo());
        }
    }

    private void dodajSymbol(Symbol symbol) {
        if (!reverse.containsKey(symbol)) {
            int n = symbole.size();
            symbole.add(symbol);
            reverse.put(symbol, n);
        }
    }

    private void obliczPrawdopodobienstwoSymboli() {
        DoubleMatrix eR = MatrixFunctions.expm(R);
        DoubleMatrix column = eR.getColumn(0);

        double suma = 0;
        for (double d : column.data) {
            suma += d;
        }

        for (int i = 0; i < column.data.length; i++) {
            symbole.get(i).setPrawdopodobienstwo(column.data[i] / suma);
        }
    }
}
