public class MySimpleLinkedList<T> {

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
}
