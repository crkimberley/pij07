/**
 * @author crkimberley on 10/09/2016.
 */
public class PersonManager {
    public static void main(String[] args) {
        PersonManager pm = new PersonManager();
        pm.launch();
    }

    private void launch() {
        PersonList pList = new PersonList();

        Person p1 = new Person("Angela", 24, "mumps");
        Person p2 = new Person("Bob", 37, "cough");
        Person p3 = new Person("Claire", 41, "cold");
        Person p4 = new Person("Doris", 87, "leprosy");
        Person p6 = new Person("Fiona", 19, "insane");
        Person p9 = new Person("Izzy", 45, "undead");

        pList.printList();
        System.out.println("Add p1 Angela to list");
        pList.addPerson(p1);
        pList.printList();
        System.out.println("Add p2 Bob to list");
        pList.addPerson(p2);
        pList.printList();
        System.out.println("Add p3 Claire to list");
        pList.addPerson(p3);
        pList.printList();
        System.out.println("Add p4 Doris to list");
        pList.addPerson(p4);
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

        System.out.println("Select a person that's not on the list and try to delete it");
        pList.deletePerson(p9);
        pList.printList();

        System.out.println("Delete p4 - Doris");
        pList.deletePerson(p4);
        pList.printList();

        System.out.println("Delete p6 - Fiona");
        pList.deletePerson(p6);
        pList.printList();
    }
}
