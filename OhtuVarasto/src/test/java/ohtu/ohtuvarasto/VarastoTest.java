
package ohtu.ohtuvarasto;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
 
public class VarastoTest {
 
    Varasto varasto;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void konstruktoriLuoNegatiivisenVaraston() {
        Varasto negatiivinenVarasto = new Varasto(-10);
        assertEquals(0, negatiivinenVarasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void luodaanVarastoSaldollaOikein(){
        Varasto saldollinenVarasto = new Varasto(10, 5);
        boolean oikein = false;
        if (saldollinenVarasto.getSaldo()==5 && saldollinenVarasto.getTilavuus() == 10) {
            oikein = true;
        }
        assertEquals(true, oikein);
    }

    @Test
    public void PositiivinenSaldoNegatiivinenTilavuus(){
        Varasto saldollinenVarasto = new Varasto(-1, 5);
        assertEquals(0.0, saldollinenVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void TilavuusOikeinSaldoNegatiivinen(){
        Varasto saldollinenVarasto = new Varasto (5, -1);
        assertEquals(0.0, saldollinenVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void lisätäänNegatiivinenMäärä() {
        varasto.lisaaVarastoon(-2);
        
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisätäänEnemmänKuinMahtuu() {
        varasto.lisaaVarastoon(50);
        
        assertEquals(10.0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void otetaanEnemmänKuinOnVieKaiken() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(10);
        // varastossa pitäisi olla 0.0
             assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void otetaanNegatiivinenMäärä() {
        varasto.lisaaVarastoon(5);
        
        assertEquals(0.0, varasto.otaVarastosta(-2), vertailuTarkkuus);
    }
    
    @Test
    public void tulostetaanTekstiOikein() {
        //rikottu
        varasto.lisaaVarastoon(10);
        String oletustuloste = "saldo = 10.0, vielä tilaa 0.0";
        boolean oikein = varasto.toString().equalsIgnoreCase(oletustuloste);
        assertEquals(true, oikein);
    }
}