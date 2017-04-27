package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.


Требования:
1. Класс Solution должен содержать public static поле countries типа Map.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде комментариев в интерфейсах.
*/

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany(); //example JavaRush Ltd.
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode()); //example Ukraine
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName(); //example Ivanov, Ivan
        }

        @Override
        public String getPhoneNumber() {
            int phoneFmt = data.getPhoneNumber();
            //10 цифр в строке, заполнение слева '0' (по префиксу)
            DecimalFormat phoneDecimalFmt = new DecimalFormat("0000000000");
            String phoneRawString= phoneDecimalFmt.format(phoneFmt);

            //example (050)123-45-67
            MessageFormat phoneMsgFmt = new MessageFormat("({0}){1}-{2}-{3}");
            //С учетом группировки 3-3-2-2
            String[] phoneNumArr={
                    phoneRawString.substring(0, 3),
                    phoneRawString.substring(3, 6),
                    phoneRawString.substring(6, 8),
                    phoneRawString.substring(8)
            };

            return String.format("+%d%s", data.getCountryPhoneCode(), phoneMsgFmt.format(phoneNumArr));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}