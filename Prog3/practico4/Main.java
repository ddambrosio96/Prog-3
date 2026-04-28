package Prog3.practico4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {

	public static void DFS_visit(GrafoDirigido<Integer> g, int actual, 
		HashMap<Integer,String> state){
		System.out.println(actual);	
		state.put(actual, "Amarillo");
		for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual); adyacentes.hasNext();){
			int ady = adyacentes.next();
			if(state.get(ady).equals("Blanco") ){
				DFS_visit(g, ady, state);
			}
		}
		state.put(actual, "Negro");
		
	}

	public static void DFS(GrafoDirigido<Integer> g){
		HashMap<Integer, String> state = new HashMap<>();
		setState(g,state, "Blanco");

		for(Map.Entry<Integer, String> entry : state.entrySet()){
			
			if(entry.getValue().equals("Blanco")){
				DFS_visit(g, entry.getKey(), state);
			}
		}
	
	}

	public static void BFS_visit(GrafoDirigido<Integer> g, HashMap<Integer,String> state, int origin,
	    Queue<Integer> queueVertices){
		state.put(origin, "VISITADO");
		System.out.println(origin);
		queueVertices.add(origin);
		while(!queueVertices.isEmpty()){
			int elem = queueVertices.poll();
			for(Iterator<Integer> it = g.obtenerAdyacentes(elem); it.hasNext();){
				int ady = it.next();
				if(state.get(ady).equals("NO_VISITADO")){
					state.put(ady, "VISITADO");
					System.out.println(ady);
					queueVertices.add(ady);
				}
			}
		}
	}

	public static void BFS(GrafoDirigido<Integer> g){
		Queue<Integer> queueVertices = new PriorityQueue<>();
		HashMap<Integer, String> state = new HashMap<>();
		setState(g,state, "NO_VISITADO");

		for(Map.Entry<Integer, String> entry : state.entrySet()){
			
			if(entry.getValue().equals("NO_VISITADO")){
				BFS_visit(g, state, entry.getKey(), queueVertices);
			}
		}
	}

	public static boolean DFS_cyclic_visit(GrafoDirigido<Integer> g, HashMap<Integer, String> state, int actual){
		
		state.put(actual, "Amarillo");
		for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual); adyacentes.hasNext();){
			int ady = adyacentes.next();
			if(state.get(ady).equals("Blanco")){
				if(DFS_cyclic_visit(g, state, ady)){
					return true;
				}
			}
			else{
				if(state.get(ady).equals("Amarillo")){
					return true;
				}
			}
		}
		state.put(actual, "Negro");
		return false;	
	}

	public static boolean DFS_cyclic(GrafoDirigido<Integer> g){
		
		HashMap<Integer, String> state = new HashMap<>();
		setState(g,state, "Blanco");

		for(Map.Entry<Integer, String> entry : state.entrySet()){
			
			if(entry.getValue().equals("Blanco")){
				if(DFS_cyclic_visit(g, state, entry.getKey())){
					return true;
				}
			}
		}
		
		return false;
	
	}

	public static void DFS_longest_way_visit(GrafoDirigido<Integer> g, int origen,
		int destino, HashMap<Integer, String> state, ArrayList<Integer> partialWay, ArrayList<Integer> way){
		partialWay.add(origen);	

		if(origen == destino){
			if(partialWay.size() > way.size()){
				way.clear();
				way.addAll(partialWay);
			}
		}
		else{
			state.put(origen, "Amarillo");
			for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(origen); adyacentes.hasNext();){
				int ady = adyacentes.next();
				if(!state.get(ady).equals("Amarillo")){
					DFS_longest_way_visit(g, ady, destino, state, partialWay,way);
				}
			}
		}
		partialWay.remove((Integer)origen);
		state.put(origen, "Negro");	
	}

	public static List<Integer> DFS_longest_way(GrafoDirigido<Integer> g, int origen, int destino){
		HashMap<Integer, String> state = new HashMap<>();
		ArrayList<Integer> partialWay = new ArrayList<>();
		ArrayList<Integer> way = new ArrayList<>();
		setState(g,state, "Blanco");
		DFS_longest_way_visit(g, origen, destino, state, partialWay, way);
		return way;
	}

	public static boolean DFS_vertex_end_visit(GrafoDirigido<Integer> g, HashMap<Integer, String> state, int origen, int destino){
		if(origen == destino){ 
			return true;
		}
		else{
			state.put(origen, "Amarillo");
			for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(origen); adyacentes.hasNext();){
				int ady = adyacentes.next();
				if(state.get(ady).equals("Blanco")){
					if(DFS_vertex_end_visit(g, state, ady, destino)){
						return true;
					}
				}
			}
			state.put(origen, "Negro");
			return false;
		}
	}

	public static List<Integer> DFS_vertex_end(GrafoDirigido<Integer> g, int destino){
		List<Integer> sol = new ArrayList<>();
		HashMap<Integer, String> state = new HashMap<>();
		setState(g,state, "Blanco");

		for(Map.Entry<Integer, String> entry : state.entrySet()){
			if(entry.getKey() != destino && DFS_vertex_end_visit(g, state,entry.getKey(), destino)){
				sol.add(entry.getKey());
			}
			setState(g,state, "Blanco");
		}
		return sol;
	}

	public static List<Integer> BFS_shortest_way(GrafoDirigido<Integer> g, int origen, int destino){

		Queue<Integer> queueVertices = new PriorityQueue<>();
		queueVertices.add(origen);
		HashMap<Integer, String> state = new HashMap<>();
		setState(g,state, "NO_VISITADO");
		while(!queueVertices.isEmpty()){
			
			int elem = queueVertices.poll();
			for(Iterator<Integer> it = g.obtenerAdyacentes(elem); it.hasNext();){
				int ady = it.next();
				if(state.get(ady).equals("NO_VISITADO")){
					state.put(ady, String.valueOf(elem));
					if(ady == destino){
						queueVertices.clear();
					}
					else{
						queueVertices.add(ady);
					}
				}
			}
		}
		List<Integer> way = new ArrayList<>();
		int verticeActual = destino;
		if(state.get(destino).equals("NO_VISITADO")){
			return null;
		}
		while(verticeActual != origen){
			way.add(0,verticeActual);
			verticeActual = Integer.parseInt(state.get(verticeActual)); 
		}
		way.add(0,origen);
		return way;

	}

	public static void setState(GrafoDirigido<Integer> g, HashMap<Integer, String> state, String startVal){
		for(Iterator<Integer> v = g.obtenerVertices(); v.hasNext();){
			int numVertice = v.next();
			state.put(numVertice, startVal);
		}
	}

	public static void showArrayStr(String[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void showArrayInt(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	

	public static void main(String[] args) {

		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		grafito.agregarVertice(0);
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);
		grafito.agregarVertice(7);
		
		grafito.agregarArco(0, 2, 3);
		grafito.agregarArco(0, 1, 4);
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

		//grafito.borrarArco(3, 2);
		//grafito.borrarVertice(3);
		
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
		
		//System.out.println(grafito.cantidadVertices());
		//DFS(grafito);
		//BFS(grafito);
		//System.out.println("Existe un ciclo en el grafo: " + DFS_cyclic(grafito));
		//System.out.println("El camino mas largo entre el vertice 1 y 4 es: " + DFS_longest_way(grafito,1,4));
		//System.out.println("Los vertices que desde ellos existe un camino al vertice 5 es: " + DFS_vertex_end(grafito, 5));
		System.out.println("El camino mas corto que hay entre el vertice 0 y el 4 es: " + BFS_shortest_way(grafito,0,4));
	}

}
