package javaKPI;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Menu {

    Controller controller;

    public Menu(Controller controller){
        this.controller = controller;
    }



    public void mainMenu(){
        controller.getView().menu();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:{
                controller.viewResults(controller.getAllBase());
                mainMenu();
                break;
            }
            case 2:{
                scanner.nextLine();
                System.out.print("Введіть діагноз:\t");
                String diagnosis = scanner.nextLine();
                controller.setSelected(new Patients(controller.getAllBase()));
                controller.getSelected().selectDiagnosis(diagnosis);
                controller.viewResults(controller.getSelected());
                mainMenu();
                break;
            }
            case 3:{
                System.out.print("Введіть початок інтервалу:\t");
                int first = scanner.nextInt();
                System.out.print("Введіть кінець інтервалу:\t");
                int last = scanner.nextInt();
                controller.setSelected(new Patients(controller.getAllBase()));
                controller.getSelected().selectCardID(first,last);
                controller.viewResults(controller.getSelected());
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
                controller.getAllBase().addPatient(pat);
                controller.viewResults(controller.getAllBase());
                mainMenu();
                break;
            }
            case 5:{
                System.out.print("Введіть індекс:\t");
                int idx = scanner.nextInt();
                boolean is_deleted = controller.getAllBase().delPatient(idx);
                if(!is_deleted){
                    System.err.println("Пацієнта із заданим індексом не існує");
                }
                else{
                    controller.viewResults(controller.getAllBase());
                }
                System.out.println();
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
    }


}
