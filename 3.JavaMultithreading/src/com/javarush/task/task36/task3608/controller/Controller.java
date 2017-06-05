package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.*;

/**
 * @autor mvl on 05.06.2017.
 */
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers(){
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId){
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }
}
