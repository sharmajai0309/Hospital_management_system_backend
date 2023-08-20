import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String phoneNumber;

    // Constructor
    public Patient(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Doctor {
    private String name;
    private String specialization;

    // Constructor
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Hospital {
    private String name;
    private Map<String, Doctor> doctors;
    private List<Patient> patients;

    // Constructor
    public Hospital(String name) {
        this.name = name;
        doctors = new HashMap<>();
        patients = new ArrayList<>();
    }

    // Register a new doctor
    public void addDoctor(String doctorName, String specialization) {
        Doctor doctor = new Doctor(doctorName, specialization);
        doctors.put(doctorName, doctor);
        System.out.println("Doctor " + doctorName + " added successfully.");
    }

    // Book an appointment
    public void bookAppointment(String doctorName, Patient patient) {
        if (doctors.containsKey(doctorName)) {
            patients.add(patient);
            System.out.println("Appointment booked with " + doctorName + " for patient " + patient.getName());
        } else {
            System.out.println("Doctor " + doctorName + " does not exist in the hospital.");
        }
    }

    // Display all doctors
    public void displayDoctors() {
        System.out.println("Doctors in " + name + ":");
        for (Doctor doctor : doctors.values()) {
            System.out.println(doctor.getName() + " (" + doctor.getSpecialization() + ")");
        }
    }

    // Display all patients
    public void displayPatients() {
        System.out.println("Patients in " + name + ":");
        for (Patient patient : patients) {
            System.out
                    .println(patient.getName() + " (Age: " + patient.getAge() + ", Phone: " + patient.getPhoneNumber()
                            + ")");
        }
    }
}

public class launch {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("MyHospital");
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Hospital Management Application ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Book Appointment");
            System.out.println("3. Display Doctors");
            System.out.println("4. Display Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialization: ");
                    String specialization = scanner.nextLine();
                    hospital.addDoctor(doctorName, specialization);
                    break;

                case 2:
                    hospital.displayDoctors();
                    System.out.print("Enter doctor name for appointment: ");
                    doctorName = scanner.nextLine();

                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter patient phone number: ");
                    String phoneNumber = scanner.nextLine();

                    Patient patient = new Patient(patientName, patientAge, phoneNumber);
                    hospital.bookAppointment(doctorName, patient);
                    break;

                case 3:
                    hospital.displayDoctors();
                    break;

                case 4:
                    hospital.displayPatients();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Exiting Hospital Management Application.");
    }
}
