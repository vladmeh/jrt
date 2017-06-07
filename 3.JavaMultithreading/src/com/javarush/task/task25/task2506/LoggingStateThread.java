package com.javarush.task.task25.task2506;

/**
 * @autor mvl on 07.06.2017.
 */
public class LoggingStateThread extends Thread{
    private Thread target;

    public LoggingStateThread(Thread target) {
        //После завершения работы наблюдаемой нити, LoggingStateThread так же должен завершить работу.
        setDaemon(true);
        this.target = target;
    }

    //После запуска класс LoggingStateThread должен выводить в консоль изменения состояния переданной нити.
    @Override
    public void run() {
        State state = target.getState();
        System.out.println(state);
        while(state != State.TERMINATED)
        {
            if (state != target.getState())
            {
                state = target.getState();
                System.out.println(state);
            }
        }
    }
}
