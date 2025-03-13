import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate association and communication
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Creating a hospital
        Hospital hospital = new Hospital("Sunrise Hospital");

        // Creating a doctor and a patient
        Doctor doctor = new Doctor("Isha");
        Patient patient = new Patient("Harman");

        // Adding doctor and patient to the hospital
        hospital.addDoctor(doctor);
        hospital.addPatient(patient);

        // Establishing doctor-patient consultation (Association)
        doctor.consult(patient);

        // Display hospital details
        hospital.showHospitalDetails();

        // Display doctor's patients
        doctor.showPatients();

        // Display patient's doctors
        patient.showDoctors();
    }
}

// Patient class
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this); // Ensuring two-way association
        }
    }

    public void showDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName());
        }
    }
}

// Doctor class
class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // Ensuring two-way association
        }
    }

    // Communication method
    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting Patient: " + patient.getName());
        addPatient(patient); // Establishing association
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalDetails() {
        System.out.println("\nHospital: " + hospitalName);
        System.out.println("Doctors in the hospital:");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName());
        }

        System.out.println("Patients in the hospital:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}
//output
//Dr. Isha is consulting Patient: Harman
//
//Hospital: Sunrise Hospital
//Doctors in the hospital:
//- Isha
//Patients in the hospital:
//- Harman
//Dr. Isha has consulted:
//- Harman
//Patient: Harman has consulted:
//- Isha

