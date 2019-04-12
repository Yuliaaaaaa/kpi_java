package javaKPI;

public class AlreadyExistsException extends Exception {

    private final Patient patient;

    public AlreadyExistsException(Patient patient) {
        this.patient = patient;
    }


    public String toString(){
         return "Система вже має даний запис!";
     }

    public Patient getPatient() {
        return patient;
    }
}
