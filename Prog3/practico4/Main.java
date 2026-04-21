package Prog3.practico4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {

	public static int DFS_visit(GrafoDirigido<Integer> g, int actual, int time, 
		String[] state, int[] discovered, int[] finalized){
		state[actual] = "Amarillo";
		discovered[actual] = ++time;
		for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual); adyacentes.hasNext();){
			int ady = adyacentes.next();
			if(state[ady] == "Blanco"){
				time = DFS_visit(g, ady, time, state, discovered, finalized);
			}
		}
		state[actual] = "Negro";
		finalized[actual] = ++time;
		return time;	

	}

	public static void DFS(GrafoDirigido<Integer> g){
		//Version Cormen
		int cantVert = g.cantidadVertices();
		int time = 0;
		String[] state = new String[cantVert];
		int[] discovered = new int[cantVert];
		int[] finalized = new int[cantVert];

		cleanState(state);

		for(int i = 0; i < state.length; i++){
			if(state[i].equals("Blanco")){
				time = DFS_visit(g, i, time, state, discovered, finalized);
			}
		}

		showArrayStr(state);
		showArrayInt(discovered);
		showArrayInt(finalized);
	
	}

	public static void BFS_visit(GrafoDirigido<Integer> g, String[] state, Queue<Integer> queueVertices, int origin){
		state[origin] = "VISITADO";
		queueVertices.add(origin);
		while(!queueVertices.isEmpty()){
			int elem = queueVertices.poll();
			for(Iterator<Integer> it = g.obtenerAdyacentes(elem); it.hasNext();){
				int ady = it.next();
				if(state[ady].equals("NO_VISITADO")){
					System.out.println(ady);
					state[ady] = "VISITADO";
					queueVertices.add(ady);
				}
			}
		}
	}

	public static void BFS(GrafoDirigido<Integer> g){
		Queue<Integer> queueVertices = new PriorityQueue<>();
		int cantVert = g.cantidadVertices();
		String[] state = new String[cantVert];
		
		cleanState(state);

		for(int i = 0; i < state.length; i++){
			if(state[i].equals("NO_VISITADO")){
				System.out.println(i);
				BFS_visit(g,state,queueVertices,i);
			}
		}
	}

	public static boolean DFS_cyclic_visit(GrafoDirigido<Integer> g, String[] state, int actual){
		
		state[actual] = "Amarillo";
		for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual); adyacentes.hasNext();){
			int ady = adyacentes.next();
			if(state[ady].equals("Blanco")){
				if(DFS_cyclic_visit(g, state, ady)){
					return true;
				}
			}
			else{
				if(state[ady].equals("Amarillo")){
					return true;
				}
			}
		}
		state[actual] = "Negro";
		return false;	
	}

	public static boolean DFS_cyclic(GrafoDirigido<Integer> g){
		int cantVert = g.cantidadVertices();
		String[] state = new String[cantVert];
		cleanState(state);

		for(int i = 0; i < state.length; i++){
			if(state[i].equals("Blanco")){
				if(DFS_cyclic_visit(g,state,i)){
					return true;
				}
			}
		}
		return false;
	}

	public static void DFS_longest_way_visit(GrafoDirigido<Integer> g, int origen,
		int destino, String[] state, ArrayList<Integer> partialWay, ArrayList<Integer> way){
		partialWay.add(origen);	

		if(origen == destino){
			if(partialWay.size() > way.size()){
				way.clear();
				way.addAll(partialWay);
			}
		}
		else{
			state[origen] = "Amarillo";
			for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(origen); adyacentes.hasNext();){
				int ady = adyacentes.next();
				if(!state[ady].equals("Amarillo")){
					DFS_longest_way_visit(g, ady, destino, state, partialWay,way);
				}
			}
		}
		partialWay.remove((Integer)origen);
		state[origen] = "Negro";		
	}

	public static List<Integer> DFS_longest_way(GrafoDirigido<Integer> g, int origen, int destino){
		int cantVert = g.cantidadVertices();
		String[] state = new String[cantVert];
		ArrayList<Integer> partialWay = new ArrayList<>();
		ArrayList<Integer> way = new ArrayList<>();
		cleanState(state);
		DFS_longest_way_visit(g, origen, destino, state, partialWay, way);
		return way;
	}

	public static boolean DFS_vertex_end_visit(GrafoDirigido<Integer> g, String[] state, int origen, int destino){
		if(origen == destino){ 
			return true;
		}
		else{
			state[origen] = "Amarillo";
			for(Iterator<Integer> adyacentes = g.obtenerAdyacentes(origen); adyacentes.hasNext();){
				int ady = adyacentes.next();
				if(state[ady].equals("Blanco")){
					if(DFS_vertex_end_visit(g, state, ady, destino)){
						return true;
					}
				}
			}
			state[origen] = "Negro";
			return false;
		}
	}

	public static List<Integer> DFS_vertex_end(GrafoDirigido<Integer> g, int destino){
		int cantVert = g.cantidadVertices();
		List<Integer> sol = new ArrayList<>();
		String[] state = new String[cantVert];
		cleanState(state);

		for (int i = 0; i < state.length; i++){
			if(i != destino && DFS_vertex_end_visit(g, state, i, destino)){
				sol.add(i);
			}
			cleanState(state);
		}
		return sol;
	}

	public static void cleanState(String[] arr){
		for(int i = 0; i < arr.length; i++){
			arr[i] = "Blanco";
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

		//grafito.borrarArco(3, 2);
		grafito.borrarVertice(3);
		
		//Metodos observadores
		 
		
		for(int i = 0; i <= 5; i++){
			System.out.println("El vertice " + i + " esta en el grafo: " + grafito.contieneVertice(i));
		}
		
		

		
		for(int i = 0; i <= 5; i++){
			for(int j = 0; j <= 5; j++){
				System.out.println("El arco ("+i+","+j+") esta en el grafo: " + grafito.existeArco(i, j));
			}
		}
		

		System.out.println("Cantidad de vertices: " + grafito.cantidadVertices());
		System.out.println("Cantidad de arcos: " + grafito.cantidadArcos());

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
		
	}

}
