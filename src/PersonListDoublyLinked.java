/**
 * @author crkimberley on 09/09/2016.
 */
// Left & Right pointer variables used - as in FoC notes
public class PersonListDoublyLinked {
    private PersonNode left, right;
    private int length;

    public PersonListDoublyLinked() {
        left = null;
        right = null;
        length = 0;
    }

    public void addPerson(Person person) {
        PersonNode newPersonNode = new PersonNode(person);
        newPersonNode.previous = right;
        newPersonNode.next = null;
        // If empty list - point left to new PersonNode
        if (right == null) {
            left = newPersonNode;
        } else {
            right.next = newPersonNode;
        }
        right = newPersonNode;
        length++;
    }

    public boolean deletePerson(Person person) {
        boolean found = false;
        if (left != null) {
            // Special case: person to delete - 1st in list
            if (left.person.equals(person)) {
                found = true;
                left = left.next;
                if (left != null) {
                    left.previous = null;
                } else {
                    right = null;
                }
            } else {
                // Go through list until a match is found
                PersonNode temp = left;
                while (!found && temp != right) {
                    if (temp.next.person.equals(person)) {
                        found = true;
                        temp.next = temp.next.next;
                        if (temp.next != null) {
                            temp.next.previous = temp;
                        } else {
                            right = temp;
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

    public void printUp() {
        PersonNode temp = left;
        System.out.println("\n================================================================================");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        /*System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLength of list = " + length);
        System.out.println("================================================================================\n");*/
    }

    public void printDown() {
        PersonNode temp = right;
        System.out.println("================================================================================");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.previous;
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tLength of list = " + length);
        System.out.println("================================================================================\n");
    }

    public void printUpAndDown() {
        printUp();
        printDown();
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
            return person + "\tprevious: " + (previous != null ? previous.person.getName() : "START")
                    + ", next: " + (next != null ? next.person.getName() : "END");
        }
    }
}
