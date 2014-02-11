package com.meng.simple.login

import grails.test.mixin.TestFor

@TestFor(Menu)
class MenuTests {

    void testSaveMenu() {
        Menu e = new Menu()
        e.code = 'MENU-001'
        e.description = 'description of MENU-001'
        e.save(failOnError: true)

        println(e)
        assertNotNull(e.id)
    }
}
