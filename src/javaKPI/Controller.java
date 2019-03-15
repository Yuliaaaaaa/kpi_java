package javaKPI;

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

    public void showMenu(){
        Menu menu = new Menu(this);
        menu.mainMenu();

    }

    /*public void mainMenu(){
        view.menu();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:{
                viewResults(allBase);
                mainMenu();
                break;
            }
            case 2:{
                scanner.nextLine();
                System.out.print("Введіть діагноз:\t");
                String diagnosis = scanner.nextLine();
                selected = new Patients(allBase);
                selected.selectDiagnosis(diagnosis);
                viewResults(selected);
                mainMenu();
                break;
            }
            case 3:{
                System.out.print("Введіть початок інтервалу:\t");
                int first = scanner.nextInt();
                System.out.print("Введіть кінець інтервалу:\t");
                int last = scanner.nextInt();
                selected = new Patients(allBase);
                selected.selectCardID(first,last);
                viewResults(selected);
                mainMenu();
                break;
            }
            case 4:{
                scanner.nextLine();
                System.out.print("Введіть повне ім'я:\t");
                String fullname = scanner.nextLine();
                System.out.print("Введіть адресу:\t");
                String adress = scanner.nextLine();
                System.out.print("Введіть номер телефона:\t");
                long phone = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Введіть діагноз:\t");
                String diagnosis = scanner.nextLine();
                Patient pat = new Patient(fullname, adress, phone, diagnosis);
                allBase.addPatient(pat);
                viewResults(allBase);
                mainMenu();
                break;
            }
            case 5:{
                System.out.print("Введіть індекс:\t");
                int idx = scanner.nextInt();
                allBase.delPatient(idx);
                viewResults(allBase);
                mainMenu();
                break;
            }
            case 6:
                System.out.println("До побачення");
                break;
            default:
                System.out.println("Введено неправильний номер");

        }
        scanner.close();
    }*/

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
