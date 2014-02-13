package com.testapp

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class SecureController {

    @Secured(['ROLE_ADMIN'])
    def index() {
        [title: "index only for role admin"]
    }

    def list() {
        [title: "Role operator only"]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save() {
        [title: "index only for role admin and user"]
    }
}