package com.javarush.task.level16.concurrency;

/**
 * Новая реализация іnnerclasses/GreenhouseController.java
 * с использованием ScheduledThreadPoolExecutor.
 * {Args: 5000}
 *
 */

import java.util.concurrent.*;
import java.util.*;

/**
 * The type Greenhouse scheduler.
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    /**
     * Gets thermostat.
     *
     * @return the thermostat
     */
    public synchronized String getThermostat() {
        return thermostat;
    }

    /**
     * Sets thermostat.
     *
     * @param value the value
     */
    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    /**
     * The Scheduler.
     */
    ScheduledThreadPoolExecutor scheduler =
            new ScheduledThreadPoolExecutor(10);

    /**
     * Schedule.
     *
     * @param event the event
     * @param delay the delay
     */
    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event,delay,TimeUnit.MILLISECONDS);
    }

    /**
     * Repeat.
     *
     * @param event        the event
     * @param initialDelay the initial delay
     * @param period       the period
     */
    public void
    repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(
                event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    /**
     * The type Light on.
     */
    class LightOn implements Runnable {
        public void run() {
            // Put hardware control code here to
            // physically turn on the light.
            System.out.println("Turning on lights");
            light = true;
        }
    }

    /**
     * The type Light off.
     */
    class LightOff implements Runnable {
        public void run() {
            // Put hardware control code here to
            // physically turn off the light.
            System.out.println("Turning off lights");
            light = false;
        }
    }

    /**
     * The type Water on.
     */
    class WaterOn implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    /**
     * The type Water off.
     */
    class WaterOff implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    /**
     * The type Thermostat night.
     */
    class ThermostatNight implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    /**
     * The type Thermostat day.
     */
    class ThermostatDay implements Runnable {
        public void run() {
            // Put hardware control code here.
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    /**
     * The type Bell.
     */
    class Bell implements Runnable {
        public void run() { System.out.println("Bing!"); }
    }

    /**
     * The type Terminate.
     */
    class Terminate implements Runnable {
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
            // Must start a separate task to do this job,
            // since the scheduler has been shut down:
            new Thread() {
                public void run() {
                    for(DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }
    }

    /**
     * The type Data point.
     */
// New feature: data collection
    static class DataPoint {
        /**
         * The Time.
         */
        final Calendar time;
        /**
         * The Temperature.
         */
        final float temperature;
        /**
         * The Humidity.
         */
        final float humidity;

        /**
         * Instantiates a new Data point.
         *
         * @param d    the d
         * @param temp the temp
         * @param hum  the hum
         */
        public DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }
        public String toString() {
            return time.getTime() +
                    String.format(
                            " temperature: %1$.1f humidity: %2$.2f",
                            temperature, humidity);
        }
    }
    private Calendar lastTime = Calendar.getInstance();
    { // Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    /**
     * The Data.
     */
    List<DataPoint> data = Collections.synchronizedList(
            new ArrayList<DataPoint>());

    /**
     * The type Collect data.
     */
    class CollectData implements Runnable {
        public void run() {
            System.out.println("Collecting data");
            synchronized(GreenhouseScheduler.this) {
                // Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE,
                        lastTime.get(Calendar.MINUTE) + 30);
                // One in 5 chances of reversing the direction:
                if(rand.nextInt(5) == 4)
                    tempDirection = -tempDirection;
                // Store previous value:
                lastTemp = lastTemp +
                        tempDirection * (1.0f + rand.nextFloat());
                if(rand.nextInt(5) == 4)
                    humidityDirection = -humidityDirection;
                lastHumidity = lastHumidity +
                        humidityDirection * rand.nextFloat();
                // Calendar must be cloned, otherwise all
                // DataPoints hold references to the same lastTime.
                // For a basic object like Calendar, clone() is OK.
                data.add(new DataPoint((Calendar)lastTime.clone(),
                        lastTemp, lastHumidity));
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        // Former "Restart" class not necessary:
        gh.repeat(gh.new Bell(), 0, 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOff(), 0, 800);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new CollectData(), 500, 500);
    }
}