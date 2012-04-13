
import java.util.Scanner;

// Kahden pelaajan Kivi-Paperi-Sakset
public class KahdenPelaajanKPS {
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {
    Tuomari tuomari = new Tuomari();
    
    System.out.print("Ensimmäisen pelaajan siirto: ");
    String ekanSiirto = scanner.nextLine();
    System.out.print("Toisen pelaajan siirto: ");
    String tokanSiirto = scanner.nextLine();
    
    while(onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
      tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
      System.out.println(tuomari);
      System.out.println();
      
      System.out.print("Ensimmäisen pelaajan siirto: ");
      ekanSiirto = scanner.nextLine();
      System.out.print("Toisen pelaajan siirto: ");
      tokanSiirto = scanner.nextLine();
    }
    
    System.out.println();
    System.out.println("Kiitos!");
    System.out.println(tuomari);
  }
  
  
  private static boolean onkoOkSiirto(String siirto) {
    return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
  }
}