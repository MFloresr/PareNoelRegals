import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello, World");


        List<String> listaPedidos = new ArrayList<String>();
        HashMap<String,String> Maparegalos = new HashMap<String, String>();
        String[] productos = null;
        String[] productos1= null;
        String separamos1;
        try {
            BufferedReader reader =new BufferedReader(new InputStreamReader(App.class.getResource("/llista.txt").openStream()));
            String linia;

            while((linia = reader.readLine()) != null){
                if(linia.contains(":")){
                    listaPedidos.add(linia);
                    String[] separamos=linia.split(":");
                    separamos1=separamos[1];
                    productos1=separamos[2].split(",");
                }else {
                    productos = linia.split(", ");
                }
            }
            reader.close();
            System.out.println("Archivo Correcto");
        }catch (IOException e) {
            System.err.format("Exception ocurred trying to read llista.txt.");
            e.printStackTrace();
        }



        for(int i =0;i<listaPedidos.size();i++){
            System.out.println(listaPedidos.get(i));
        }
        for(int i =0;i<productos.length;i++){
            System.out.println(productos[i]);
        }

        for(int i =0;i<productos1.length;i++){
            System.out.println(productos1[i]);
        }
    }
}