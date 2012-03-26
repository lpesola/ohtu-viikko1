package ohtu;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Kauppa kauppa;

    @Test
    public void kutsutaanPankkia() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        when(mockViite.seruaava()).thenReturn(1);

        Kauppa kauppa = new Kauppa(mockPankki, mockViite);

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(5);
        kauppa.lisaaOstos(5);
        kauppa.maksa("1111");

        verify(mockPankki).maksa(anyString(), anyInt(), anyInt());
    }

    @Test
    public void kutsutaanPankkiaOikeallaTilinumerolla() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);

        Kauppa kauppa = new Kauppa(mockPankki, mockViite);

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(5);
        kauppa.lisaaOstos(5);
        kauppa.maksa("1111");

        verify(mockPankki).maksa(eq("1111"), anyInt(), anyInt());
    }

    @Test
    public void kutsutaanPankkiaOikeallaTilinumerollaJaSummalla() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);

        Kauppa kauppa = new Kauppa(mockPankki, mockViite);

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(5);
        kauppa.lisaaOstos(5);
        kauppa.maksa("1111");

        verify(mockPankki).maksa(eq("1111"), eq(10), anyInt());
    }

    @Test
    public void kaytetaanMaksussaPalautettuaViiteta() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        when(mockViite.seruaava()).thenReturn(55);

        Kauppa kauppa = new Kauppa(mockPankki, mockViite);

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(5);
        kauppa.lisaaOstos(5);
        kauppa.maksa("1111");

        verify(mockPankki).maksa(anyString(), anyInt(), eq(55));
    }

    @Test
    public void pyydetaanUusiViiteJokaiseenMaksuun() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);

        Kauppa kauppa = new Kauppa(mockPankki, mockViite);

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(5);
        kauppa.maksa("1111");

        verify(mockViite, times(1)).seruaava();

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(1);
        kauppa.maksa("1234");

        verify(mockViite, times(2)).seruaava();

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(3);
        kauppa.maksa("4444");

        verify(mockViite, times(3)).seruaava();
    }

    @Test
    public void kaytetaanPerakkaistenViitekutsujenArvoja() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        when(mockViite.seruaava()).thenReturn(1).
                thenReturn(2).thenReturn(3);

        Kauppa kauppa = new Kauppa(mockPankki, mockViite);

        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(5);
        kauppa.maksa("1111");

        verify(mockPankki).maksa(anyString(), anyInt(), eq(1));
        
        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(1);
        kauppa.maksa("1222");

        verify(mockPankki).maksa(anyString(), anyInt(), eq(2));   
        
        kauppa.aloitaOstokset();
        kauppa.lisaaOstos(1);
        kauppa.maksa("4321");

        verify(mockPankki).maksa(anyString(), anyInt(), eq(3));           

    }
}
