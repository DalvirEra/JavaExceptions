import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //1 Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
    //Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    //2 Если необходимо, исправьте данный код (задание 2
    //3 Дан следующий код, исправьте его там, где требуется (задание 3
    //4 Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    

    public static void main(String[] args) {
       //test1();
       //test2();
       //test3();
       test4();
    }

    public static float test1(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Число: ");
        float number;
        try {
            number = Float.parseFloat(bufferedReader.readLine());
        }catch (NumberFormatException ex){
            System.out.println("Ошибка преобразования в Float");
            return test1();
        } catch (Exception ex){
            System.out.println("Ошибка в получении числа");
            return test1();
        }
        return number;
    }

    public static void test2(){
        try {
            int d = 0;
            int[] intArray = new int[9];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException ex) {
            System.out.println("Catching exception: " + e);
         }
         
    }

    public static void test3(){
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    public static void test4(){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                    try {
                        System.out.println("Введите строку: ");
                        String text = bufferedReader.readLine();
                        if (text.isEmpty()){
                            throw new RuntimeException("Запрещено вводить пустую строку");
                        }
                        System.out.println(text);
                        break;
                    }catch (RuntimeException ex){
                        System.out.println(ex.getMessage());
                    }

                } 
            } catch (IOException ex) {
                    System.out.println("Ошибка при работе");
            }
        }


        //     boolean isContinue = true;
        //     while (isContinue){
        //         try {
        //             System.out.println("Введите строку");
        //             String text = getTextFromUser(bufferedReader);
        //             System.out.println(text);
        //             isContinue = false;
        //         }catch (RuntimeException ex){
        //             System.out.println(ex.getMessage());
        //         }
        //     }
        // } catch (IOException ex) {
        //     System.out.println("Запрещено вводить пустую строку");
        // }

    
}


