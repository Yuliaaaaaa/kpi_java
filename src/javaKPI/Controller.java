package javaKPI;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private View view;
    private Patients allBase;
    private Patients selected;

    public Controller(){
        view = new View();
        int n = 10;
        Patient[] patients = new Patient[n];
        Patient.last_id = 0;
        Patient.last_card_id = 0;
        patients[0] = new Patient("Щербакова Юлія Олегівна", "Янгеля 1", 380679093878l, "Застуда");
        patients[1] =new Patient("Новаківська Катерина Дмитрівна", "Янгеля 3", 380998877665l, "Застуда");
        patients[2] =new Patient("Дмитрук Олеся Юріївна", "Янгеля 8", 380998789797l, "Грип");
        patients[3] =new Patient("Ханюченко Дарія Олександрівна", "Янгеля 3", 380998877665l, "Грип");
        patients[4] =new Patient("Алпаєва Юлія Сергіївна", "Янгеля 7", 380998877665l, "ОРЗ");
        patients[5] =new Patient("Вознюк Олександра Віталіївна", "Янгеля 7", 380998877665l, "ОРЗ");
        patients[6] =new Patient("Цвік Роман", "Янгеля 7", 380998877665l, "Здоровий");
        patients[7] =new Patient("Ноженко Ярослав", "Янгеля 5", 380998877665l, "ОРЗ");
        patients[8] =new Patient("Скороходов Дмитро", "Янгеля 10", 380998877665l, "Застуда");
        patients[9] =new Patient("Поповська Марія Євгенівна", "Янгеля 11", 380965877555l, "Грип");

        allBase = new Patients(patients);
        selected = null;
    }


    public void mainMenu(){
        try{
            allBase.getPatients();
        }
        catch (NullPointerException npe){
            System.err.println("База пацієнтів відстутня!");
            throw npe;
        }

        view.menu();
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    try {
                        viewResults(allBase);      //may throw NullPointerException
                    }
                    catch (NullPointerException e){
                        throw new NullPointerException("База відсутня!");
                    }

                    mainMenu();
                    break;
                }
                case 2:{
                    String diagnosis = Menu.getDiagnosis();
                    selected = new Patients(allBase);
                    selected.selectDiagnosis(diagnosis);
                    if(selected.getPatients().length == 0)
                        throw new IllegalArgumentException("Пацієнтів із вказаним діагнозом не існує");
                    viewResults(selected);

                    mainMenu();
                    break;
                }
                case 3:{
                    int[] interval = Menu.getInterval();
                    selected = new Patients(allBase);
                    selected.selectCardID(interval[0], interval[1]);
                    if(selected.getPatients().length == 0)
                        throw new IllegalArgumentException("Пацієнтів із вказаними номерами карток не існує");
                    viewResults(selected);

                    mainMenu();
                    break;
                }
                case 4:{
                    Patient patient = Menu.createPatient();
                    if(patient.getAdress() == ""){
                        patient = Validator.checkIfAlreadyExists(allBase, patient);
                    }
                    if(patient!=null){
                        allBase.addPatient(patient);
                    }
                    viewResults(allBase);
                    mainMenu();
                    break;
                }
                case 5:{
                    int idx = Menu.getIdxToDelete(); //throws IllegalArgumentException
                    allBase.delPatient(idx);
                    viewResults(allBase);

                    mainMenu();
                    break;
                }
                case 6:
                    break;
                default:{
                    throw new IllegalArgumentException("Вибрано неіснуючу опцію");
                }

            }
        }
        catch (IllegalArgumentException e){
            Validator.fixError(e);
            mainMenu();
        }
        catch (InputMismatchException e){
            Validator.fixError(e);
            mainMenu();

        }
        catch (NullPointerException e){
            Patients patients = Validator.fixError(e);
            this.allBase = patients;
            mainMenu();
        }
        scanner.close();
    }

    public void viewResults(Patients results){
        view.outputResults(results.getPatients());
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Patients getAllBase() {
        return allBase;
    }

    public void setAllBase(Patients allBase) {
        this.allBase = allBase;
    }

    public Patients getSelected() {
        return selected;
    }

    public void setSelected(Patients selected) {
        this.selected = selected;
    }
}
