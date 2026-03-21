package Prog3.practico2.src;

import java.util.Collection;
import java.util.Collections;

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

    public static void fibonacci(int actual, int siguiente, int n){
        if(n > 0){
            System.out.print(actual + " ");
            fibonacci(siguiente, actual+siguiente, n-1);
        }
    }

    public static boolean indiceIgualElemento(int[] arr, int inicio, int fin){
        if(inicio > fin){
            return false;
        }
        else{
            int medio = (inicio + fin)/2;
            if(arr[medio] == medio){
                return true;
            }
            else{
                if(medio < arr[medio]){
                    return indiceIgualElemento(arr, inicio, medio-1);
                }
                else{
                    return indiceIgualElemento(arr, medio+1, fin);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr){
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void mostrarArreglo(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void volcarContenido(int[] aux, int[] arr, int inicio, int fin){
        int j = 0;
        for(int i = inicio; i <= fin; i++){
            arr[i] = aux[j++];
        }
    }

    public static void merge(int[] arr, int inicio, int medio, int fin){
        int[] aux = new int[fin-inicio+1];
        int i = inicio;
        int j = medio+1;
        for(int pos = 0; pos < aux.length; pos++){
            if(i <= medio && j <= fin){
                if(arr[i] < arr[j]){
                    aux[pos] = arr[i++];
                }
                else{
                    aux[pos] = arr[j++];
                }
            }
            else{
                if(i <= medio){
                    aux[pos] = arr[i++];
                }
                else{
                    aux[pos] = arr[j++];
                }
            }
        }
        volcarContenido(aux,arr,inicio,fin);
    }

    public static void mergeSort(int[] arr, int inicio, int fin){
        if(inicio < fin){
            int medio = (inicio + fin)/2;
            mergeSort(arr, inicio, medio);
            mergeSort(arr,medio+1,fin);
            merge(arr,inicio,medio,fin);
        }
    }

    public static int getPosMenor(int[] arr, int pos){
        int posMenor = pos;
        for(int i = pos+1; i < arr.length; i++){
            if(arr[i] < arr[posMenor]){
                posMenor = i;
            }
        }
        return posMenor;
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int posMenor = getPosMenor(arr, i+1);
            if(arr[posMenor] < arr[i]){
                int tmp = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = tmp;  
            }
        }
    }

    public static int particion(int[]arr, int inicio, int fin){
        int p = inicio;
        int i = inicio;
        int j = fin;
        while(i < j){
            while(i < j && arr[i] <= arr[p]){
                i++;
            }
            while(j > p && arr[j] > arr[p]){
                j--;
            }
            if(i < j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = arr[p];
        arr[p] = arr[j];
        arr[j] = tmp;
        return j;

    }

    public static void quickSort(int[]arr, int inicio, int fin){
        if(inicio < fin){
            int p = particion(arr,inicio,fin);
            quickSort(arr, 0, p-1);
            quickSort(arr, p+1, fin);
        }
    }

    public static void main(String[] args){
        int[] arr = {6,5,3,1,8,7,2,4,7,1,8};
        //System.out.println("El arreglo esta ordenado: " + estaOrdenado(arr,0));
        //System.out.println("El elemento 2 esta : " + buscarElemento(arr,2,0,arr.length-1));
        //System.out.println("El binario de 26 es: " + aBinario(26));
        //fibonacci(0,1,6);
        //System.out.println("El arreglo tiene un elemento que coincide con su indice: " + indiceIgualElemento(arr, 0, arr.length-1));
        selectionSort(arr);
        //bubbleSort(arr);
        //mergeSort(arr,0,arr.length-1);
        //quickSort(arr,0,arr.length-1);
        mostrarArreglo(arr);

    

        
    }

}

