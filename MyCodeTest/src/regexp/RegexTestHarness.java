package regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Программа RegexTestHarness.java для изучения регулярных выражений.
 * Команда для запуска программы: java RegexTestHarness, можно без аргументов.
 * Цикл программы повторяется, позволяя пользователя вводить регулярное выражение
 * и строку для поиска.
 */
public class RegexTestHarness {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        if (console == null){
            System.err.println("No console.");
            System.exit(1);
        }

        while (true){
            System.out.print("\nEnter  your regex: ");
            Pattern pattern = Pattern.compile(console.nextLine());
            System.out.print("Enter input string to search: ");
            Matcher matcher = pattern.matcher(console.nextLine());

            boolean found = false;
            while (matcher.find()){
                System.out.format("I found the text \"%s\" starting at index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }

            if (!found)
                System.out.format("No match found.%n");
        }
    }
}
