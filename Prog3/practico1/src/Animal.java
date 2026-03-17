public abstract class Animal {

    private String alias;
    private String owner;
    private double height;
    private int age;
    private int idAnimal;
    private static int static_counter = 0;

    public Animal(String alias, String owner, double height, int age) {
        this.alias = alias;
        this.owner = owner;
        this.height = height;
        this.age = age;
        this.idAnimal = ++static_counter; //Solo se usa para el equals, no posee get ni set
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void behavior();

    public String toString(){
        return "Name= "+ this.alias + " ; Owner= "+ this.owner + " ; Height= "+ this.height + " ; Age= "+ this.age + "\n";
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        else{
            Animal a = (Animal) o;
            return this.idAnimal == a.idAnimal; //el idAnimal del objeto a "rompe el encaps.,
                                                // pero Java lo permite porque se usa en la misma clase
        }
    }
}
