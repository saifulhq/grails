package com.meng.simple.login

import com.meng.grails.domain.ReferenceBase

class Menu extends ReferenceBase {

    static hasMany = [roles: Role]
    static constraints = {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", version=" + version +
                ", roles=" + roles?.size() +
                '}';
    }
}