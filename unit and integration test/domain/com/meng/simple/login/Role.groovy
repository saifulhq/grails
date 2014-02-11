package com.meng.simple.login

import com.meng.grails.domain.ReferenceBase

class Role extends ReferenceBase {

    static belongsTo = [Menu]
    static hasMany = [menus: Menu, users : User]

    static constraints = {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", version=" + version +
                ", menus=" + menus?.size() +
                '}';
    }
}