package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/
public class Solution {
    public void safeMethod(Object obj1, Object obj2) {

        int firstHash = System.identityHashCode(obj1);
        int secondHash = System.identityHashCode(obj2);

        Object firstMonitor = firstHash < secondHash ? obj1 : obj2;
        Object secondMonitor = firstHash < secondHash ? obj2 : obj1;

        synchronized (firstMonitor) {
            longTimeMethod();
            synchronized (secondMonitor) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread(() -> solution.safeMethod(o1, o2)).start();

        new Thread(() -> solution.safeMethod(o2, o1)).start();
    }
}
