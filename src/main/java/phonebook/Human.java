package phonebook;

import java.io.Serializable;
import java.util.Scanner;

public class Human implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String birth;
    private long phone;

    public Human() {

    }

    public Human(String name, String surname, String birth, long phone) {
        this.name = name;
        this.birth = birth;
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode() + surname.hashCode() + birth.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Human other = (Human) obj;
        return (this.name.equals(other.name)) && (this.surname.equals(other.surname)) && (this.birth.equals(other.birth));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Human human = (Human) super.clone();

        return human;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " " + "Surname: " + this.surname + " " + "Birth: " + this.birth + " " + "Phone number: " + phone + "\n";
    }

    public static Human create(Scanner scanner) {
        Human human = new Human();

        scanner.nextLine();
        System.out.print("Enter name: ");
        human.name = scanner.nextLine();

        System.out.print("Enter surname: ");
        human.surname = scanner.nextLine();

        System.out.print("Enter birth: ");
        human.birth = scanner.nextLine();

        System.out.print("Enter phone: ");
        human.phone = scanner.nextLong();

        return human;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getPhone() {
        return phone;
    }
}
