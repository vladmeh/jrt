package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 05.06.2017.
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public void loadUsers() {
        //test
        List<User> usrList = new ArrayList<>();

        User user1 = new User("A", 1, 1);
        User user2 = new User("B", 2, 1);

        usrList.add(user1);
        usrList.add(user2);

        modelData.setUsers(usrList);
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }
}
