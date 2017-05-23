package files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Этот класс предназначен для поиска файлов
 *
 */
public class FileFinder {

    //классы для работы с регулярными выражениями
    private Pattern p = null;
    private Matcher m = null;

    //общий размер найденных файлов
    private long totalLength = 0;
    //общее количество найденных файлов
    private long filesNumber = 0;
    //общее количество просмотренных директорий
    private long directoriesNumber = 0;

    //константы для определения объектов, которые нужно найти
    private final int FILES = 0;
    private final int DIRECTORIES = 1;
    private final int ALL = 2;


    /**
     * Этот метод выполняет поиск всех объектов (файлов и директорий),
     * начиная с заданной директории (startPath)
     * @param startPath Начальная директория поиска
     * @return Список (List) найденных объектов
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     */
    public List findAll(String startPath) throws Exception {
        return find(startPath, "", ALL);
    }

    /**
     * Этот метод выполняет поиск объектов (файлов и директорий),
     * которые соответствуют заданному регулярному выражению (mask),
     * начиная с заданной директории (startPath)
     * @param startPath Начальная директория поиска
     * @param mask регулярное выражение, которому должны соответствовать
     * имена найденный объектов
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     * @return Список (List) найденных объектов
     */
    public List findAll(String startPath, String mask)
            throws Exception {
        return find(startPath, mask, ALL);
    }

    /**
     * Этот метод выполняет поиск всех файлов,
     * начиная с заданной директории (startPath)
     * @param startPath Начальная директория поиска
     * @return Список (List) найденных объектов
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     */
    public List findFiles(String startPath)
            throws Exception {
        return find(startPath, "", FILES);
    }

    /**
     * Этот метод выполняет поиск файлов,
     * которые соответствуют заданному регулярному выражению (mask),
     * начиная с заданной директории (startPath)
     * @param startPath Начальная директория поиска
     * @param mask регулярное выражение, которому должны соответствовать
     * имена найденный объектов
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     * @return Список (List) найденных объектов
     */
    public List findFiles(String startPath, String mask)
            throws Exception {
        return find(startPath, mask, FILES);
    }

    /**
     * Этот метод выполняет поиск всех директорий (папок),
     * начиная с заданной директории (startPath)
     * @param startPath Начальная директория поиска
     * @return Список (List) найденных объектов
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     */
    public List findDirectories(String startPath)
            throws Exception {
        return find(startPath, "", DIRECTORIES);
    }

    /**
     * Этот метод выполняет поиск директорий (папок),
     * которые соответствуют заданному регулярному выражению (mask),
     * начиная с заданной директории (startPath)
     * @param startPath Начальная директория поиска
     * @param mask регулярное выражение, которому должны соответствовать
     * имена найденный объектов
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     * @return Список (List) найденных объектов
     */
    public List findDirectories(String startPath, String mask)
            throws Exception {
        return find(startPath, mask, DIRECTORIES);
    }

    /**
     * Возвращает суммарный размер найденных файлов
     * @return размер найденных файлов (байт)
     */
    public long getDirectorySize() {
        return totalLength;
    }

    /**
     * Возвращает общее количество найденных файлов
     * @return количество найденных файлов
     */
    public long getFilesNumber() {
        return filesNumber;
    }

    /**
     * Возвращает общее количество найденных директорий (папок)
     * @return количество найденных директорий (папок)
     */
    public long getDirectoriesNumber() {
        return directoriesNumber;
    }

    /*
    Проверяет, соответствует ли имя файла заданному
    регулярному выражению. Возвращает true, если найденный
    объект соответствует регулярному выражению, false - в
    противном случае.
    */
    private boolean accept(String name) {
        //если регулярное выражение не задано...
        if(p == null) {
            //...значит объект подходит
            return true;
        }
        //создаем Matcher
        m = p.matcher(name);
        //выполняем проверку
        if(m.matches()) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
    Этот метод выполняет начальные установки поиска.
    Затем вызывает метод search для выполнения поиска.
    */
    private List find(String startPath, String mask, int objectType)
            throws Exception {
        //проверка параметров
        if(startPath == null || mask == null) {
            throw new Exception("Ошибка: не заданы параметры поиска");
        }
        File topDirectory = new File(startPath);
        if(!topDirectory.exists()) {
            throw new Exception("Ошибка: указанный путь не существует");
        }
        //если задано регулярное выражение, создаем Pattern
        if(!mask.equals("")) {
            p = Pattern.compile(mask,
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
        //обнуляем все счетчики
        filesNumber = 0;
        directoriesNumber = 0;
        totalLength = 0;
        //создаем список результатов
        ArrayList res = new ArrayList(100);

        //выполняем поиск
        search(topDirectory, res, objectType);

        //присваиваем null шаблону, т.к. при следующем вызове find...
        //регулярное выражение может быть не задано
        p = null;
        //возвращаем результат
        return res;
    }

    /*
    Этот метод выполняет поиск объектов заданного типа.
    Если, в процессе поиска, встречает вложенную директорию
    (папку), то рекурсивно вызывает сам себя.
    Результаты поиска сохраняются в параметре res.
    Текущая директория - topDirectory.
    Тип объекта (файл или директория) - objectType.
    */
    private void search(File topDirectory, List res, int objectType) {
        //получаем список всех объектов в текущей директории
        File[] list = topDirectory.listFiles();
        //просматриваем все объекты по-очереди
        for(int i = 0; i < list.length; i++) {
            //если это директория (папка)...
            if(list[i].isDirectory()) {
                //...выполняем проверку на соответствие типу объекта
                // и регулярному выражению...
                if(objectType != FILES && accept(list[i].getName())) {
                    //...добавляем текущий объект в список результатов,
                    //и обновляем значения счетчиков
                    directoriesNumber++;
                    res.add(list[i]);
                }
                //выполняем поиск во вложенных директориях
                search(list[i], res, objectType);
            }
            //если это файл
            else {
                //...выполняем проверку на соответствие типу объекта
                // и регулярному выражению...
                if(objectType != DIRECTORIES && accept(list[i].getName())) {
                    //...добавляем текущий объект в список результатов,
                    //и обновляем значения счетчиков
                    filesNumber++;
                    totalLength += list[i].length();
                    res.add(list[i]);
                }
            }
        }
    }
}
