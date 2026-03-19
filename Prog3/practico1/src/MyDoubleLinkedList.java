public class MyDoubleLinkedList<T extends Comparable<T>> extends MySimpleLinkedList<T> {

    private Node<T> last;
    public MyDoubleLinkedList(){
        super();
        this.last = null;
    }

    @Override
       public void insertFront(T info){
        NodeDouble<T> n = new NodeDouble<T>(info,null,null);
        if(this.first == null){
            this.first = n;
            this.last = n;
        }
        else{
            n.setNext(super.first);
            ((NodeDouble<T>) super.first).setPrev(n);
            this.first = n;
        }
        super.size++;
    }

    @Override
       public T extractFront(){
        
        if(this.first == null){
            return null;
        }
        this.size--;
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        if(this.first != null){
            ((NodeDouble<T>) this.first).setPrev(null);
        }
        else{
            this.last = null;
        }
        return info;
    }

    public void showReverse(){
        NodeDouble<T> cursor = (NodeDouble<T>) this.last;
        while(cursor != null){
            
            System.out.print(cursor.getInfo());
            cursor = (NodeDouble<T>) cursor.getPrev();
        }
    }

}
