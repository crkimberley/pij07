/**
 * @author crkimberley on 09/09/2016.
 */
public class PersonListDoublyLinked {
    private PersonNode head;
    private int length;

    public PersonListDoublyLinked() {
        head = null;
        length = 0;
    }

    public void addPerson(Person person) {
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
            newPersonNode.previous = temp;
        }
        length++;
    }

    public boolean deletePerson(Person person) {
        boolean found = false;
        if (head != null) {
            // Special case: person to delete - 1st in list
            if (head.person == person) {
                found =true;
                head = head.next;
                if (head != null) {
                    head.previous = null;
                }
            } else {
                // Go through list until a match is found
                PersonNode temp = head;
                while (!found && temp.next != null) {
                    if (temp.next.person.equals(person)) {
                        found =true;
                        temp.next = temp.next.next;
                        if (temp.next != null) {
                            temp.next.previous = temp;
                        }
                    }
                    temp = temp.next;
                }
            }
        }
        System.out.println(found ? "DELETED" : "NOT IN THE LIST");
        if (found) {
            length--;
        }
        return found;
    }

    public void printList() {
        PersonNode temp = head;
        System.out.println("\n================================================================================");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLength of list = " + length);
        System.out.println("================================================================================\n");
    }

    private static class PersonNode {
        private Person person;
        private PersonNode next;
        private PersonNode previous;

        public PersonNode(Person person) {
            this.person = person;
            next = null;
            previous = null;
        }

        public String toString() {
            /*return person + "\t(next: " + (next != null ? next.person.getName() : "END")
                    + ", previous: " + (previous != null ? previous.person.getName() : "START") + ")";*/
            return person + "\tprevious: " + (previous != null ? previous.person.getName() : "START")
                    + ", next: " + (next != null ? next.person.getName() : "END");
        }
    }
}
