/**
 * @author crkimberley on 09/09/2016.
 */
public class PersonList {
    private PersonNode head;
    private int length;

    public PersonList() {
        head = null;
        length = 0;
    }

    // List length methods aren't necessary, as we have a length variable,
    // but they're used here for more recursion practice
    private int listLengthRecursive() {
        return listLengthRecursive(head);
    }

    private int listLengthRecursive(PersonNode p) {
        if (p == null) {
            return 0;
        }
        int length = 1;
        if (p.next == null) {
            return length;
        } else {
            return (1 + listLengthRecursive(p.next));
        }
    }

    public void addPerson(Person person) {
        // Call recursive method
        addPerson(head, person);
        /* Original iterative method
        PersonNode newPersonNode = new PersonNode(person);
        // If empty list - point head to new PersonNode
        if (head == null) {
            head = newPersonNode;
        } else {
            // Go to end of list then add new PersonNode
            PersonNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPersonNode;
        }
        length++;*/
    }

    // Recursive method
    public void addPerson(PersonNode node, Person person) {
        if (head == null) {
            head = new PersonNode(person);
            length++;
        } else {
            if (node.next == null) {
                node.next = new PersonNode(person);
                length++;
            } else {
                addPerson(node.next, person);
            }
        }
    }

    public boolean deletePerson(Person person) {
        // Call recursive method
        return deletePerson(head, person);
        /*boolean found = false;
        if (head != null) {
            // Special case: person to delete - 1st in list
            if (head.person == person) {
                found =true;
                head = head.next;
            } else {
                // Go through list until a match is found
                PersonNode temp = head;
                while (!found && temp.next != null) {
                    if (temp.next.person.equals(person)) {
                        found =true;
                        temp.next = temp.next.next;
                    }
                    temp = temp.next;
                }
            }
        }
        System.out.println(found ? "DELETED" : "NOT IN THE LIST");
        if (found) {
            length--;
        }
        return found;*/
    }

    // Recursive method
    public boolean deletePerson(PersonNode node, Person person) {
        // Empty list
        if (head == null) {
            return false;
        }
        //Special case: delete first element
        if (head.person == person) {
            head = head.next;
            length--;
            return true;
        }
        // Use recursion to check along the list
        if (node.next != null) {
            if (node.next.person.equals(person)) {
                node.next = node.next.next;
                length--;
                return true;
            }
            return deletePerson(node.next, person);
        } else {
            return false;
        }
    }

    public void printList() {
        System.out.println("\n=================================================================");
        printList(head);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t\tLength of list = " + length + " (or using recursive method) " + listLengthRecursive());
        System.out.println("=================================================================\n");
    }

    // Recursive printing
    public void printList(PersonNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        printList(node.next);
    }

    private static class PersonNode {
        private Person person;
        private PersonNode next;

        public PersonNode(Person person) {
            this.person = person;
            next = null;
        }

        public String toString() {
            return person + "(next: " + (next != null ? next.person.getName() : "END OF LIST") + ")";
        }
    }
}
