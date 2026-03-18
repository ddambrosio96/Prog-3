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

        listOrder.insertSorted(d3);
        listOrder.insertSorted(d1);
        listOrder.insertSorted(d4);
        listOrder.insertSorted(d2);

        System.out.println(listOrder.size());

        for(int i = 0; i < listOrder.size(); i++){
            System.out.println(listOrder.get(i));
        }

    }
}
