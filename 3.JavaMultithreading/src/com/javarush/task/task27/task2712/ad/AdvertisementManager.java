package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Advertisement manager.
 * Объект менеджера, который подбирает оптимальный набор роликов и их последовательность для каждого заказа.
 *
 * @autor mvl on 26.06.2017.
 */
public class AdvertisementManager {
    /**
     * The Storage.
     */
    AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    /**
     * Instantiates a new Advertisement manager.
     *
     * @param timeSeconds время выполнения заказа
     */
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    /**
     * Process videos.
     *
     * @throws NoVideoAvailableException the no video available exception
     */
    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();

        //Сортируем список доступных видео (п 9.2.4)
        Collections.sort(storage.list(), (o1, o2) -> {
            //первичная сортировка - в порядке уменьшения стоимости показа одного рекламного ролика в копейках
            if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());

            //вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
            if (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() != o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration())
                return Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(), o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());

            return 0;
        });

        List<Advertisement> advertisements = maxMany(storage.list());

        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();

        for (Advertisement advertisement : advertisements)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
            advertisement.revalidate();
        }
    }

    /**
     * Рекурсивно подбирает список видео из доступных, просмотр которых обеспечивает максимальную выгоду
     * т.е.
     * - сумма денег, полученная от показов, максимальна из всех возможных вариантов
     * - общее время показа не превышает время приготовления блюд текущего заказа
     * - для одного заказа любой видеоролик показывается не более одного раза
     */
    private List<Advertisement> maxMany(List<Advertisement> advertisements) {
        //общее время показа роликов в секундах
        int timeD = 0;
        //перебираем список доступных видео и определяем общее время показа роликов
        for (Advertisement advertisement : advertisements)
            timeD += advertisement.getDuration();

        //если общее время показа роликов превышает время приготовления заказа
        if (timeD > timeSeconds) {
            //отбираем ролики которые войдут в интервал времени приготовления заказа
            List<Advertisement> adv = new ArrayList<>();
            timeD = 0;
            for (Advertisement el : advertisements) {
                timeD += el.getDuration();
                if (timeD <= timeSeconds)
                    adv.add(el);

            }

            for (int i = 0; i < advertisements.size(); i++) {
                List<Advertisement> list = new ArrayList<>(advertisements);
                list.remove(i);
                int timeD2 = 0;

                for (Advertisement advertisement2 : list)
                    timeD2 += advertisement2.getDuration();

                if (timeD2 > timeSeconds)
                    list = maxMany(list);

                if (adv.size() > 0) {
                    compareAd(adv, list);
                }
                else {
                    adv.addAll(list);
                }
            }
            return adv;
        } else {
            return advertisements;
        }
    }


    private void compareAd(List<Advertisement> advertisements, List<Advertisement> list) {
        long sum = 0;
        long sum2 = 0;
        int sumt = 0;
        int sumt2 = 0;
        int k = 0;
        int k2 = 0;
        for (Advertisement el : advertisements) {
            sum += el.getAmountPerOneDisplaying();
            sumt += el.getDuration();
            k++;
        }
        for (Advertisement el : list) {
            sum2 += el.getAmountPerOneDisplaying();
            sumt2 += el.getDuration();
            k2++;
        }
        if (sum < sum2) {
            advertisements.clear();
            advertisements.addAll(list);
        } else if (sum == sum2) {
            if (sumt < sumt2) {
                advertisements.clear();
                advertisements.addAll(list);
            } else if (sumt == sumt2) {
                if (k > k2) {
                    advertisements.clear();
                    advertisements.addAll(list);
                }
            }
        }
    }
}
