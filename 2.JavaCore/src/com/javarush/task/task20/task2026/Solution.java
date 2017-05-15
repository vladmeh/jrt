package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании


Требования:
1. В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
2. Метод getRectangleCount должен быть публичным.
3. Метод getRectangleCount должен быть статическим.
4. Метод getRectangleCount должен возвращать количество прямоугольников (в соответствии с заданием) найденное в полученном массиве.
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        //высота поля
        int height = a.length;
        //ширина поля
        int width = a[0].length;

        //Цикл по высоте
        for (int i = 0; i < height; i++) {
            //Цикл по ширине
            for (int j = 0; j < width; j++) {
                //нашли край прямоугольника
                if (a[i][j] == 1){
                    count++;
                    //записываем край прямоугольника во временную переменную
                    int x = j+1;
                    int y = i+1;
                    //Ищем конечную координату по ширине
                    while (x < width)if (a[i][x++] == 0) break;
                    //Ищем конечную координату по высоте
                    while (y < height)if (a[y++][j] == 0) break;
                    //зарисовываем найденный прямоугольник нулями, чтобы не мешался
                    for (int tmpI = i; tmpI < y; tmpI++)
                        for (int tmpJ = j; tmpJ < x; tmpJ++) a[tmpI][tmpJ] = 0;
                }
            }
        }
        
        return count;
    }
}
