/**
 * @author crkimberley on 12/09/2016.
 */
public class PersonManagerCircular {

    public static void main(String[] args) {
        PersonManagerCircular pm = new PersonManagerCircular();
        pm.launch();
    }

    private void launch() {
        PersonListCircular pList = new PersonListCircular();

        Person p1 = new Person("Angela", 24, "mumps");
        Person p2 = new Person("Bob", 37, "cough");
        Person p3 = new Person("Claire", 41, "cold");
        Person p4 = new Person("Doris", 87, "leprosy");
        Person p5 = new Person("Ed", 48, "flu");
        Person p6 = new Person("Fiona", 19, "insane");
        Person p9 = new Person("Izzy", 45, "undead");

        System.out.println("\nInitial list - empty");
        pList.printList();
        System.out.println("leftInsert 3 people: Angela, Bob, Claire");
        pList.leftInsert(p1);
        pList.leftInsert(p2);
        pList.leftInsert(p3);
        pList.printList();

        System.out.println("leftDelete 1 person");
        pList.leftDelete();
        pList.printList();

        System.out.println("rightInsert 3 people: Doris, Ed, Fiona");
        pList.rightInsert(p4);
        pList.rightInsert(p5);
        pList.rightInsert(p6);
        pList.printList();

        System.out.println("leftDelete 2 people");
        pList.leftDelete();
        pList.leftDelete();
        pList.printList();

        System.out.println("leftDelete 2 people");
        pList.leftDelete();
        pList.leftDelete();
        pList.printList();

        System.out.println("leftDelete 1 person");
        pList.leftDelete();
        pList.printList();

        System.out.println("Attempt to leftDelete from an empty list");
        pList.leftDelete();
        pList.printList();
/*
        System.out.println("Delete p1 - Angela");
        pList.deletePerson(p1);
        pList.printUpAndDown();

        System.out.println("Delete p3 - Claire");
        pList.deletePerson(p3);
        pList.printUpAndDown();

        System.out.println("Add another person");
        pList.addPerson(p6);
        pList.printUpAndDown();

        System.out.println("Create a person, don't add to list, then try to delete");
        pList.deletePerson(p9);
        pList.printUpAndDown();

        System.out.println("Add another person");
        pList.addPerson(p10);
        pList.printUpAndDown();

        System.out.println("Delete p6 - Fiona");
        pList.deletePerson(p6);
        pList.printUpAndDown();

        System.out.println("Delete p10 - Jo");
        pList.deletePerson(p10);
        pList.printUpAndDown();
        */
    }
}
