package regexp;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Программа RegexTestHarness.java для изучения регулярных выражений.
 * Команда для запуска программы: java RegexTestHarness, можно без аргументов.
 * Цикл программы повторяется, позволяя пользователя вводить регулярное выражение
 * и строку для поиска.
 */
public class RegexTestHarnessConsole {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null){
            System.err.println("No console.");
            System.exit(1);
        }
        while (true){
            Pattern pattern = Pattern.compile(console.readLine("%Enter your regex: "));
            Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()){
                console.format("I found the text \"%s\" starting at index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }

            if (!found)
                console.format("No match found.%n");
        }
    }
}
