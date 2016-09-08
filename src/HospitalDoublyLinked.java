/**
 * @author crkimberley on 09/09/2016.
 */
public class HospitalDoublyLinked {
    private Patient patientListStart = null;

    public static void main(String[] args) {
        HospitalDoublyLinked hdl = new HospitalDoublyLinked();
        hdl.launch();
    }

    private void launch() {
        Patient firstPatient = new Patient("Andy", 33, "Tuberculosis");
        patientListStart = firstPatient;

        Patient p2 = new Patient("Bob", 40, "Cancer");
        patientListStart.addPatient(p2);
        Patient p3 = new Patient("Claire", 46, "Lurgy");
        patientListStart.addPatient(p3);
        Patient p4 = new Patient("Debbie", 80, "Measles");
        patientListStart.addPatient(p4);
        Patient p5 = new Patient("Ed", 18, "Typhoid");
        patientListStart.addPatient(p5);
        Patient p6 = new Patient("Fiona", 37, "Leprosy");
        patientListStart.addPatient(p6);
        Patient p7 = new Patient("George", 50, "Bronchitis");
        patientListStart.addPatient(p7);
        Patient p8 = new Patient("Helen", 33, "Asthma");
        patientListStart.addPatient(p8);
        Patient p9 = new Patient("Ian", 74, "Eczema");
        patientListStart.addPatient(p9);
        Patient p10 = new Patient("John", 21, "Mumps");
        patientListStart.addPatient(p10);

        printPatients(patientListStart);

        System.out.println("Delete a couple of patients...");
        patientListStart.deletePatient(p5);
        patientListStart.deletePatient(p7);
        printPatients(patientListStart);

        System.out.println("Delete 7 more patients...");
        patientListStart.deletePatient(p2);
        patientListStart.deletePatient(p3);
        patientListStart.deletePatient(p4);
        patientListStart.deletePatient(p6);
        patientListStart.deletePatient(p8);
        patientListStart.deletePatient(p9);
        patientListStart.deletePatient(p10);
        printPatients(patientListStart);

        System.out.println("Demonstrate we can't delete firstPatient from inside the list");
        patientListStart.deletePatient(firstPatient);
        printPatients(patientListStart);

        System.out.println("Delete firstPatient using deleteFirstPatient()");
        deleteFirstPatient();
        printPatients(patientListStart);
    }

    private void printPatients(Patient patient) {
        if (patient == patientListStart) {
            System.out.println("\n========================================");
        }
        if (patient == null) {
            System.out.println("========================================\n"
                    + " length = " + listLengthRecursive(patientListStart) + " (recursive)"
                    + " " + listLengthIterative(patientListStart) + " (iterative)"
                    + "\n========================================\n");
            return;
        }
        System.out.printf(" %-20s%-6d%12s\n", patient.getName(), patient.getAge(), patient.getIllness());
        printPatients(patient.getNextPatient());
    }

    private void deleteFirstPatient() {
        patientListStart = patientListStart.getNextPatient();
    }

    private int listLengthRecursive(Patient patient) {
        if (patient == null) {
            return 0;
        }
        if (patient.getNextPatient() == null) {
            return 1;
        } else {
            return 1 + listLengthRecursive(patient.getNextPatient());
        }
    }

    private int listLengthIterative(Patient patient) {
        Patient nextPatient = patientListStart;
        int length = 0;
        while(nextPatient != null) {
            length++;
            nextPatient = nextPatient.getNextPatient();
        }
        return length;
    }
}
