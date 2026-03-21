package Prog3.practico21;

public class Main {
    public static void main(String[] args) {
        ABB<Integer> tree = new ABB<Integer>();
        ABB<String> treeEmpty = new ABB<String>();
        
        tree.add(10);
        tree.add(13);
        tree.add(2);
        tree.add(4);
        tree.add(23);
        tree.add(5);
        tree.add(19);
        tree.add(26);
        tree.add(8);
        tree.add(12);
        tree.add(6);

        /*tree.printInOrder();
        System.out.println();
        tree.printPreOrder();
        System.out.println();
        tree.printPosOrder();
        System.out.println();
        */

        //System.out.println(tree.getRoot());
        /*
        System.out.println(tree.hasElem("J"));
        System.out.println(tree.hasElem("W"));
        System.out.println(tree.hasElem("A"));
        System.out.println(tree.hasElem("O"));
        */
        //System.out.println(tree.isEmpty());
        //System.out.println(treeEmpty.isEmpty());

        //tree.delete("F");
        //tree.delete("M");
        //tree.delete("T");
        //tree.delete("D");
        //tree.delete("H");
        //tree.delete("null");
        //tree.delete("J");
        //tree.printInOrder();
        //System.out.println("La altura del arbol es: " + tree.getHeight());
        //System.out.println("La altura del arbol es: " + treeEmpty.getHeight());
        //System.out.println("La rama mas larga del arbol es: " + tree.getLongestBranch());
        //System.out.println("La rama mas larga del arbol es: " + treeEmpty.getLongestBranch());
        //System.out.println("La frontera del arbol esta conformado por las hojas: " + tree.getFrontera() );
        //System.out.println("La frontera del arbol esta conformado por las hojas: " + treeEmpty.getFrontera() );
        //System.out.println("Elemento mayor: " + tree.getMaxElem());
        //System.out.println("Elemento mayor: " + treeEmpty.getMaxElem());
        
        /*for(int i = 0; i <= tree.getHeight(); i++){
            System.out.println("Elementos del nivel " + i + " : " + tree.getElemAtLevel(i));
        }
        */
       tree.printInOrder();
       System.out.println("La suma de los nodos internos del arbol da: " + tree.sumNotLeaf());

    }
}
