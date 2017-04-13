package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD

CrUD — Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        //Формат даты - dd/MM/yyyy (MM - месяц, mm - минуты)
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]){
            case "-c":
                if (args[2].equals("ж"))
                    allPeople.add(
                            Person.createFemale(
                                    args[1],
                                    formatIn.parse(args[3])
                            )
                    );

                if (args[2].equals("м"))
                    allPeople.add(
                            Person.createMale(
                                    args[1],
                                    formatIn.parse(args[3])
                            )
                    );

                //тупо выводим id - как в задании.
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex((args[3].equals("м")) ? Sex.MALE : Sex.FEMALE);
                person.setBirthDay(formatIn.parse(args[4]));
                break;

            case "-d":
                Person person1 = allPeople.get(Integer.parseInt(args[1]));
                person1.setName(null);
                person1.setSex(null);
                person1.setBirthDay(null);
                break;

            case "-i":
                Person person2 = allPeople.get(Integer.parseInt(args[1]));
                String name = person2.getName();
                String sex = (person2.getSex() == Sex.MALE)? "м" : "ж";
                String bd = formatOut.format(person2.getBirthDay());

                System.out.printf("%s %s %s", name, sex, bd);
                break;
        }

    }
}
