package q01m09_Java.les05.hw05_02;

public class People {
    String FirstName;
    String LastName;
    String FullName;
    public People(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
        FullName = String.format("%s %s", FirstName, LastName);
    }
}
