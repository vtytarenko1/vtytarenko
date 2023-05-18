public class Main {
    public static void main(String args[]) {
        Cat cat = new Cat("Cat");
        cat.speak();
        cat.action();
        cat.swimed();
        Dog dog = new Dog("Dog");
        dog.speak();
        dog.action();
        dog.swimed();
    }
}

class Animal {

    private String name;
    private String voice;
    private String length;
    private String swim;


    public Animal(String name, String voice, String length, String swim){
        this.name = name;
        this.voice = voice;
        this.length = length;
        this.swim = swim;
    }

    public void speak() {
        System.out.println(this.name + " says " + this.voice);
    }
    public void action() {
        System.out.println(this.name + " runs " + this.length);
    }
    public void swimed() {
        System.out.println(this.name + " swims " + this.swim);
    }

}
class Cat extends Animal {
    public Cat(String name){
        super(name, "meow", "200 meters", "Cats don't swim");
    }
}
class Dog extends Animal {
    public Dog(String name) {
        super(name, "woof", "500 meters", "10 meters");
    }
}
