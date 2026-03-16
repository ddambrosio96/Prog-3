public class Duck extends Animal{

    public Duck(String alias, String owner, double height, int age) {
        super(alias, owner, height, age);
    }

    public void behavior(){
        System.out.println("Cuac Cuac");
    }
}
