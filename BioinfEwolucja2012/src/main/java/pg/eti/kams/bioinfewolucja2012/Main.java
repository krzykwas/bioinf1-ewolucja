package pg.eti.kams.bioinfewolucja2012;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        final List<Symbol> symbole = new ArrayList<Symbol>();
        final List<Symbol> nicA = new ArrayList<Symbol>();
        final List<Symbol> nicB = new ArrayList<Symbol>();

        wczytajSymbole(scanner.nextLine(), symbole);
        double[][] prawdopodobienstwa = wczytajMacierzSzybkosciZmian(scanner, symbole.size());

        Kalkulator kalkulator = new Kalkulator(symbole, prawdopodobienstwa);

        wczytajNici(scanner, kalkulator, nicA, nicB);
        double t = kalkulator.obliczCzas(nicA, nicB);

        System.out.println(t);
    }

    private static void wczytajSymbole(String linia, List<Symbol> symbole) {
        for (String s : linia.split(" ")) {
            final Symbol symbol = new Symbol(s);
            if (!symbole.contains(symbol)) {
                symbole.add(symbol);
            }
        }
    }

    private static double[][] wczytajMacierzSzybkosciZmian(Scanner scanner, int n) {
        double[][] prawdopodobienstwa = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prawdopodobienstwa[i][j] = scanner.nextDouble();
            }
        }

        return prawdopodobienstwa;
    }

    private static void wczytajNici(Scanner scanner, Kalkulator kalkulator, List<Symbol> nicA, List<Symbol> nicB) {
        scanner.nextLine();

        for (String s : scanner.nextLine().split(" ")) {
            nicA.add(kalkulator.getSymbol(s));
        }

        for (int i = 0; i < nicA.size(); i++) {
            nicB.add(kalkulator.getSymbol(scanner.next()));
        }
    }
}
