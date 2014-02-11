package com.meng.simple.login

import grails.test.mixin.*

@TestFor(User)
class UserTests {

    void testSaveUser() {
        def entity = new User(userName: 'username');
        entity.setUserName("saiful.haqqi");
        entity.setFirst_name("saiful");
        entity.setLast_name("haqqi");
        entity.setPassword("my password")
        entity.save(failOnError: true)
        assertNotNull(entity.id)
        assertTrue(User.list().size() > 0)
    }
}