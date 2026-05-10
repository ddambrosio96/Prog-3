package Prog3.practico5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Prog3.practico4.GrafoDirigido;

public class Main {
    public static List<Integer> obtenerSalaMasLarga(GrafoDirigido<Integer> g, List<Integer> way, List<Integer> partialWay,
                                                 int entrada, int salida){
       if ( entrada == salida ){
           if(partialWay.size() > way.size() ){
              return new ArrayList(partialWay);   
           } 
       }
       else{
          for(Iterator<Integer> it = g.obtenerAdyacentes(entrada); it.hasNext(); ){
             Integer ady = it.next();
             if( !partialWay.contains(ady) ){
                  partialWay.add(ady);
                  way = obtenerSalaMasLarga(g, way, partialWay, ady, salida);
                  partialWay.remove(ady);
             }
          }
       }
	   return way;  
	}
    
    public static void main(String[] args){

        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		grafito.agregarVertice(0);
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);
		grafito.agregarVertice(7);
		grafito.agregarVertice(8);
		grafito.agregarVertice(9);
		grafito.agregarVertice(10);
		grafito.agregarVertice(11);
		grafito.agregarVertice(12);
		
		grafito.agregarArco(0, 2, 3);
		grafito.agregarArco(0, 4, 4);
		grafito.agregarArco(1, 0, 1);
		grafito.agregarArco(1, 3, 1);
		grafito.agregarArco(1, 4, 1);
		grafito.agregarArco(2, 1, 1);	
		grafito.agregarArco(3, 4, 10);
		grafito.agregarArco(3, 5, 5);
		grafito.agregarArco(4, 2, 11);
		grafito.agregarArco(5, 4, 10);
		grafito.agregarArco(6, 3, 5);
		grafito.agregarArco(6, 5, 11);
		grafito.agregarArco(6, 7, 11);
		grafito.agregarArco(7, 4, 11);
        List<Integer> way = new ArrayList<>();
		way.add(2);
		System.out.println(obtenerSalaMasLarga(grafito, new ArrayList<>(), way, 2, 4));
    }
}
