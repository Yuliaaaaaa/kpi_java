package javaKPI;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Patients {
    private Patient[] patients;

    public Patients(Patients oldpatients){
        patients = oldpatients.patients;
    }

    public Patients(Patient[] patients){
        this.patients = patients;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient){
        Patient[] newPatients = Arrays.copyOf(patients,patients.length+1);
        newPatients[patients.length] = patient;

        patients = Arrays.copyOf(newPatients, newPatients.length);

    }

    public boolean delPatient(int id){
        Patient[] newPatients = new Patient[patients.length];
        int i,j;
        for(i = 0, j = 0; i < patients.length; i++, j++){
            if(patients[i].getId() != id){
                newPatients[j] = patients[i];
            }
            else{
                j--;
            }
        }
        //System.arraycopy(patients,0,newPatients,0,id-1);
        //System.arraycopy(patients,id,newPatients,id-1,newPatients.length-id+1);


        if(i==j){
            patients = newPatients;
            return false;
        }
        else{
            patients = Arrays.copyOf(newPatients, newPatients.length-1);
            return true;
        }
    }

    public void selectDiagnosis(String diagnosis){
        Patient[] newPatients = new Patient[patients.length];
        int j = 0;
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getDiagnosis().equals(diagnosis)){
                newPatients[j] = patients[i];
                j++;
            }
        }
        newPatients = Arrays.copyOf(newPatients,j);
        patients = newPatients;
    }

    public void selectCardID(int lowID, int topID){
        Patient[] newPatients = new Patient[patients.length];
        int j = 0;
        for(int i = 0; i < patients.length; i++){
            if(patients[i].getCard_id()<= topID && patients[i].getCard_id()>= lowID){
                newPatients[j] = patients[i];
                j++;
            }
        }
        newPatients = Arrays.copyOf(newPatients,j);
        patients = newPatients;
    }

}
