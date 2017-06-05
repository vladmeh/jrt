package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;

/**
 * @autor mvl on 05.06.2017.
 */
public class Controller {
    private Model model;

    public void onShowAllUsers(){
        model.loadUsers();
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
