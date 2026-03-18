import java.util.Iterator;

public class IteratorMySimpleLinkedList<T> implements Iterator<T> {

    private Node<T> cursor;

    public IteratorMySimpleLinkedList(Node<T> cursor){
        this.cursor = cursor;
    }

    public boolean hasNext(){
        return cursor != null;
    }

    public T next(){
        T info = this.cursor.getInfo();
        this.cursor = cursor.getNext();
        return info;
    }
}
