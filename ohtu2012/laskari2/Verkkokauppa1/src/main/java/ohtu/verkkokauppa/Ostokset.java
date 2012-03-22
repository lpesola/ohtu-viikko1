/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

/**
 *
 * @author kala
 */
public interface Ostokset {

    public void lisaa(Tuote t);

    public void poista(Tuote t);

    public int hinta();
}
