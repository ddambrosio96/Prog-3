public class Node<T> {

    private T info;
    private Node<T> next;

    public Node(){
        this.info = null;
        this.next = null;
    }

    //En general, el next se pasa como null, o directamente se hace un constructor sin el next
    public Node(T info, Node<T> next){
        setInfo(info);
        setNext(next);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
