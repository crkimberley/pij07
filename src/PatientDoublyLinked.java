/**
 * @author crkimberley on 09/09/2016.
 */
public class PatientDoublyLinked {
    private String name;
    private int age;
    private String illness;
    private PatientDoublyLinked nextPatient;
    private PatientDoublyLinked previousPatient;

    public PatientDoublyLinked(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        nextPatient = null;
        previousPatient = null;
    }

    public void addPatient(PatientDoublyLinked newPatient) {
        if (nextPatient == null) {
            // this means this is the last patient in the list
            nextPatient = newPatient;
            newPatient.previousPatient = this;
        } else {
            nextPatient.addPatient(newPatient);
        }
    }

    public boolean deletePatient(PatientDoublyLinked patient) {
        if (nextPatient == null) {
            return false;
        } else if (nextPatient.name.equals(patient.name)) {
            nextPatient = nextPatient.nextPatient;
            nextPatient.previousPatient = this;
            System.out.println(patient.name + " deleted");
            return true;
        } else {
            return this.nextPatient.deletePatient(patient);
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

    public PatientDoublyLinked getNextPatient() {
        return nextPatient;
    }
}
