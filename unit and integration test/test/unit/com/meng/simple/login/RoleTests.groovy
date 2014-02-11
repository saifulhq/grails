package com.meng.simple.login

import grails.test.mixin.TestFor

@TestFor(Role)
class RoleTests {

    void testSaveRole() {
        Role role = new Role()
        role.code = 'ROLE-001'
        role.description = 'Description of Role-001'
        role.save(failOnError: true)

        println(role)
        assertNotNull(role.id)
    }
}

