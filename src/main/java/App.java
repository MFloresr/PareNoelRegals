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
        String[] Regalos =null;
        int contador1;
        int contador2;
        boolean noEsta= true;

        Multimap<String, String> multiMap = ArrayListMultimap.create();


        try {
            BufferedReader reader =new BufferedReader(new InputStreamReader(App.class.getResource("/llista.txt").openStream()));
            String linia;

            while((linia = reader.readLine()) != null){
                if(linia.contains(":")){
                    Lista_Navideña.add(linia);
                }else {
                    Regalos_que_Lleva_PapaNoel = linia.split(", ");
                }
            }
            reader.close();
            System.out.println("Archivo Correcto");
        }catch (IOException e) {
            System.err.format("Exception ocurred trying to read llista.txt.");
            e.printStackTrace();
        }

        for(int i =0;i<Regalos_que_Lleva_PapaNoel.length;i++){
            Lista_Regalos.add(Regalos_que_Lleva_PapaNoel[i]);
            //System.out.println(Regalos_que_Lleva_PapaNoel[i]);
        }


        for(int i=0;i<Lista_Navideña.size();i++){
            String[] listaSeparada = Lista_Navideña.get(i).split(": ");
            nombrePersona=listaSeparada[0];
            Regalos =listaSeparada[1].split(", ");
            for(int z =0;z<Regalos.length;z++){
                Regalos_De_Persona.add(Regalos[z]);
            }
            for(int m =0;m<Regalos_De_Persona.size();m++) {
                contador1=+1;
                auxiliar.add(Regalos_De_Persona.get(m));

                if (!Lista_Regalos.contains(Regalos_De_Persona.get(m))) {
                    noEsta=false;
                    Regalos_De_Persona.clear();

                }if(noEsta==true ){
                    multiMap.put(nombrePersona,Regalos_De_Persona.get(m));

                }
            }
            for(int b=0;b<auxiliar.size();b++){
                if(!Lista_Regalos.contains(auxiliar.get(b))){

                }
            }

            for(int x=0;x<Regalos_De_Persona.size();x++){
                //multiMap.put(nombrePersona,Regalos_De_Persona.get(x));
            }
            Regalos_De_Persona.clear();
        }




        Set<String> keys = multiMap.keySet();
        for (String key : keys) {
            System.out.println(key+" "+ multiMap.get(key));
        }


    }
}