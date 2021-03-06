/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pg.eti.kams.bioinfewolucja2012;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author krzykwas
 */
public class OknoGlowne extends javax.swing.JFrame {

    private final List<Symbol> symbole = new ArrayList<Symbol>();
    private final List<Symbol> nicA = new ArrayList<Symbol>();
    private final List<Symbol> nicB = new ArrayList<Symbol>();
    private Kalkulator kalkulator;

    /**
     * Creates new form OknoGlowne
     */
    public OknoGlowne() {
        initComponents();
        wczytajDane();
        wypiszPrawdopodobienstwaSymboli();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        poczatekPrzedzialuJTextField = new javax.swing.JTextField();
        koniecPrzedzialuJTextField = new javax.swing.JTextField();
        krokJTextField = new javax.swing.JTextField();
        znajdzMaksimumJButton = new javax.swing.JButton();
        maksimumJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        prawdopodobienstwaJTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        zakonczJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Początek przedziału:");

        jLabel2.setText("Koniec przedziału:");

        jLabel3.setText("Krok:");

        jLabel4.setText("Maksimum:");

        znajdzMaksimumJButton.setText("Znajdź maksimum");
        znajdzMaksimumJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                znajdzMaksimumJButtonActionPerformed(evt);
            }
        });

        maksimumJTextField.setEditable(false);

        prawdopodobienstwaJTextArea.setEditable(false);
        prawdopodobienstwaJTextArea.setColumns(20);
        prawdopodobienstwaJTextArea.setRows(5);
        jScrollPane1.setViewportView(prawdopodobienstwaJTextArea);

        jMenu1.setText("Plik");

        zakonczJMenuItem.setText("Zakończ");
        zakonczJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zakonczJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(zakonczJMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(znajdzMaksimumJButton)
                            .addComponent(maksimumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(koniecPrzedzialuJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(poczatekPrzedzialuJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(krokJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(poczatekPrzedzialuJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(koniecPrzedzialuJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(krokJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(znajdzMaksimumJButton)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(maksimumJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zakonczJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zakonczJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_zakonczJMenuItemActionPerformed

    private void znajdzMaksimumJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_znajdzMaksimumJButtonActionPerformed
        try {
            double x = Double.parseDouble(poczatekPrzedzialuJTextField.getText());
            double y = Double.parseDouble(koniecPrzedzialuJTextField.getText());
            double krok = Double.parseDouble(krokJTextField.getText());

            if (y <= x || krok <= 0) {
                throw new IllegalArgumentException();
            }

            List<Double> prawdopodobienstwa = new ArrayList<Double>();
            double t = kalkulator.obliczCzas(nicA, nicB, x, y, krok, prawdopodobienstwa);

            maksimumJTextField.setText(String.format("%.6f", t));

            StringBuilder sb = new StringBuilder();
            int i = 1;

            for (double prawdopodobienstwo : prawdopodobienstwa) {
                sb.append(i).append("\t");
                sb.append(String.format("%.6f", x + krok * (i - 1))).append("\t");
                sb.append(String.format("%.8f", prawdopodobienstwo)).append("\n");

                i++;
            }

            prawdopodobienstwaJTextArea.setText(sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Podaj poprawny przedział.");
        }
    }//GEN-LAST:event_znajdzMaksimumJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OknoGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoGlowne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OknoGlowne().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField koniecPrzedzialuJTextField;
    private javax.swing.JTextField krokJTextField;
    private javax.swing.JTextField maksimumJTextField;
    private javax.swing.JTextField poczatekPrzedzialuJTextField;
    private javax.swing.JTextArea prawdopodobienstwaJTextArea;
    private javax.swing.JMenuItem zakonczJMenuItem;
    private javax.swing.JButton znajdzMaksimumJButton;
    // End of variables declaration//GEN-END:variables

    private void wczytajSymbole(String linia) {
        for (String s : linia.split(" ")) {
            final Symbol symbol = new Symbol(s);
            if (!symbole.contains(symbol)) {
                symbole.add(symbol);
            }
        }
    }

    private double[][] wczytajMacierzSzybkosciZmian(Scanner scanner, int n) {
        double[][] R = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                R[i][j] = scanner.nextDouble();
            }
        }

        return R;
    }

    private void wczytajNici(Scanner scanner, Kalkulator kalkulator) {
        scanner.nextLine();

        for (String s : scanner.nextLine().split(" ")) {
            nicA.add(kalkulator.getSymbol(s));
        }

        for (int i = 0; i < nicA.size(); i++) {
            nicB.add(kalkulator.getSymbol(scanner.next()));
        }
    }

    private void wypiszPrawdopodobienstwaSymboli() {
        for (Symbol symbol : symbole) {
            System.out.println("Symbol " + symbol.getSymbol() + ": " + symbol.getPrawdopodobienstwo());
        }
    }

    private void wczytajDane() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        wczytajSymbole(scanner.nextLine());
        double[][] R = wczytajMacierzSzybkosciZmian(scanner, symbole.size());
        kalkulator = new Kalkulator(symbole, R);
        wczytajNici(scanner, kalkulator);
    }
}
