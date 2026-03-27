package Prog3.practico4;

import java.util.Iterator;

;

public class Main {

	public static void main(String[] args) {

		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		
		grafito.agregarArco(1, 2, 1);
		grafito.agregarArco(1, 3, 3);
		grafito.agregarArco(1, 4, 4);
		grafito.agregarArco(2, 1, 1);
		grafito.agregarArco(4, 1, 10);
		grafito.agregarArco(4, 2, 5);
		grafito.agregarArco(4, 3, 11);

		//grafito.borrarArco(3, 2);
		grafito.borrarVertice(4);
		
		//Metodos observadores
		 
		/* 
		for(int i = 0; i <= 5; i++){
			System.out.println("El vertice " + i + " esta en el grafo: " + grafito.contieneVertice(i));
		}
		*/
		

		/*
		for(int i = 0; i <= 5; i++){
			for(int j = 0; j <= 5; j++){
				System.out.println("El arco ("+i+","+j+") esta en el grafo: " + grafito.existeArco(i, j));
			}
		}
		*/

		//System.out.println("Cantidad de vertices: " + grafito.cantidadVertices());
		//System.out.println("Cantidad de arcos: " + grafito.cantidadArcos());

		/*
		for(int i = 0; i <= 5; i++){
			for(int j = 0; j <= 5; j++){
				if(grafito.existeArco(i, j)){
					Arco<Integer> aux = grafito.obtenerArco(i, j);
					System.out.println("("+aux.getVerticeOrigen()+","+aux.getVerticeDestino()+") con etiqueta: "+
					aux.getEtiqueta());
				}
			}
		}
		*/

		/*
		Iterator<Integer> it = grafito.obtenerVertices();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		*/

		/*
		Iterator<Integer> itV = grafito.obtenerVertices();
		while(itV.hasNext()){
			int vertice = itV.next();
			System.out.print("Adyacentes del vertice " + vertice + " : ");
			Iterator<Integer> itAdy = grafito.obtenerAdyacentes(vertice);
			while(itAdy.hasNext()){
				System.out.print(itAdy.next() + " ");
			}
			System.out.println();
		}
		*/

		/*
		Iterator<Arco<Integer>> itArcos = grafito.obtenerArcos();
		while(itArcos.hasNext()){
			Arco<Integer> a = itArcos.next();
			System.out.println("("+ a.getVerticeOrigen() + ","+ a.getVerticeDestino()+") , etiqueta: " + a.getEtiqueta());
		}
		*/

		/* 
		Iterator<Arco<Integer>> itArcosVertice = grafito.obtenerArcos(4);
		while(itArcosVertice.hasNext()){
			Arco<Integer> a = itArcosVertice.next();
			System.out.println("("+ a.getVerticeOrigen() + ","+ a.getVerticeDestino()+") , etiqueta: " + a.getEtiqueta());
		}
		*/
		
	}

}
