package Prog3.practico2.src;

public class Main {
    
    public static boolean estaOrdenado(int[] arr, int i){
        if(i == arr.length - 1){
            return true;
        }
        else{
            if(arr[i] >= arr[i+1]){
                return false;
            }
            else{
                return estaOrdenado(arr, i+1);
            }
        }
    }

    public static int buscarElemento(int[] arr, int elemento, int inicio, int fin){
        if(inicio > fin){
            return -1;
        }
        else{
            int medio = (inicio + fin)/2;
            if(arr[medio] == elemento){
                return elemento;
            }
            else{
                if(elemento < arr[medio]){
                    return buscarElemento(arr, elemento, inicio, medio-1);
                }
                else{
                    return buscarElemento(arr, elemento, medio+1, fin);
                }
            }
        }
    }

    public static String aBinario(int num){

        if( num <= 1 ){
            return String.valueOf(num);
        }
        else{
            return  aBinario(num/2) +  String.valueOf(num%2);
        }
        
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,9};
        //System.out.println("El arreglo esta ordenado: " + estaOrdenado(arr,0));
        //System.out.println("El elemento 2 esta : " + buscarElemento(arr,2,0,arr.length-1));
        System.out.println("El binario de 26 es: " + aBinario(26));
    }

}

