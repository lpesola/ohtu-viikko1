package ohtu;

import ohtu.verkkokauppa.*;

public class Main {

    public static void main(String[] args) {
        
        Viitegeneraattori viitegeneraattori = new Viitegeneraattori();
        Kirjanpito kirjanpito = new Kirjanpito();
        Pankki pankki = new Pankki(kirjanpito);
        Varasto varasto = new Varasto(kirjanpito);
        
        Kauppa kauppa = new Kauppa(viitegeneraattori, pankki, varasto);

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
