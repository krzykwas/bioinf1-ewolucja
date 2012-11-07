/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pg.eti.kams.bioinfewolucja2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

/**
 *
 * @author krzykwas
 */
public class Kalkulator {

    private final List<Symbol> symbole = new ArrayList<Symbol>();
    private final Map<Symbol, Integer> reverse = new HashMap<Symbol, Integer>();
    private final DoubleMatrix A = new DoubleMatrix();

    public Kalkulator() {
    }

    public void wczytajDane() {
        symbole.clear();
        reverse.clear();

        Scanner scanner = new Scanner(System.in);
        int i = 0;

        for (String s : scanner.nextLine().split(" ")) {
            Symbol symbol = new Symbol(s);
            symbole.add(symbol);
            reverse.put(symbol, i);
            i++;
        }

        A.resize(symbole.size(), symbole.size());

        for (int j = 0; j < symbole.size(); j++) {
            for (int k = 0; k < symbole.size(); k++) {
                A.put(new int[]{j}, k, scanner.nextDouble());
            }
        }

        obliczPrawdopodobienstwaWystapieniaSymboli();
    }

    /**
     * TODO: obliczyć prawdopodobieństwa na podstawie dowolnego wiersza/kolumny
     * eA.
     */
    private void obliczPrawdopodobienstwaWystapieniaSymboli() {
        DoubleMatrix eA = MatrixFunctions.expm(A);
        System.out.println(eA);
    }
}
