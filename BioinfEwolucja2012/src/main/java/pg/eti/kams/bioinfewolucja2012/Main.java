package pg.eti.kams.bioinfewolucja2012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Symbol> symbole = new ArrayList<Symbol>();
        wczytajSymbole(scanner, symbole);
        double[][] prawdopodobienstwa = new double[symbole.size()][symbole.size()];
        wczytajPrawdopodobienstwa(symbole.size(), prawdopodobienstwa, scanner);

        Kalkulator kalkulator = new Kalkulator(symbole, prawdopodobienstwa);
    }

    protected static void wczytajSymbole(Scanner scanner, List<Symbol> symbole) {
        for (String s : scanner.nextLine().split(" ")) {
            final Symbol symbol = new Symbol(s);
            if (!symbole.contains(symbol)) {
                symbole.add(symbol);
            }
        }
    }

    protected static void wczytajPrawdopodobienstwa(int n, double[][] prawdopodobienstwa, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prawdopodobienstwa[i][j] = scanner.nextDouble();
            }
        }
    }
}
