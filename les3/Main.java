import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. 
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

    public static void main(String[] args) {
        try {
            Writer();
            System.out.println("Успешно");
        }catch (FileSystemException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    public static void Writer() throws Exception{
        System.out.println("Напишите данные:");
        System.out.println("Фамилия Имя Отчество датарождения номертелефона пол");
        System.out.println("фамилия, имя, отчество - строки");
        System.out.println("датарождения - строка формата dd.mm.yyyy");
        System.out.println("номертелефона - целое беззнаковое число без форматирования");
        System.out.println("пол - символ латиницей f или m.");
        //Считываем данные
        String Data;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Data = reader.readLine();
        }catch (IOException e){
            throw new Exception("Ошибка работы консоли");
        }
        //Считаем кол-во
        String[] DataArray = Data.split(" ");
        if (DataArray.length != 6){
            throw new Exception("Количество параметров не совпадает с требуемым");
        }
        //Запишем ФИО
        String surname = DataArray[0];
        String name = DataArray[1];
        String patr = DataArray[2];
        //Считываем ДР 
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdate;
        try {
            birthdate = format.parse(DataArray[3]);
        }catch (ParseException e){
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }
        //считываем номер телефона
        int number;
        try {
            number = Integer.parseInt(DataArray[4]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Неверный формат телефона");
        }
        //Считываем пол
        String sex = DataArray[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")){
            throw new RuntimeException("Неверно введен пол");
        }
        //Записываем в файл
        String fileName = "files\\" + surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){  //Закроет сам
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patr, format.format(birthdate), number, sex));
        }catch (IOException e){
            throw new FileSystemException("Ошибка при работе с файлом");
        }

    }
}


