import java.io.*;
import java.util.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class App {
    public static void main(String[] args) {

        List<String> Lista_Navidena = new ArrayList<String>();
        List<String> Lista_Regalos = new ArrayList<String>();
        List<String> auxiliar = new ArrayList<String>();
        String[] Regalos_que_Lleva_PapaNoel = null;
        String nombrePersona;
        String[] Regalos = null;

        Multimap<String, String> multiMap = ArrayListMultimap.create();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(App.class.getResource("/llista1.txt").openStream()));
            String linia;

            while ((linia = reader.readLine()) != null) {
                if (linia.contains(":")) {
                    Lista_Navidena.add(linia);
                } else {
                    Regalos_que_Lleva_PapaNoel = linia.split(",");
                }
            }
            reader.close();
            System.out.println("Archivo Correcto");
        } catch (IOException e) {
            System.err.format("Exception ocurred trying to read llista.txt.");
            e.printStackTrace();
        }

        for (int i = 0; i < Regalos_que_Lleva_PapaNoel.length; i++) {
            Lista_Regalos.add(Regalos_que_Lleva_PapaNoel[i]);
        }

        for (int i = 0; i < Lista_Navidena.size(); i++) {
            String[] listaSeparada = Lista_Navidena.get(i).split(": ");
            nombrePersona = listaSeparada[0];
            Regalos = listaSeparada[1].split(",");

            for (String regal : Regalos) {
                if(Lista_Regalos.contains(regal)){
                    auxiliar.add(regal);

                }
            }
            if(Regalos.length==auxiliar.size()){
                for(int t=0 ;t<auxiliar.size();t++) {
                    multiMap.put(nombrePersona,auxiliar.get(t));
                }
            }
            auxiliar.clear();


            }

        Set<String> keys = multiMap.keySet();
        for(String key:keys) {
            System.out.println(key + " " + multiMap.get(key));
        }
    }
}

