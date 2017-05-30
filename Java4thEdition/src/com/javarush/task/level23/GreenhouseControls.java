package com.javarush.task.level23;

import com.javarush.task.level23.controller.*;

/**
 * Пример конкретного приложения на основе системы
 * управления, все находится в одном классе. Внутренние
 * классы дают возможность инкапсулировать различную
 * функциональность для каждого отдельного события
 */
public class GreenhouseControls extends Controller{
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) { super(delayTime); }
        public void action() {
            // Сюда помещается аппаратный вызов
            // физическое включение света
            light = true;
        }
        public String toString() { return "Light is on"; }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) { super(delayTime); }
        public void action() {
            // Сюда помещается аппаратный вызов
            // физическое выключение света
            light = false;
        }
        public String toString() { return "Light is off"; }
    }

    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) { super(delayTime); }
        public void action() {
            // Сюда помещается аппаратный вызов.
            // выключения системы полива
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) { super(delayTime); }
        public void action() {
            // Сюда помещается аппаратный вызов.
            // выключения системы полива
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    private String thermostat = "Day";
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Сюда помещается аппаратный вызов.
            // thermostat = "Ночь";
            thermostat = "Night";
        }
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        public void action() {
            // Сюда помещается аппаратный вызов.
            // thermostat = "День"
            thermostat = "Day";
        }

        public String toString() {
            return "Thermostat on day setting";
        }
    }

    // Пример метода action(), вставляющего
    // самого себя в список событий.
    public class Bell extends Event {
        public Bell(long delayTime) { super(delayTime); }
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString() { return "Bing!"; }
    }

    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList)
                addEvent(e);
        }
        public void action() {
            for(Event e : eventList) {
                e.start(); // Перезапуск каждый раз
                addEvent(e);
            }
            start(); // Возвращаем это событие Event
            addEvent(this);
        }
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) { super(delayTime); }
        public void action() { System.exit(0); }
        public String toString() { return "Terminating";  }
    }
}
