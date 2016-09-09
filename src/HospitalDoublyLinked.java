/**
 * @author crkimberley on 09/09/2016.
 */
public class HospitalDoublyLinked {
    private PatientDoublyLinked patientListStart = null;

    public static void main(String[] args) {
        HospitalDoublyLinked hdl = new HospitalDoublyLinked();
        hdl.launch();
    }

    private void launch() {
        PatientDoublyLinked firstPatient = new PatientDoublyLinked("Andy", 33, "Tuberculosis");
        patientListStart = firstPatient;

        PatientDoublyLinked p2 = new PatientDoublyLinked("Bob", 40, "Cancer");
        patientListStart.addPatient(p2);
        PatientDoublyLinked p3 = new PatientDoublyLinked("Claire", 46, "Lurgy");
        patientListStart.addPatient(p3);
        PatientDoublyLinked p4 = new PatientDoublyLinked("Debbie", 80, "Measles");
        patientListStart.addPatient(p4);
        PatientDoublyLinked p5 = new PatientDoublyLinked("Ed", 18, "Typhoid");
        patientListStart.addPatient(p5);
        PatientDoublyLinked p6 = new PatientDoublyLinked("Fiona", 37, "Leprosy");
        patientListStart.addPatient(p6);
        PatientDoublyLinked p7 = new PatientDoublyLinked("George", 50, "Bronchitis");
        patientListStart.addPatient(p7);
        PatientDoublyLinked p8 = new PatientDoublyLinked("Helen", 33, "Asthma");
        patientListStart.addPatient(p8);
        PatientDoublyLinked p9 = new PatientDoublyLinked("Ian", 74, "Eczema");
        patientListStart.addPatient(p9);
        PatientDoublyLinked p10 = new PatientDoublyLinked("John", 21, "Mumps");
        patientListStart.addPatient(p10);

        printPatients(patientListStart, true);

        System.out.println("\nDelete a couple of patients...");
        patientListStart.deletePatient(p5);
        patientListStart.deletePatient(p7);
        printPatients(patientListStart, true);

        System.out.println("\nDelete 7 more patients...");
        patientListStart.deletePatient(p2);
        patientListStart.deletePatient(p3);
        patientListStart.deletePatient(p4);
        patientListStart.deletePatient(p6);
        patientListStart.deletePatient(p8);
        patientListStart.deletePatient(p9);
        patientListStart.deletePatient(p10);
        printPatients(patientListStart, true);

        System.out.println("\nAdd a new patient...");
        PatientDoublyLinked p11 = new PatientDoublyLinked("Keisha", 19, "Scurvy");
        patientListStart.addPatient(p11);
        printPatients(patientListStart, true);

        System.out.println("\nDemonstrate we can't delete firstPatient from inside the list");
        patientListStart.deletePatient(firstPatient);
        printPatients(patientListStart, true);

        System.out.println("\nDelete firstPatient using deleteFirstPatient()");
        deleteFirstPatient();
        printPatients(patientListStart, true);

        System.out.println("\nDelete remaining patient using deleteFirstPatient()");
        deleteFirstPatient();
        printPatients(patientListStart, true);
    }

    private void printPatients(PatientDoublyLinked patient, boolean up) {
        if (patient == patientListStart && up) {
            System.out.println("========================================");
        }
        if (patient == null) {
            System.out.println("========================================");
            return;
        }
        if (up) {
            if (patient.getNextPatient() == null) {
                up = false;
                printPatients(patient, up);
                System.out.println(" LENGTH = " + listLengthRecursive(patientListStart) + " (recursive)"
                        + " " + listLengthIterative(patientListStart) + " (iterative)");
                System.out.println("========================================");
                return;
            }
        }
        System.out.printf(" %-20s%-6d%12s\n", patient.getName(), patient.getAge(), patient.getIllness());
        printPatients((up ? patient.getNextPatient() : patient.getPreviousPatient()), up);
    }

    private void deleteFirstPatient() {
        patientListStart = patientListStart.getNextPatient();
        if (patientListStart != null) {
            patientListStart.setPreviousPatient(null);
        }
    }

    private int listLengthRecursive(PatientDoublyLinked patient) {
        if (patient == null) {
            return 0;
        }
        if (patient.getNextPatient() == null) {
            return 1;
        } else {
            return 1 + listLengthRecursive(patient.getNextPatient());
        }
    }

    private int listLengthIterative(PatientDoublyLinked patient) {
        PatientDoublyLinked nextPatient = patientListStart;
        int length = 0;
        while(nextPatient != null) {
            length++;
            nextPatient = nextPatient.getNextPatient();
        }
        return length;
    }
}
