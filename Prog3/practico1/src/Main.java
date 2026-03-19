public class Main {

    public static void main(String[] args){

        Duck d1 = new Duck("Lucas", "Rick", 4.5, 7 );
        Duck d2 = new Duck("Donald", "Rick", 8.5, 3 );
        Duck d3 = new Duck("Steve", "James", 1.87, 5 );
        Duck d4 = new Duck("Abe", "Rick", 10.5, 2 );


        MySimpleLinkedList<Animal> list = new MySimpleLinkedList<Animal>();
        MySimpleLinkedList<Animal> listOrder = new MySimpleLinkedList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.insertFront(d4);
        list.insertFront(d3);
        //System.out.println(list.extractFront());
        //System.out.println(list.extractFront());
        list.insertFront(d2);
        list.insertFront(d1);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list);
        //System.out.println(list.extractFront());
        //System.out.println(list.extractFront());
        //System.out.println(list.extractFront());
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.indexOf(d1));
        System.out.println(list.indexOf(d3));
        /*
        for (Animal a: list){
            System.out.println(a);
        }
        */

        /*
        listOrder.insertSorted(d3);
        listOrder.insertSorted(d1);
        listOrder.insertSorted(d4);
        listOrder.insertSorted(d2);

        System.out.println(listOrder.size());

        for(int i = 0; i < listOrder.size(); i++){
            System.out.println(listOrder.get(i));
        }
             */

        MySimpleLinkedList<Animal> l1 = new MySimpleLinkedList<Animal>();
        MySimpleLinkedList<Animal> l2 = new MySimpleLinkedList<Animal>();
        MySimpleLinkedList<Animal> l3 = new MySimpleLinkedList<Animal>();
        MySimpleLinkedList<Animal> l3Order = new MySimpleLinkedList<Animal>();
        MySimpleLinkedList<Animal> l3Dif = new MySimpleLinkedList<Animal>();

        l1.insertFront(d3);
        l1.insertFront(d2);
        l1.insertFront(d1);
        
        l2.insertFront(d4);
        l2.insertFront(d3);
        l2.insertFront(d1);
        
        ////////////////////////////////////////// Ejercicio 5.a ////////////////////////////////
        System.out.println("....................................");
        insertarElementosComunes(l1, l2, l3);

        System.out.println(l3);

        ////////////////////////////////////////// Ejercicio 5.b ////////////////////////////////
        System.out.println("....................................");
        insertarElementosComunesOrdenados(l1, l2, l3Order);

        System.out.println(l3Order);

        ////////////////////////////////////////// Ejercicio 6 ////////////////////////////////
        System.out.println("....................................");
        
        System.out.println(insertarElementosDiferencia(l1, l2));

        System.out.println("....................................");
        MyDoubleLinkedList<Animal> ld = new MyDoubleLinkedList<>();
        ld.insertFront(d4);
        ld.insertFront(d3);
        ld.insertFront(d2);
        ld.insertFront(d1);
        ld.showReverse();
    }

    public static void insertarElementosComunes(MySimpleLinkedList<Animal> lOrigen,
                                                MySimpleLinkedList<Animal> lBusqueda,
                                                MySimpleLinkedList<Animal> lDestino){
        for(Animal a: lOrigen){
            if(lBusqueda.indexOf(a) != -1){
                lDestino.insertSorted(a);
            }
        }                                                     
    }

    public static void insertarElementosComunesOrdenados(MySimpleLinkedList<Animal> lOrigen,
                                                MySimpleLinkedList<Animal> lBusqueda,
                                                MySimpleLinkedList<Animal> lDestino){
        
                                                    
        IteratorMySimpleLinkedList<Animal> it1 = (IteratorMySimpleLinkedList<Animal>) lOrigen.iterator();
        IteratorMySimpleLinkedList<Animal> it2 = (IteratorMySimpleLinkedList<Animal>) lBusqueda.iterator();

        while(it1.hasNext() && it2.hasNext()){
            if(it1.current().compareTo(it2.current()) < 0){
                it1.next();
            }
            else{
                if(it1.current().compareTo(it2.current()) > 0){
                    it2.next(); 
                }
                else{
                    lDestino.insertSorted(it1.next());
                    it2.next();
                }
            }
        }
    }
    
      public static MySimpleLinkedList<Animal> insertarElementosDiferencia(MySimpleLinkedList<Animal> lOrigen,
                                                MySimpleLinkedList<Animal> lBusqueda){
        
        MySimpleLinkedList<Animal> lDestino = new MySimpleLinkedList<>();                                            
        for(Animal a: lOrigen){
            if(lBusqueda.indexOf(a) == -1){
                lDestino.insertSorted(a);
            }
        }                                     
        return lDestino;                
    }
}
