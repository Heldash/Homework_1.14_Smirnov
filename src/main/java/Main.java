import java.util.Scanner;

public class Main {
    public static volatile int queue = 1;
    public static void main(String[] args){
        System.out.println("Смирнов Игорь Евгеньевич, РИБО-01-22, 1 Вариант");
        System.out.println("Для выхода из программы нажмите enter");
        Thread th1 = new Thread(new Printer(1));
        Thread th2 = new Thread(new Printer(2));
        Thread th3 = new Thread(new Printer(3));
        th1.setDaemon(true);
        th2.setDaemon(true);
        th3.setDaemon(true);
        th1.start();
        th2.start();
        th3.start();
        Scanner scan = new Scanner(System.in);
        while (true){
            if (scan.nextLine().isEmpty()){
                break;
            }
        }

    }
}
