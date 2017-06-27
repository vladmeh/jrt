package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Advertisement storage.
 * Хранилище рекламных роликов
 *
 * @autor mvl on 26.06.2017.
 */
public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
    }

    /**
     * List list.
     * Список всех существующих доступных видео
     *
     * @return the list
     */
    public List<Advertisement> list(){
        return videos;
    }

    /**
     * Add.
     * Добавляет новое видео в список
     *
     * @param advertisement the advertisement
     */
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
