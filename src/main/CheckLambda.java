import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by скурихин on 19.08.2016.
 */
public class CheckLambda {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Bob", Person.Sex.MALE,"sdafadf"),
                new Person("Rob", Person.Sex.MALE,"tre"),
                new Person("Huugo", Person.Sex.MALE,"yujy"),
                new Person("Ann", Person.Sex.FEMALE,"dfstr")
        );
        list.stream()
                .filter(person -> person.gender== Person.Sex.MALE)
                .map(person -> person.name)
                .forEach(name-> System.out.println(name));
    }
}
class Person {

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name,Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 2016-birthday.getYear();
    }

    public void printPerson() {
        System.out.println(name);
        System.out.println(birthday);
        System.out.println(gender);
        System.out.println(emailAddress);
    }
}