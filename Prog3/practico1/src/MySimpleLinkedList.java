public class MySimpleLinkedList<T> {

    private Node<T> first;

    public MySimpleLinkedList(){
        this.first = null;
    }

    public void insertFront(T info){
        Node<T> n = new Node<T>(info,null);
        n.setNext(this.first);
        this.first = n;
    }

    public T extractFront(){
        try{
            if(this.first == null){
                throw new Exception();
            }
            T info = this.first.getInfo();
            this.first = this.first.getNext();
            return info;
        }
        catch(Exception e){
            System.out.println("No se puede extraer de una lista vacia");
        }

        return null;
    }
}
