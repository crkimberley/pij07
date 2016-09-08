/**
 * @author crkimberley on 08/09/2016.
 */
// Adding to example from the notes
public class Patient {
    private String name;
    private int age;
    private String illness;
    private Patient nextPatient;

    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        nextPatient = null;
    }

    public void addPatient(Patient newPatient) {
        if (nextPatient == null) {
            // this means this is the last patient in the list
            nextPatient = newPatient;
        } else {
            nextPatient.addPatient(newPatient);
        }
    }

    public boolean deletePatient(Patient patient) {
        if (nextPatient == null) {
            // patient to remove was not found
            return false;
        }
        else if (nextPatient.name.equals(patient.name)) {
            // We found it! It is the next one!
            // Now link this patient to the one after the next
            nextPatient = nextPatient.nextPatient;
            System.out.println(patient.name + " deleted");
            return true;
        } else {
            return nextPatient.deletePatient(patient);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIllness() {
        return illness;
    }

    public Patient getNextPatient() {
        return nextPatient;
    }
}
