package javaKPI;

public class View {

    public View(){

    }


    public void menu(){
        System.out.println("\n\nРозробка моделі \"Пацієнт\".\nДоступні дії:\n");
        System.out.println("1. Вивести усіх пацієнтів.\n2. Вивести всіх пацієнтів з певним діагнозом.");
        System.out.println("3. Вивести пацієнтів з номерами карток у заданому діапазоні.\n4. Додати пацієнта");
        System.out.println("5. Видалити пацієнта\n6. Вихід із програми\n");
    }

    public void outputResults(Patient[] results){
        if(results!=null){
            System.out.printf("    %-4s       %-25s     %-20s      %-15s         %-50s  %-12s   %-7s    %-20s  %n", "№", "Прізвище", "Ім'я", "По-батькові", "Адреса", "Номер телефону", "№ картки", "Діагноз");
            System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________");
            for(int i = 0; i < results.length; i++){
                System.out.println(results[i].toString());
            }
        }
        else{
            System.err.println("Ваш запит не дав результатів!\n\n");
        }
        results = null;
    }
}
