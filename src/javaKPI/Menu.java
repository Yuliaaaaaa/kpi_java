package javaKPI;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    private Menu(){

    }

    public static String getDiagnosis(){
        System.out.print("Введіть діагноз:\t");
        String diagnosis = scanner.nextLine();

        if (diagnosis.length()==0)
            throw new IllegalArgumentException("Порожній рядок!");

        return diagnosis;
    }

    public static int[] getInterval(){
        System.out.print("Введіть початок інтервалу:\t");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.print("Введіть кінець інтервалу:\t");
        int last = Integer.parseInt(scanner.nextLine());
        return new int[]{first,last};
    }


    public static Patient createPatient() throws InputMismatchException{
        System.out.print("Пацієнт вже існує в базі?\t");
        String ans = scanner.nextLine();
        if(ans == "так" || ans == "yes" || ans == "да" || ans.toCharArray()[0] == '+') {
            System.out.print("Введіть номер картки:\t");
            int cardId = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть діагноз:\t");
            String diagnosis = scanner.nextLine();

            if (diagnosis.length()==0)
                throw new IllegalArgumentException("Порожній рядок!");

            return new Patient("","","", "", 0, cardId, diagnosis);

        }
        else{
            System.out.print("Введіть повне ім'я:\t");
            String fullname = scanner.nextLine();

            if (fullname.length()==0)
                throw new IllegalArgumentException("Порожній рядок!");


            System.out.print("Введіть адресу:\t");
            String adress = scanner.nextLine();

            if (adress.length()==0)
                throw new IllegalArgumentException("Порожній рядок!");


            System.out.print("Введіть номер телефона:\t");
            long phone = Long.parseLong(scanner.nextLine());

            System.out.print("Введіть діагноз:\t");
            String diagnosis = scanner.nextLine();

            if (diagnosis.length()==0)
                throw new IllegalArgumentException("Порожній рядок!");


            return new Patient(fullname, adress, phone, diagnosis);
        }
    }

    public static int getIdxToDelete(){
        System.out.print("Введіть індекс:\t");
        int idx = scanner.nextInt();
        return idx;
    }



}
