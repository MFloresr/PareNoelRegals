import java.io.*;
import java.util.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class App {
    public static void main(String[] args) {

        List<String> Lista_Navideña = new ArrayList<String>();
        List<String> Lista_Regalos = new ArrayList<String>();
        List<String> Regalos_De_Persona = new ArrayList<String>();
        List<String> auxiliar = new ArrayList<String>();
        String[] Regalos_que_Lleva_PapaNoel = null;
        String nombrePersona;
        String[] Regalos = null;
        int contador1 = 0;
        int contador2 = 0;

        Multimap<String, String> multiMap = ArrayListMultimap.create();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(App.class.getResource("/llista.txt").openStream()));
            String linia;

            while ((linia = reader.readLine()) != null) {
                if (linia.contains(":")) {
                    Lista_Navideña.add(linia);
                } else {
                    Regalos_que_Lleva_PapaNoel = linia.split(", ");
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

        for (int i = 0; i < Lista_Navideña.size(); i++) {
            String[] listaSeparada = Lista_Navideña.get(i).split(": ");
            nombrePersona = listaSeparada[0];
            Regalos = listaSeparada[1].split(", ");
            //System.out.println(nombrePersona);
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


          /*  for (int z = 0; z < Regalos.length; z++) {
                Regalos_De_Persona.add(Regalos[z]);
                contador1 = +1;
                for (int y = 0; y < Lista_Regalos.size(); y++) {
                    if (Lista_Regalos.contains(Regalos[z])) {
                        auxiliar.add(Regalos[z]);
                        contador2 = +1;
                    }
                }
                //System.out.println(Regalos[z]+" "+contador1);
            }
            if (contador1 == contador2) {
                for (int a = 0; a < auxiliar.size(); a++) {
                    multiMap.put(nombrePersona, auxiliar.get(a));
                }
            }
            Regalos_De_Persona.clear();
            auxiliar.clear();
        }
        for(int t=0;t<Regalos.length;t++){
            System.out.println(Regalos[t]);
        }*/
        Set<String> keys = multiMap.keySet();
        for(String key:keys) {
            System.out.println(key + " " + multiMap.get(key));
        }
    }
}

