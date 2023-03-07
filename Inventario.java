import java.util.*;

/*
 * Ignacio Méndez (22613)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 4
 * 20-02-2023
 * Clase Calculadora: modela la calculadora Postfix, implementa la interface IPostfixCalculator
 */

public class Inventario {

    //Atributos
    private Map<String, ArrayList<String>> map;
    private Map<String, ArrayList<String>> bag;
    private MapFactory miFactory;
    
    //Constructor

    public Inventario(int type) {
        miFactory = new MapFactory();
        map = miFactory.getInstance(type);
        bag = miFactory.getInstance(type);
    }

    public void guardarDatos(ArrayList<String> lineasDatos){
        ArrayList<String> unaLinea = new ArrayList<String>();

        for (String fila : lineasDatos) {
            String [] lineaSeparada = fila.split("\\|");
            unaLinea = new ArrayList<String>();
            for (String caracter : lineaSeparada) {
                unaLinea.add(caracter.trim());
            }
            String pro = unaLinea.get(1);
            String categoria = unaLinea.get(0);

            map.putIfAbsent(categoria, new ArrayList<String>());
            map.get(categoria).add(pro);
        }
    }

    public String desplegarProductos(String categoria){
        String resultado = "";
        int count = 1;
        if (map.containsKey(categoria)){
            resultado = "\n" + categoria + ":\n";
            ArrayList<String> productos = map.get(categoria);
            for (String producto : productos){
                resultado = resultado + "  " + count + ") " + producto + "\n";
                count++;
            }
        }
        else{
            resultado = "";
        }
        return resultado;
    }

    public String agregarProducto(String categoria, int producto){
        bag.putIfAbsent(categoria, new ArrayList<>());
        ArrayList<String> productos = map.get(categoria);
        bag.get(categoria).add(productos.get(producto-1));
        return "El producto fue agregado";
    }

    public String mostrarCategoria(String producto){
        String resultado = "";
        boolean no = true;
        ArrayList<String> valores;
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            valores = entry.getValue();
            if (valores.contains(producto)){
                resultado = resultado + "La categoría del producto es: " + entry.getKey();
                no = false;
            }
        }
        if (no){
            resultado = resultado + "El producto no forma parte de ninguna categoría";
        }
        return resultado;
    }

    public String mostrarProductos(){
        String resultado = "";
        int count = 0;
        String producto = "";
        ArrayList<String> values;
        for (Map.Entry<String, ArrayList<String>> entry : bag.entrySet()){
            values = new ArrayList<String>();
            ArrayList<String> valores = entry.getValue();;
            for (int i = 0; i<valores.size(); i++){
                count = 1;
                producto = valores.get(i);
                valores.remove(i);
                values.add(producto);

                for (int j = 0; j<valores.size(); j++){
                    if (valores.get(j).equalsIgnoreCase(producto)){
                        values.add(valores.get(j));
                        valores.remove(j);
                        count++;
                    }
                }
                resultado = resultado + "\n" + producto + ":\n   - Categoría: " + entry.getKey() + "\n   - Cantidad: " + count + "\n";
            } 
            entry.setValue(values);
        }
        return resultado;
    }

    public String mostrarProductosO(){
        String resultado = "";
        int count = 0;
        String producto = "";
        ArrayList<String> values;
        for (Map.Entry<String, ArrayList<String>> entry : bag.entrySet()){
            values = new ArrayList<String>();
            ArrayList<String> valores = entry.getValue();;
            resultado = resultado + "\n" + entry.getKey() + ":\n";
            for (int i = 0; i<valores.size(); i++){
                count = 1;
                producto = valores.get(i);
                valores.remove(i);
                values.add(producto);

                for (int j = 0; j<valores.size(); j++){
                    if (valores.get(j).equalsIgnoreCase(producto)){
                        values.add(valores.get(j));
                        valores.remove(j);
                        count++;
                    }
                }
                resultado = resultado + "   - " + producto + ", Cantidad: " + count + "\n";
            }
            entry.setValue(values);
        }
        return resultado;
    }

    public String mostrarProductosIn(){
        String resultado = "";
        ArrayList<String> valores;
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            valores = entry.getValue();
            for (String producto : valores){
                resultado = resultado + "\n" + producto + ":\n   - Categoría: " + entry.getKey() + "\n";
            } 
        }
        return resultado;
    }

    public String mostrarProductosInO(){
        String resultado = "";
        ArrayList<String> valores;
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            valores = entry.getValue();
            resultado = resultado + "\n" + entry.getKey() + ":\n";
            for (String producto : valores){
                resultado = resultado + "   - " + producto + "\n";
            } 
        }
        return resultado;
    }    
}
