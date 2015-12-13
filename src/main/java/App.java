import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello, World");


        List<String> listaPedidos = new ArrayList<String>();
        String[] productos = null;
        try {
            BufferedReader reader =new BufferedReader(new InputStreamReader(App.class.getResource("/llista.txt").openStream()));
            String linia;

            while((linia = reader.readLine()) != null){
                if(linia.contains(":")){
                    listaPedidos.add(linia);
                }else {
                    productos = linia.split(", ");
                }
            }
            reader.close();
            System.out.println("Archivo Correcto");
        }catch (IOException e){
            System.err.format("Exception ocurred trying to read llista.txt.");
            e.printStackTrace();
        }


        for(int i =0;i<listaPedidos.size();i++){
            System.out.println(listaPedidos.get(i));
        }
        for(int i =0;i<productos.length;i++){
            System.out.println(productos[i]);
        }
    }
}