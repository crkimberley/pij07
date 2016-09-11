/**
 * @author crkimberley on 10/09/2016.
 */
public class PersonManagerDoublyLinked {
    public static void main(String[] args) {
        PersonManagerDoublyLinked pm = new PersonManagerDoublyLinked();
        pm.launch();
    }

    private void launch() {
        PersonListDoublyLinked pList = new PersonListDoublyLinked();

        Person p1 = new Person("Angela", 24, "mumps");
        Person p2 = new Person("Bob", 37, "cough");
        Person p3 = new Person("Claire", 41, "cold");
        Person p6 = new Person("Fiona", 19, "insane");
        Person p9 = new Person("Izzy", 45, "undead");
        Person p10 = new Person("Jo", 23, "hypothermia");

        System.out.println("Add 3 people to list");
        pList.addPerson(p1);
        pList.addPerson(p2);
        pList.addPerson(p3);
        pList.printList();

        System.out.println("Delete p2 - Bob");
        pList.deletePerson(p2);
        pList.printList();

        System.out.println("Delete p1 - Angela");
        pList.deletePerson(p1);
        pList.printList();

        System.out.println("Delete p3 - Claire");
        pList.deletePerson(p3);
        pList.printList();

        System.out.println("Add another person");
        pList.addPerson(p6);
        pList.printList();

        System.out.println("Create a person, don't add to list, then try to delete");
        pList.deletePerson(p9);
        pList.printList();

        System.out.println("Add another person");
        pList.addPerson(p10);
        pList.printList();

        System.out.println("Delete p6 - Fiona");
        pList.deletePerson(p6);
        pList.printList();

        System.out.println("Delete p10 - Jo");
        pList.deletePerson(p10);
        pList.printList();
    }
}
