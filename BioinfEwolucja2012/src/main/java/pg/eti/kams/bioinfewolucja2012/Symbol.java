/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pg.eti.kams.bioinfewolucja2012;

/**
 *
 * @author krzykwas
 */
public class Symbol {

    private String symbol;
    /**
     * Prawdopodobieństwo wystąpienia tego symbolu w tekście obliczane za pomocą
     * eksponenty macierzy szybkości zmian.
     */
    private double prawdopodobienstwo;

    public Symbol() {
    }

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrawdopodobienstwo() {
        return prawdopodobienstwo;
    }

    public void setPrawdopodobienstwo(double prawdopodobienstwo) {
        this.prawdopodobienstwo = prawdopodobienstwo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.symbol != null ? this.symbol.hashCode() : 0);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.prawdopodobienstwo) ^ (Double.doubleToLongBits(this.prawdopodobienstwo) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Symbol other = (Symbol) obj;
        if ((this.symbol == null) ? (other.symbol != null) : !this.symbol.equals(other.symbol)) {
            return false;
        }
        if (Double.doubleToLongBits(this.prawdopodobienstwo) != Double.doubleToLongBits(other.prawdopodobienstwo)) {
            return false;
        }
        return true;
    }
}
