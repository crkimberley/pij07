/**
 * @author crkimberley on 09/09/2016.
 */
public class HospitalCircular {
    private PatientCircular patientListStart = null;

    public static void main(String[] args) {
        HospitalCircular hm = new HospitalCircular();
        hm.launch();
    }

    private void launch() {
        PatientCircular firstPatient = new PatientCircular("Andy", 33, "Tuberculosis");
        patientListStart = firstPatient;
        patientListStart.setNextPatient(patientListStart);
        printPatients();

        PatientCircular p2 = new PatientCircular("Bob", 40, "Cancer");
        patientListStart.addPatient(p2);
        printPatients();
        PatientCircular p3 = new PatientCircular("Claire", 46, "Lurgy");
        patientListStart.addPatient(p3);
        PatientCircular p4 = new PatientCircular("Debbie", 80, "Measles");
        patientListStart.addPatient(p4);
        PatientCircular p5 = new PatientCircular("Ed", 18, "Typhoid");
        patientListStart.addPatient(p5);
        PatientCircular p6 = new PatientCircular("Fiona", 37, "Leprosy");
        patientListStart.addPatient(p6);
        PatientCircular p7 = new PatientCircular("George", 50, "Bronchitis");
        patientListStart.addPatient(p7);
        printPatients();
        PatientCircular p8 = new PatientCircular("Helen", 33, "Asthma");
        patientListStart.addPatient(p8);
        PatientCircular p9 = new PatientCircular("Ian", 74, "Eczema");
        patientListStart.addPatient(p9);
        PatientCircular p10 = new PatientCircular("John", 21, "Mumps");
        patientListStart.addPatient(p10);

        printPatients();

        System.out.println("Delete a couple of patients...");
        patientListStart.deletePatient(p5);
        patientListStart.deletePatient(p7);
        printPatients();

        System.out.println("Delete 7 more patients...");
        patientListStart.deletePatient(p2);
        patientListStart.deletePatient(p3);
        patientListStart.deletePatient(p4);
        patientListStart.deletePatient(p6);
        patientListStart.deletePatient(p8);
        patientListStart.deletePatient(p9);
        patientListStart.deletePatient(p10);
        printPatients();

        System.out.println("\nAdd a new patient...");
        PatientCircular p11 = new PatientCircular("Keisha", 19, "Scurvy");
        patientListStart.addPatient(p11);
        printPatients();

        System.out.println("\nCreate new patient, don't add to the list, then try to delete...");
        PatientCircular p99 = new PatientCircular("Winona", 44, "Insanity");
        patientListStart.deletePatient(p99);

        System.out.println("Demonstrate we can't delete firstPatient from inside the list");
        patientListStart.deletePatient(firstPatient);
        printPatients();

        System.out.println("Delete firstPatient using deleteFirstPatient()");
        deleteFirstPatient();
        printPatients();

        System.out.println("And again - delete firstPatient using deleteFirstPatient()");
        deleteFirstPatient();
        printPatients();
    }

    private void printPatients() {
        System.out.println("\n========================================");
        PatientCircular temp = patientListStart;
        if (patientListStart == null) {
            return;
        }
        do {
            System.out.printf(" %-20s%-6d%12s\n", temp.getName(), temp.getAge(), temp.getIllness());
            temp = temp.getNextPatient();
        } while (temp != patientListStart);
        System.out.println("========================================\n"
                + " length = " + listLengthIterative()
                + "\n========================================\n");
    }

    private void deleteFirstPatient() {
        if (patientListStart.getNextPatient() == patientListStart) {
            patientListStart = null;
            return;
        }
        PatientCircular temp = patientListStart;
        patientListStart = patientListStart.getNextPatient();
        patientListStart.deletePatient(temp);
    }

    private int listLengthIterative() {
        int length = 0;
        if (patientListStart == null) {
            return 0;
        }
        PatientCircular temp = patientListStart;
        do {
            length++;
            temp = temp.getNextPatient();
        } while (temp != patientListStart);
        return length;
    }
}