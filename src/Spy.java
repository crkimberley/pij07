/**
 * @author crkimberley on 06/09/2016.
 */
public class Spy {
    private static int spyCount = 0;
    private int id;

    public Spy(int id) {
        this.id = id;
        spyCount++;
        System.out.println("id: " + id + "\t- total no. of spies: " + spyCount);
    }

    private void die() {
        System.out.print("Spy " + id + " has been detected and eliminated");
        spyCount--;
        System.out.println("\t- total no. of spies: " + spyCount);
    }

    private int getSpyCount() {
        return spyCount;
    }

    public static void main(String[] args) {
        Spy spy1 = new Spy(111);
        Spy spy2 = new Spy(222);
        Spy spy3 = new Spy(333);
        Spy spy4 = new Spy(444);
        Spy spy5 = new Spy(555);
        spy3.die();
        spy5.die();
    }
}