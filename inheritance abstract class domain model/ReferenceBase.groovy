package com.meng.grails.domain

abstract class ReferenceBase extends AuditableBase {
    String code;
    String description;

    static constraints = {
        code(unique: true, nullable: false, maxSize: 50)
        description(nullable: false)
    }
}