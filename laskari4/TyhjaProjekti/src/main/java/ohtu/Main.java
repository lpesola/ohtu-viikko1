package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import ohtu.Palautukset;
import ohtu.Palautus;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {
 
    public static void main(String[] args) throws IOException {
        String studentNr = "13470892";
        if ( args.length>0) {
            studentNr = args[0];
        }
 
        String url = "http://ohtustats.herokuapp.com/opiskelija/"+studentNr+".json";
 
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);
 
        InputStream stream =  method.getResponseBodyAsStream();
 
        String bodyText = IOUtils.toString(stream);
 
        Gson mapper = new Gson();
        Palautukset palautukset = mapper.fromJson(bodyText, Palautukset.class);
 
        Palautus palautus = palautukset.getPalautukset().get(0);
        int lastIndex = palautukset.getPalautukset().size()-1;

        System.out.println("nimi: " + palautus.getEtunimi()+ " "+ palautus.getSukunimi()
                + " opiskelijanumero: " + palautus.getOpiskelijanumero() + " \n"
                + "miniprojekti: "+palautukset.getPalautukset().get(lastIndex).getTehtavat());
        
        int tehtäviäYhteensä = 0;
        int tuntejaYhteensä = 0;
        for (int i=0; i < lastIndex; i++) {
            Palautus p = palautukset.getPalautukset().get(i);
            System.out.println("Viikko: " + p.getViikko() + ", tehtävät: " 
                    + p.getTehtavat() + ", yhteensä "+p.getTehtavia()
                    +" Aikaa kului "+ p.getTunteja()+" tuntia");
            tehtäviäYhteensä = tehtäviäYhteensä + p.getTehtavia();
            tuntejaYhteensä = tuntejaYhteensä + p.getTunteja();
        }
        
        System.out.println("Yhteensä "+tehtäviäYhteensä+ " tehtävää, joihin mennyt "
                + tuntejaYhteensä + " tuntia");
 
    }
}