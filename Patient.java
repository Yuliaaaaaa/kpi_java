package javaKPI;


public class Patient {
    private int id;
    private String surname;
    private String name;
    private String fathername;
    private String adress;
    private long phone_number;
    private int card_id;
    private String diagnosis;


    public static int last_id;
    public static int last_card_id;

    public Patient(String surname, String name, String fathername, String adress, long phone_number, String diagnosis) {
        last_id++;
        this.id = last_id;
        last_card_id++;
        this.card_id = last_card_id;

        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.adress = adress;
        this.phone_number = phone_number;
        this.diagnosis = diagnosis;
    }

    public Patient(String full_name, String adress, long phone_number, String diagnosis) {
        last_id++;
        this.id = last_id;
        last_card_id++;
        this.card_id = last_card_id;

        String[] initials = full_name.split(" ");
        this.surname = initials[0];
        this.name = initials[1];
        if(initials.length!=2)
            this.fathername = initials[2];
        else
            this.fathername = "";

        this.adress = adress;
        this.phone_number = phone_number;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String toString(){
        return String.format("||  %-5d  ||  %-25s  ||  %-20s  ||  %-15s  ||  %-50s  ||  %-12d  ||  %-5d  ||  %-20s  ||", id, surname, name, fathername, adress, phone_number, card_id, diagnosis);
    }

}
