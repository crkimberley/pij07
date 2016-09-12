/**
 * @author crkimberley on 09/09/2016.
 */
public class PersonListCircular {
    private PersonNode head;
    private int length;

    public PersonListCircular() {
        head = null;
        length = 0;
    }

    public void leftInsert(Person person) {
        length++;
        PersonNode newNode = new PersonNode(person);
        if (head == null) {
            head = newNode;
        } else {
            newNode.link = head.link;
        }
        head.link = newNode;
    }

    public void rightInsert(Person person) {
        leftInsert(person);
        head = head.link;
    }

    public Person leftDelete() {
        if (head != null) {
            PersonNode result = head.link;
            if (head == result) {
                head = null;
            } else {
                head.link = result.link;
            }
            length--;
            return result.person;
        } else {
            return null;
        }
    }

    public void printList() {
        System.out.println("\n=================================================================");
        if (head != null) {
            printList(head);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("L.Node: " + head.link.person.getName()
                    + "  •  R.Node (head): " + head.person.getName()
                    + "  •  Length of list = " + length);
        } else {
            System.out.println("EMPTY LIST");
        }
        System.out.println("=================================================================\n");
    }

    // Recursive printing
    public void printList(PersonNode node) {
        System.out.println(node.link);
        if (node.link != head) {
            printList(node.link);
        }
    }

    private static class PersonNode {
        private Person person;
        private PersonNode link;

        public PersonNode(Person person) {
            this.person = person;
            link = null;
        }

        public String toString() {
            return person + "Link: " + link.person.getName();
        }
    }
}
