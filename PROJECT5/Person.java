import java.util.Scanner;
public class Person {
    public int randNum;
    public int lives;
    String name;

    // Присвоение имени и количества HP каждому персонажу
    public Person(String name) {
        Scanner scan = new Scanner(System.in);
        this.name = name;
        do{
        System.out.println("Введите HP кратное 10");
        this.lives = scan.nextInt();
        }while(lives%10!=0);
        
    }

    // Функция вызывающяя для отнятия жизни персонажа при угадывании числа
    public static void loseLives(Person HP) {
        HP.lives -= 10;
    }
}