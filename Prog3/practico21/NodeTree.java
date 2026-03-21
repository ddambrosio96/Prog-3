package Prog3.practico21;

public class NodeTree<T> {
    private T info;
    private NodeTree<T> prev;
    private NodeTree<T> next;

    public NodeTree(){
        this.info = null;
        this.prev = null;
        this.next = null;
    }

    public NodeTree(T info, NodeTree<T> prev, NodeTree<T> next ){
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public NodeTree<T> getNext() {
        return next;
    }

    public void setNext(NodeTree<T> next) {
        this.next = next;
    }

    public NodeTree<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeTree<T> prev) {
        this.prev = prev;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    } 
}
