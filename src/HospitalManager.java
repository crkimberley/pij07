/**
 * @author crkimberley on 08/09/2016.
 */
// Adding to example from the notes
public class HospitalManager {
    private Patient patientListStart = null;

    public static void main(String[] args) {
        HospitalManager hm = new HospitalManager();
        hm.launch();
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

        System.out.println("================================");
        printPatients(patientListStart);
        System.out.println("================================");
    }

    private void printPatients(Patient patient) {
        if (patient == null) {
            return;
        }
        System.out.printf(" %-12s%-6d%12s\n", patient.getName(), patient.getAge(), patient.getIllness());
        printPatients(patient.getNextPatient());
    }
}
