package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд

1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) — последней.
text — это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать класс Word.
3. Метод detectAllWords должен быть статическим.
4. Метод detectAllWords должен быть публичным.
5. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        List<Word> wordList = detectAllWords(crossword, "home", "same");
        for (Word word : wordList) {
            System.out.println(word.toString());
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        //список найденых слов
        List<Word> wordList = new ArrayList<>();

        //массив направления поиска
        int[][] searchDirections = new int[][] {
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
        };

        //перебираем по словам
        //nextWord - метка для перехода к новому слову
        for (String word : words) nextWord:{
            //перебираем по строкам в кроссворде
            for (int i = 0; i < crossword.length; i++) {
                //перебираем по столбцам в кроссворде
                for (int j = 0; j < crossword[i].length; j++) {
                    //нашли первую букву слова в кроссворде
                    if (word.charAt(0) == crossword[i][j])
                        //перебираем массив направления поиска
                        for (int directions = 0; directions < searchDirections.length; directions++) {
                            int     tmp_i = i, //координаты первой буквы
                                    tmp_j = j,
                                    wordPos = 1; //счетчик букв в слове
                            //пока есть буквы в слове
                            while (wordPos < word.length()) {
                                //устанавливаем координыты следующей буквы в слове
                                tmp_i += searchDirections[directions][0];
                                tmp_j += searchDirections[directions][1];
                                //проверяем границы кроссворда - слово не может выходить за границы, меняем направление поиска
                                if (tmp_i < 0 || tmp_i >= crossword.length || tmp_j < 0 || tmp_j >= crossword[tmp_i].length)
                                    break;
                                //если очередная буква не соответствует координатам направления поиска, меняем направление
                                if (word.charAt(wordPos) != crossword[tmp_i][tmp_j])
                                    break;
                                //если буквы в слове закончились
                                else if (wordPos == word.length() - 1) {
                                    Word tWord = new Word(word);
                                    //устанавливаем начальные и конечные координаты найденного слова
                                    tWord.setStartPoint(j, i);
                                    tWord.setEndPoint(tmp_j, tmp_i);
                                    //добавляем в список
                                    wordList.add(tWord);
                                    //переходим к поиску нового слова
                                    break nextWord;
                                }
                                //следующая буква
                                wordPos++;
                            }
                        }
                }
            }
        }
        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
