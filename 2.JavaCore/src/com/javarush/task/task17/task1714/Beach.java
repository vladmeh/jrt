package com.javarush.task.task17.task1714;

/* 
Comparable

Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, которое показывает что первый пляж лучше(позитивное число)
или второй пляж лучше (негативное число),и насколько он лучше.


Требования:
1. Класс Beach должен содержать три поля: String name, float distance, int quality.
2. Класс Beach должен реализовывать интерфейс Comparable.
3. Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
4. Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.IntStream;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    public synchronized int length() {
        return name.length();
    }

    public synchronized boolean isEmpty() {
        return name.isEmpty();
    }

    public synchronized char charAt(int index) {
        return name.charAt(index);
    }

    public synchronized int codePointAt(int index) {
        return name.codePointAt(index);
    }

    public synchronized int codePointBefore(int index) {
        return name.codePointBefore(index);
    }

    public synchronized int codePointCount(int beginIndex, int endIndex) {
        return name.codePointCount(beginIndex, endIndex);
    }

    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        return name.offsetByCodePoints(index, codePointOffset);
    }

    public synchronized void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        name.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    @Deprecated
    public synchronized void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        name.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    public synchronized byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return name.getBytes(charsetName);
    }

    public synchronized byte[] getBytes(Charset charset) {
        return name.getBytes(charset);
    }

    public synchronized byte[] getBytes() {
        return name.getBytes();
    }

    public synchronized boolean contentEquals(StringBuffer sb) {
        return name.contentEquals(sb);
    }

    public synchronized boolean contentEquals(CharSequence cs) {
        return name.contentEquals(cs);
    }

    public synchronized boolean equalsIgnoreCase(String anotherString) {
        return name.equalsIgnoreCase(anotherString);
    }

    public synchronized int compareTo(String anotherString) {
        return name.compareTo(anotherString);
    }

    public synchronized int compareToIgnoreCase(String str) {
        return name.compareToIgnoreCase(str);
    }

    public synchronized boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return name.regionMatches(toffset, other, ooffset, len);
    }

    public synchronized boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return name.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    public synchronized boolean startsWith(String prefix, int toffset) {
        return name.startsWith(prefix, toffset);
    }

    public synchronized boolean startsWith(String prefix) {
        return name.startsWith(prefix);
    }

    public synchronized boolean endsWith(String suffix) {
        return name.endsWith(suffix);
    }

    public synchronized int indexOf(int ch) {
        return name.indexOf(ch);
    }

    public synchronized int indexOf(int ch, int fromIndex) {
        return name.indexOf(ch, fromIndex);
    }

    public synchronized int lastIndexOf(int ch) {
        return name.lastIndexOf(ch);
    }

    public synchronized int lastIndexOf(int ch, int fromIndex) {
        return name.lastIndexOf(ch, fromIndex);
    }

    public synchronized int indexOf(String str) {
        return name.indexOf(str);
    }

    public synchronized int indexOf(String str, int fromIndex) {
        return name.indexOf(str, fromIndex);
    }

    public synchronized int lastIndexOf(String str) {
        return name.lastIndexOf(str);
    }

    public synchronized int lastIndexOf(String str, int fromIndex) {
        return name.lastIndexOf(str, fromIndex);
    }

    public synchronized String substring(int beginIndex) {
        return name.substring(beginIndex);
    }

    public synchronized String substring(int beginIndex, int endIndex) {
        return name.substring(beginIndex, endIndex);
    }

    public synchronized CharSequence subSequence(int beginIndex, int endIndex) {
        return name.subSequence(beginIndex, endIndex);
    }

    public synchronized String concat(String str) {
        return name.concat(str);
    }

    public synchronized String replace(char oldChar, char newChar) {
        return name.replace(oldChar, newChar);
    }

    public synchronized boolean matches(String regex) {
        return name.matches(regex);
    }

    public synchronized boolean contains(CharSequence s) {
        return name.contains(s);
    }

    public synchronized String replaceFirst(String regex, String replacement) {
        return name.replaceFirst(regex, replacement);
    }

    public synchronized String replaceAll(String regex, String replacement) {
        return name.replaceAll(regex, replacement);
    }

    public synchronized String replace(CharSequence target, CharSequence replacement) {
        return name.replace(target, replacement);
    }

    public synchronized String[] split(String regex, int limit) {
        return name.split(regex, limit);
    }

    public synchronized String[] split(String regex) {
        return name.split(regex);
    }

    public synchronized static String join(CharSequence delimiter, CharSequence... elements) {
        return String.join(delimiter, elements);
    }

    public synchronized static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
        return String.join(delimiter, elements);
    }

    public synchronized String toLowerCase(Locale locale) {
        return name.toLowerCase(locale);
    }

    public synchronized String toLowerCase() {
        return name.toLowerCase();
    }

    public synchronized String toUpperCase(Locale locale) {
        return name.toUpperCase(locale);
    }

    public synchronized String toUpperCase() {
        return name.toUpperCase();
    }

    public synchronized String trim() {
        return name.trim();
    }

    public synchronized char[] toCharArray() {
        return name.toCharArray();
    }

    public synchronized static String format(String format, Object... args) {
        return String.format(format, args);
    }

    public synchronized static String format(Locale l, String format, Object... args) {
        return String.format(l, format, args);
    }

    public synchronized static String valueOf(Object obj) {
        return String.valueOf(obj);
    }

    public synchronized static String valueOf(char[] data) {
        return String.valueOf(data);
    }

    public synchronized static String valueOf(char[] data, int offset, int count) {
        return String.valueOf(data, offset, count);
    }

    public synchronized static String copyValueOf(char[] data, int offset, int count) {
        return String.copyValueOf(data, offset, count);
    }

    public synchronized static String copyValueOf(char[] data) {
        return String.copyValueOf(data);
    }

    public synchronized static String valueOf(boolean b) {
        return String.valueOf(b);
    }

    public synchronized static String valueOf(char c) {
        return String.valueOf(c);
    }

    public synchronized static String valueOf(int i) {
        return String.valueOf(i);
    }

    public synchronized static String valueOf(long l) {
        return String.valueOf(l);
    }

    public synchronized static String valueOf(float f) {
        return String.valueOf(f);
    }

    public synchronized static String valueOf(double d) {
        return String.valueOf(d);
    }

    public synchronized String intern() {
        return name.intern();
    }

    public synchronized IntStream chars() {
        return name.chars();
    }

    public synchronized IntStream codePoints() {
        return name.codePoints();
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return quality - (int) distance - o.getQuality() + (int) o.getDistance();
    }
}
