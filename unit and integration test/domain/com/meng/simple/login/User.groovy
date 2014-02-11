package com.meng.simple.login

import com.meng.grails.domain.AuditableBase

class User extends AuditableBase {

    String userName
    String password
    String first_name
    String last_name
    Set<Role> roles

    static belongsTo = [Role]
    static hasMany = [roles : Role]
    static constraints = {
        password(nullable: false, maxSize: 255)
        userName(unique: true, nullable: false, maxSize: 15)
        first_name(nullable: false, maxSize: 30)
        last_name(nullable: true, maxSize: 30)
        roles (nullable : true)
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", version=" + version +
                ", role=" + (roles?.size()) +
                '}';
    }
}