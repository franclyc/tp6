package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Credito;

public class CollectionCredito {//esta clase es para poder guardar los creditos en una lista y poder buscarlos por su dni

	 public static List<Credito> creditos = new ArrayList<Credito>();//esta lista es para poder guardar los creditos en memoria y poder buscarlos por su dni

	 public static void agregarCredito(Credito credito) {//	este metodo es para poder agregar un credito a la lista de creditos
	        
	    	try {
	    		creditos.add(credito); 
			} catch (Exception e) {
				System.out.println("\nNO SE PUEDE GUARDAR EL CREDITO");
			}
	    	
	    }
}
