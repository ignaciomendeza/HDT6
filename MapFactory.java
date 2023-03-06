import java.util.*;

/** 
 * Ignacio Méndez (22613)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 4
 * 20-02-2023
 * Clase ListFactory: Obtenida del repositorio de Moisés Alonso
 */

public class MapFactory {
	
	/***
	 * Crea una instancia de un Map, según la elección del usuario.
	 * @param type 
	 */
	public Map<String, ArrayList<String>> getInstance(int type) {
		
		Map<String, ArrayList<String>> mapInstance;
		
		switch (type) {
		case 1:{
			mapInstance = new HashMap<String, ArrayList<String>>();
		}break;
		
		case 2:{
			mapInstance = new TreeMap<String, ArrayList<String>>();
		}break;
		
		case 3:{
			mapInstance = new LinkedHashMap<String, ArrayList<String>>();
		}break;

		default:{
			mapInstance = null;
		}
		}
		
		return mapInstance;
	}

}
