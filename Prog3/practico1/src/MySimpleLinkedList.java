import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList(){
        this.first = null;
        this.size = 0;

    }

    public void insertFront(T info){
        Node<T> n = new Node<T>(info,null);
        n.setNext(this.first);
        this.first = n;
        this.size++;
    }

    public void insertSorted(T info){
        Node<T> n = new Node<T>(info,null);
        if(this.first == null || n.getInfo().compareTo(first.getInfo()) < 0 ){
            n.setNext(this.first);
            this.first = n;
        }
        else{
            Node<T> actual = this.first.getNext();
            Node<T> anterior = this.first;
            while(actual != null && n.getInfo().compareTo(actual.getInfo()) > 0){
                anterior = actual;
                actual = actual.getNext();
            }
            n.setNext(actual);
            anterior.setNext(n);

        }
        size++;
    }


    public T extractFront() {

        if(this.first == null){
            return null;
        }
        this.size--;
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        return info;

    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public int size(){
        return this.size;
    }

    public String toString(){
        Node<T> cursor = this.first;
        String str = "";
        while(cursor != null){
            str += cursor.getInfo();
            cursor = cursor.getNext();
        }
        return str;
    }

    public T get(int index){
        Node<T> cursor = this.first;
        int count = 0;
        while (cursor != null && count < index){
            cursor = cursor.getNext();
            count++;
        }
        if(cursor == null){
            return null;
        }
        return cursor.getInfo();
    }

    public int indexOf(T info){
        Node<T> cursor = this.first;
        int index = 0;
        while(cursor != null && !cursor.getInfo().equals(info)){
            cursor = cursor.getNext();
            index++;
        }
        if(cursor == null){
            return -1;
        }
        return index;
    }

    public Iterator<T> iterator(){
        return new IteratorMySimpleLinkedList<>(this.first);
    }


}
