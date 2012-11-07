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
    private double prawdopodobienstwoWystapienia;

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

    public double getPrawdopodobienstwoWystapienia() {
        return prawdopodobienstwoWystapienia;
    }

    public void setPrawdopodobienstwoWystapienia(double prawdopodobienstwoWystapienia) {
        this.prawdopodobienstwoWystapienia = prawdopodobienstwoWystapienia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.symbol != null ? this.symbol.hashCode() : 0);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.prawdopodobienstwoWystapienia) ^ (Double.doubleToLongBits(this.prawdopodobienstwoWystapienia) >>> 32));
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
        if (Double.doubleToLongBits(this.prawdopodobienstwoWystapienia) != Double.doubleToLongBits(other.prawdopodobienstwoWystapienia)) {
            return false;
        }
        return true;
    }
}
