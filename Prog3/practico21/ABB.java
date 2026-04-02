package Prog3.practico21;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Node;

public class ABB<T extends Comparable<T>> {

    private NodeTree<T> root;

    public ABB(){
        this.root = null;
    }

    public T getRoot(){
        if(this.root == null){
            return null;
        }
        return this.root.getInfo();
    }

    private boolean hasElemRec(NodeTree<T> tree, T elem){
        if(tree == null){
            return false;
        }
        else{
            if(tree.getInfo().equals(elem)){
                return true;
            }
            else{
                if(elem.compareTo(tree.getInfo()) < 0){
                    return hasElemRec(tree.getPrev(), elem);
                }
                else{
                    return hasElemRec(tree.getNext(), elem);
                }
            }
        }
    }

    public boolean hasElem(T elem){
        return hasElemRec(this.root, elem);
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    private NodeTree<T> addRec(NodeTree<T> tree, T elem){
        if(tree == null){
            tree = new NodeTree<T>(elem,null,null);
        }
        else{
            if(elem.compareTo(tree.getInfo()) < 0){
                tree.setPrev(addRec(tree.getPrev(), elem));
            }
            else{
                if(elem.compareTo(tree.getInfo()) > 0){
                    tree.setNext(addRec(tree.getNext(), elem));
                }
            }
        }
        return tree;
    }

    public void add(T elem){
        this.root = addRec(this.root, elem);
    }

    private T infoPrevSubNext(NodeTree<T> tree){
        if(tree.getPrev() == null){
            return tree.getInfo();
        }
        else{
            return infoPrevSubNext(tree.getPrev());
        }
    }

    private boolean deleteRec(NodeTree<T> tree, T elem){
        
        if (tree.getInfo().compareTo(elem) > 0) {
            NodeTree<T> leftChildren = tree.getPrev();
            if (leftChildren == null) {
                return false;
            } 
            else {
                if(leftChildren.getInfo().equals(elem)){
                    if(leftChildren.getPrev() == null && leftChildren.getNext() == null){
                        tree.setPrev(null);
                    }
                    else{
                        if(leftChildren.getPrev() == null){
                            tree.setPrev(leftChildren.getNext());
                        }
                        else{
                            if(leftChildren.getNext() == null){
                                tree.setPrev(leftChildren.getPrev());
                            }
                            else{
                                T newElem = infoPrevSubNext(leftChildren.getNext()); 
                                leftChildren.setInfo(newElem);
                                deleteRec(leftChildren.getNext(), newElem);
                            }   
                        }
                    }
                    return true;
                }
                else{
                    return deleteRec(leftChildren,elem);
                }
            }
        } 
        else{
            NodeTree<T> rightChildren = tree.getNext();
            if (rightChildren == null) {
                return false;
            } 
            else {
                if(rightChildren.getInfo().equals(elem)){
                    if(rightChildren.getPrev() == null && rightChildren.getNext() == null){
                        tree.setNext(null);
                    }
                    else{
                        if(rightChildren.getPrev() == null){
                            tree.setNext(rightChildren.getNext());
                        }
                        else{
                            if(rightChildren.getNext() == null){
                                tree.setNext(rightChildren.getPrev());
                            }
                            else{
                                T newElem = infoPrevSubNext(rightChildren.getNext()); 
                                rightChildren.setInfo(newElem);
                                deleteRec(rightChildren.getNext(), newElem);
                            }   
                        }
                    }
                    return true;
                }
                else{
                    return deleteRec(rightChildren,elem);
                }
            }
        }    
        
    }

    public boolean delete(T elem){
        if(this.root == null){
            return false;
        }
        else{
            if(this.root.getInfo().equals(elem)){
                this.root = null;
                return true;
            }
            else{
                return deleteRec(this.root, elem);
            }
        }
    }

    private int getHeightRec(NodeTree<T> tree){
        if(tree == null){
            return -1;
        }
        else{
            int heightLeft = getHeightRec(tree.getPrev());
            int heightRight = getHeightRec(tree.getNext());
            return Math.max(heightLeft, heightRight) + 1;
        }
    }

    public int getHeight(){
        if(this.root == null){
            return -1;
        }
        return getHeightRec(this.root);
    }

    private void printPosOrderRec(NodeTree<T> tree){
        if(tree != null){
            printPosOrderRec(tree.getPrev());
            printPosOrderRec(tree.getNext());
            System.out.print(tree.getInfo() + " ");
        }    
    }

    public void printPosOrder(){
        printPosOrderRec(this.root);
    }

    private void printPreOrderRec(NodeTree<T> tree){
        if( tree != null){
            System.out.print(tree.getInfo() + " ");
            printPreOrderRec(tree.getPrev());
            printPreOrderRec(tree.getNext());
        }
        
    }

    public void printPreOrder(){
        printPreOrderRec(this.root);
    }

    private void printInOrderRec(NodeTree<T> tree){
        if(tree != null){
            printInOrderRec(tree.getPrev());
            System.out.print(tree.getInfo() + " ");
            printInOrderRec(tree.getNext());
        }
        
    }

    public void printInOrder(){
        printInOrderRec(this.root);
    }

    private List<T> getLongestBranchRec(NodeTree<T> tree){
        if(tree != null){
            List<T> elemsPrev = getLongestBranchRec(tree.getPrev());
            List<T> elemsNext = getLongestBranchRec(tree.getNext());
            if(elemsPrev.size() > elemsNext.size()){
                elemsPrev.add(0,tree.getInfo());
                return elemsPrev;
            }
            else{
                elemsNext.add(0,tree.getInfo());
                return elemsNext;
            }
            
        }
        return new ArrayList<T>();
    }

    public List<T> getLongestBranch(){
        return getLongestBranchRec(this.root);
    }

    public List<T> getFronteraRec(NodeTree<T> tree){
        List<T> l = new ArrayList<>();
        if(tree != null){

            if(tree.getPrev() == null && tree.getNext() == null){
                l.add(tree.getInfo());    
            }
            else{
                l.addAll(getFronteraRec(tree.getPrev()));
                l.addAll(getFronteraRec(tree.getNext()));
            }
        }
        return l;    
    }

    public List<T> getFrontera(){
        return getFronteraRec(this.root);
    }

    private T getMaxElemRec(NodeTree<T> tree){
        if(tree == null){
            return null;
        }
        else{
            if(tree.getNext() == null){
                return tree.getInfo();
            }
            else{
                return getMaxElemRec(tree.getNext());
            }
        }
    }

    public T getMaxElem(){
        return getMaxElemRec(this.root);
    }

    private List<T> getElemAtLevelRec(NodeTree<T> tree, int level){
        List<T> l = new ArrayList<>();
        if(tree != null){
    
            if(level == 0){
                l.add(tree.getInfo());
                
            }
            else{
                l.addAll(getElemAtLevelRec(tree.getPrev(), level-1));
                l.addAll(getElemAtLevelRec(tree.getNext(), level-1));
            }
        }
        return l;
    }

    public List<T> getElemAtLevel(int level){
        return getElemAtLevelRec(this.root, level);
    }
    
    private int sumNotLeafRec(NodeTree<T> tree){
        if(tree == null || tree.getPrev() == null && tree.getNext() == null ){
            return 0;
        }
        else{
            return (Integer)tree.getInfo() + sumNotLeafRec(tree.getPrev()) + sumNotLeafRec(tree.getNext());  
        }
    }
    
    public int sumNotLeaf(){
        return sumNotLeafRec(this.root);
    }

    //Primer opcion: Método del árbol

    private List<T> getFronteraSupRec(NodeTree<T> tree, T elem){
        List<T> l = new ArrayList<>();
        if(tree != null){

            if(tree.getPrev() == null && tree.getNext() == null && tree.getInfo().compareTo(elem) > 0){
                l.add(tree.getInfo());    
            }
            else{
                l.addAll(getFronteraSupRec(tree.getPrev(), elem));
                l.addAll(getFronteraSupRec(tree.getNext(), elem));
            }
        }
        return l;    

    }

    public List<T> getFronteraSup(T elem){
        return getFronteraSupRec(this.root,elem);
    }

    private int sumNodeChildrenRec(NodeTree<Integer> tree){
        if(tree == null){
            return 0;
        }
        else{
            if(tree.getPrev() == null && tree.getNext() == null){
                return tree.getInfo();
            }
            else{
                int sumChildren = sumNodeChildrenRec(tree.getPrev()) + sumNodeChildrenRec(tree.getNext());
                tree.setInfo(sumChildren);
                return sumChildren;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void sumNodeChildren(){
        sumNodeChildrenRec((NodeTree<Integer>)this.root);
    }

    private List<String> numbersConcatenatedRec(NodeTree<Integer> tree, int cantPairs, String result){
        List<String> listPairs = new ArrayList<>();

        if(tree == null){
            return listPairs;
        }

        int value = tree.getInfo();

        if(value % 2 == 0){
            cantPairs--;
        }

        if(cantPairs < 0){
            return listPairs;
        }

        String nuevo = result + value;

        if(tree.getPrev() == null && tree.getNext() == null){
            if(cantPairs == 0){
                listPairs.add(nuevo);
            }
            return listPairs;
        }

      
        listPairs.addAll(numbersConcatenatedRec(tree.getPrev(), cantPairs, nuevo));
        listPairs.addAll(numbersConcatenatedRec(tree.getNext(), cantPairs, nuevo));

        return listPairs;
    }


    public List<String> numbersConcatenated(int n){
        return numbersConcatenatedRec((NodeTree<Integer>) this.root, n, "");
    }

}
