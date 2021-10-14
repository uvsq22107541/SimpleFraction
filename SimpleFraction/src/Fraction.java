
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Fraction {

    private int numerateur;
    private int denominateur;

    public Fraction(int numerateur,int denominateur) {
        //assert denominateur!=0;
        this.numerateur=numerateur;
        this.denominateur=denominateur;
    }

    public int getdenominateur() {
        return denominateur;
    }

    public int getNumerateur() {
        return numerateur;
    }

    public void setNumerateur(int numerateur) {
        this.numerateur = numerateur;
    }

    public void setdenominateur(int denominateur) {
        this.denominateur = denominateur;
    }

    @Override
    public String toString() {
        return numerateur + "/" + denominateur;
    }

    @Test
    public void testdenominateur(){
        assertNotEquals(this.denominateur,0);

    }

}

