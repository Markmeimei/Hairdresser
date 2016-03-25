package com.eron.hairdresser.model;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/24.
 */
public class AddForm_Model {
    private List<String> project;
    private List<String> money;

    public List<String> getProject() {
        return project;
    }

    public void setProject(List<String> project) {
        this.project = project;
    }

    public List<String> getMoney() {
        return money;
    }

    public void setMoney(List<String> money) {
        this.money = money;
    }
}
