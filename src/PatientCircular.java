/**
 * @author crkimberley on 09/09/2016.
 */
public class PatientCircular {
    private String name;
    private int age;
    private String illness;
    private PatientCircular nextPatient;

    public PatientCircular(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        nextPatient = null;
    }

    public void addPatient(PatientCircular newPatient) {
        PatientCircular temp = this;
        while(true) {
            if (temp.nextPatient == this) {
                temp.nextPatient = newPatient;
                newPatient.nextPatient = this;
                break;
            } else {
                temp = temp.nextPatient;
            }
        }
    }

    public boolean deletePatient(PatientCircular patient) {
        if (patient == this) {
            return false;
        }
        PatientCircular temp = this;
        while(true) {
            if (temp.nextPatient == patient) {
                temp.nextPatient = temp.nextPatient.nextPatient;
                System.out.println(patient.name + " deleted");
                return true;
            }
            temp = temp.nextPatient;
            if (temp == this) {
                return false;
            }
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

    public PatientCircular getNextPatient() {
        return nextPatient;
    }

    public void setNextPatient(PatientCircular patient) {
        nextPatient = patient;
    }
}