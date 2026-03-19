public class NodeDouble<T> extends Node<T> {

    private Node<T> prev;

    public NodeDouble(){
        super();
    }

    public NodeDouble(T info, Node<T> next, Node<T> prev){
        super(info, next);
        this.prev = null;
    }

    public void setPrev(Node<T> prev){
        this.prev = prev;
    }

    public Node<T> getPrev(){
        return this.prev;
    }
    
}
