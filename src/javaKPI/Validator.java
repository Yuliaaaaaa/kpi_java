package javaKPI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    private Controller controller;

    public Validator(Controller controller) {
        this.controller = controller;
    }


    public static Patients fixError(NullPointerException e){
        System.out.println("\n\n"+e.getMessage());
        System.out.println("Створено порожню базу");
        Patients patients = new Patients(new Patient[0]);
        return patients;
    }
    public static void fixError(IllegalArgumentException e){
        System.out.println("\n\n"+e.getMessage());
    }
    public static void fixError(InputMismatchException e){
        System.out.println("\n\nНеправильні вхідні дані!");
    }

    public static Patient fixError(AlreadyExistsException e){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n"+ e);
        System.out.println("Перевірте, будь-ласка, дані:");
        Patient patient = e.getPatient();
        System.out.println(patient);
        System.out.print("\nДані правильні?\t");
        String ans = scanner.next().toLowerCase();
        if(ans == "так" || ans == "yes" || ans == "да" || ans.toCharArray()[0] == '+'){
            return patient;
        }
        System.out.println("\n\nНічого не додано!\n\n");
        Patient.last_id--;
        return null;
    }

    public static Patient checkIfAlreadyExists(Patients allBase, Patient patient){
        Patient newPatient = allBase.searchPatient(patient.getCard_id());
        if(newPatient.getDiagnosis().equals(patient.getDiagnosis())){
            int id = patient.getId();
            patient = new Patient(newPatient);
            patient.setId(id);
            patient = fixError(new AlreadyExistsException(patient));
        }
        else{
            patient.setSurname(newPatient.getSurname());
            patient.setName(newPatient.getName());
            patient.setFathername(newPatient.getFathername());
            patient.setAdress(newPatient.getAdress());
            patient.setPhone_number(newPatient.getPhone_number());
        }
        return patient;
    }
}
