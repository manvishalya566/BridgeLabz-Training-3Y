package DesignPrinciple;

import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();

    public Patient(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public String toString() {
        return "Patient(" + name + ")";
    }
}

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " is consulting " + patient);
        patients.add(patient);
        patient.addDoctor(this);
    }

    @Override
    public String toString() {
        return "Doctor(" + name + ")";
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}

class Problem3Demo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");
        Patient patientA = new Patient("Alice");
        Patient patientB = new Patient("Bob");

        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(patientA);
        hospital.addPatient(patientB);

        // Consultations (Association + Communication)
        drSmith.consult(patientA);
        drJones.consult(patientA);
        drSmith.consult(patientB);
    }
}
