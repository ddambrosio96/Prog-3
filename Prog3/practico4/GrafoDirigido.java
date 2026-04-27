package Prog3.practico4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer,List<Arco<T>>> vertices;
	private int cantVertices;
	private int cantArcos;
	


	public GrafoDirigido(){
		this.vertices = new HashMap<>();
		this.cantVertices = 0;
		this.cantArcos = 0;
	}

	@Override
	public void agregarVertice(int verticeId) { //
		if(!vertices.containsKey(verticeId)){
			vertices.put(verticeId, new ArrayList<>());
			cantVertices++;
		}
	}

	private void borrarArcos(int verticeId){//
		List<Arco<T>> ady = vertices.get(verticeId);
		if(ady != null){
			cantArcos -= ady.size();
			ady = null;
		}
	}

	private void borrarAdyacente(int verticeDestino){
		for(List<Arco<T>> ady: vertices.values()){
			int i = 0;
			while(i < ady.size() && ady.get(i).getVerticeDestino() != verticeDestino){
				i++;
			}
			if(i < ady.size()){
				ady.remove(i);
				cantArcos--;
			}
		}
	}

	@Override
	public void borrarVertice(int verticeId) {//
		if(vertices.containsKey(verticeId)){
			cantVertices--;
			borrarArcos(verticeId);
			vertices.remove(verticeId);
			borrarAdyacente(verticeId);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) { //
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			List<Arco<T>> ady = vertices.get(verticeId1);
			if(!existeArco(verticeId1, verticeId2)){
				ady.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
				cantArcos++;
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) { //
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			List<Arco<T>> ady = vertices.get(verticeId1);
			for(Arco<T> a: ady){
				if(a.getVerticeDestino() == verticeId2){
					ady.remove(a);
					cantArcos--;
					return;
				}
			}
		}	
	}

	@Override
	public boolean contieneVertice(int verticeId) { //
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) { //
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			List<Arco<T>> ady = vertices.get(verticeId1);
			for(Arco<T> a: ady){
				if(a.getVerticeDestino() == verticeId2){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) { //
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			List<Arco<T>> ady = vertices.get(verticeId1);
			for(Arco<T> a: ady){
				if(a.getVerticeDestino() == verticeId2){
					return a;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() { //
		return cantVertices;
	}

	@Override
	public int cantidadArcos() { //
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() { //
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) { //
		List<Arco<T>> ady = vertices.get(verticeId);
		List<Integer> adyVertices = new ArrayList<>();
		for (Arco<T> a: ady){
			adyVertices.add(a.getVerticeDestino());
		}
		return adyVertices.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() { //Funciona
		List< Arco<T>> arcos = new ArrayList<>();
		for(List<Arco<T>> ady : vertices.values()){
			arcos.addAll(ady);
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) { //Funciona
		List<Arco<T>> ady = vertices.get(verticeId);
		if(ady != null){
			return ady.iterator();
		}
		return null;
	}
}
