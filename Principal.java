/*
 * Ignacio Méndez (22613)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 4
 * 20-02-2023
 * Clase Principal: Interacción con el usuario
 */

import java.util.*;
import java.util.Scanner;


public class Principal {

    
    /** 
     * @param args
     */
    public static void main(String[] args){

        Scanner teclado = new Scanner (System.in);

        Archivo archivo = new Archivo("./inventario.txt");
        ArrayList<String> lineasDatos = archivo.leerArchivo();
        
        int tipo = 0;
        String menu = "--------------------TIENDA ONLINE--------------------\nIndique la implementación deseada para el map (número):\n1. HashMap\n2. TreeMap\n3. LinkedHashMap";
        boolean seguir = true;
        
        while (seguir){
            System.out.println(menu);
            tipo = teclado.nextInt();
            teclado.nextLine();

            if (tipo > 0 && tipo < 4){
                seguir = false;
            }
            else{
                System.out.println("Ingrese un número válido\n");
            }

        }
        
        Inventario inventario = new Inventario(tipo);
        inventario.guardarDatos(lineasDatos);

        String respuesta = "";
        boolean continuar = true;
        
        try {
            while (continuar){
                String menu2 = "\nSeleccione una opción: \n1. Agregar producto al carro\n2. Mostrar categoría del producto\n3. Mostrar datos de los productos del carrito\n4. Mostrar datos de los productos del carrito ordenados\n5. Mostrar producto y categoría del inventario\n6. Mostrar producto y categoría del inventario ordenados\n7. Salir ";
                System.out.println(menu2);
                int tipo2 = teclado.nextInt();
                teclado.nextLine();

                switch(tipo2){
                    case 1:{
                        System.out.println("\nIngrese la categoría del producto que desea ingresar: ");
                        respuesta = teclado.nextLine();
        
                        if (inventario.desplegarProductos(respuesta).equalsIgnoreCase("") == false){
                            System.out.println(inventario.desplegarProductos(respuesta));
                            System.out.println("Seleccione el producto que desea agregar: ");
                            int tipo3 = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println(inventario.agregarProducto(respuesta, tipo3));                    
                        }
                        else{
                            System.out.println("La categoría no existe en nuestro inventario");
                            
                        }
                        break;
                    }

                    case 2:{
                        System.out.println("\nIngrese el nombre del producto: ");
                        respuesta = teclado.nextLine();

                        System.out.println(inventario.mostrarCategoria(respuesta));
                    }
                    break;
        
                    case 3:{
                        System.out.println(inventario.mostrarProductos());
                    }
                    break;
        
                    case 4:{
                        System.out.println(inventario.mostrarProductosO());
                    }
                    break;
        
                    case 5:{
                        System.out.println(inventario.mostrarProductosIn());
                    }
                    break;
        
                    case 6:{
                        System.out.println(inventario.mostrarProductosInO());
                    }
                    break;
        
                    case 7:{
                        continuar = false;
                    }
                    break;

                    default:{
                        System.out.println("Ingrese un número válido.");
                    }
                    break;
        
        
                }

            }  
        } catch (Exception nullException) {
            System.out.println("No se pudo realizar la operación, revise su entrada");
        }
        
        
    }
}