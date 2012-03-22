/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

/**
 *
 * @author kala
 */
public interface VarastoRajapinta {
    
    public Tuote haeTuote(int id);
    
    public int saldo(int id);
    
    public void otaVarastosta(Tuote t);
    
    public void palautaVarastoon(Tuote t);
    
}
