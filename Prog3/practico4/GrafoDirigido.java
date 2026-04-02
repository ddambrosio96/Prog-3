package Prog3.practico4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {
	private static final int MAX_VERTICES = 100;
	private T[][] estructura;
	private int cantVertices;
	private int cantArcos;
	private List<Integer> vertices;
	private List<Arco<T>> arcos;

	public GrafoDirigido(){
		this.estructura = (T[][]) new Object[MAX_VERTICES][MAX_VERTICES];
		this.cantVertices = 0;
		this.cantArcos = 0;
		this.vertices = new ArrayList<>();
		this.arcos = new ArrayList<>();
	}

	@Override
	public void agregarVertice(int verticeId) { //Funciona
		if(!vertices.contains(verticeId)){
			vertices.add(verticeId);
			cantVertices++;
		}
		System.out.println(cantVertices);
	}

	private void borrarArcos(int verticeId){
		for( Iterator<Arco<T>> it = arcos.iterator(); it.hasNext();){
			Arco<T> a = it.next();
			if(a.getVerticeOrigen() == verticeId || a.getVerticeDestino() == verticeId){
				it.remove();
				cantArcos--;
			}
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(vertices.contains(verticeId)){
			vertices.remove((Integer)verticeId);
			cantVertices--;
			borrarArcos(verticeId);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) { //Funciona
		if(vertices.contains(verticeId1) && vertices.contains(verticeId2)){
			estructura[verticeId1][verticeId2] = etiqueta;
			cantArcos++;
			this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
		}
	}

	private void borrarArcoLista(int verticeId1, int verticeId2){
		for(Arco<T> a: arcos){
			if(a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2){
				arcos.remove(a);
				return;
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) { //Funciona
		if(estructura[verticeId1][verticeId2] != null){
			estructura[verticeId1][verticeId2] = null;
			borrarArcoLista(verticeId1, verticeId2);
			cantArcos--;
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) { //Funciona
		return vertices.contains(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) { //Funciona
		for(Arco<T> a: arcos){
			if(a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2){
				return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) { //Funciona
		for(Arco<T> a: arcos){
			if(a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2){
				return a;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() { //Funciona
		return cantVertices;
	}

	@Override
	public int cantidadArcos() { //Funciona
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() { //Funciona
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) { //Funciona
		List<Integer> ady = new ArrayList<>();
		for(Arco<T> a: arcos){
			if(a.getVerticeOrigen() == verticeId){
				ady.add(a.getVerticeDestino());
			}
		}
		return ady.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() { //Funciona
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) { //Funciona
		List<Arco<T>> arcosVertice = new ArrayList<>();
		for(Arco<T> a: arcos){
			if(a.getVerticeOrigen() == verticeId){
				arcosVertice.add(a);
			}
		}
		return arcosVertice.iterator();
	}
}
