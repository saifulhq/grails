package com.meng.grails.domain

abstract class AuditableBase {
    String createBy;
    Date createDate;
    String modifyBy;
    Date modifyDate;

    static constraints = {
        createBy(nullable: true)
        createDate(nullable: true)
        modifyBy(nullable: true)
        modifyDate(nullable: true)
    }
}