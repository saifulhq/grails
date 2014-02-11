package simple.login

import com.meng.simple.login.Menu
import com.meng.simple.login.Role
import com.meng.simple.login.User
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

class UserIntegrationTests {

    Menu menuAdmin, menuOperator
    Role roleAdmin, roleOperator

    @Before
    void setUp() {
        menuAdmin = new Menu()
        menuAdmin.code = 'ADM-MENU-001'
        menuAdmin.description = 'Description of ADM-MENU-001'
        menuAdmin.save(failOnError: true)
        assertNotNull(menuAdmin.id)

        menuOperator = new Menu()
        menuOperator.code = 'OPR-MENU-001'
        menuOperator.description = 'Description of OPR-MENU-001'
        menuOperator.save(failOnError: true)
        assertNotNull(menuOperator.id)

        roleAdmin = new Role()
        roleAdmin.code = 'ROLE-ADMIN'
        roleAdmin.description = 'Description of ROLE-ADMIN'
        roleAdmin.addToMenus(menuAdmin)
        roleAdmin.save(failOnError: true)
        assertNotNull(roleAdmin.id)
        assertTrue(roleAdmin.menus.size() > 0)

        roleOperator = new Role()
        roleOperator.code = 'ROLE-OPERATOR'
        roleOperator.description = 'Description of ROLE-OPERATOR'
        roleOperator.addToMenus(menuOperator)
        roleOperator.save(failOnError: true)
        assertNotNull(roleOperator.id)
        assertTrue(roleOperator.menus.size() > 0)

        printSetUp()
    }

    private void printSetUp() {
        println("menuAdmin: " + menuAdmin)
        println("menuOperator: " + menuOperator)
        println("roleAdmin: " + roleAdmin)
        println("roleOperator: " + roleOperator)
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testIntUserSave() {
        User userAdmin = new User();
        userAdmin.setUserName("admin");
        userAdmin.setFirst_name("admin");
        userAdmin.setPassword("12345")
        userAdmin.addToRoles(roleAdmin)
        userAdmin.save(failOnError: true)
        userAdmin.addToRoles(roleOperator)
        userAdmin.addToRoles(roleAdmin)
        assertNotNull(userAdmin.id)

        User entity = new User();
        entity.setUserName("saiful.haqqi");
        entity.setFirst_name("saiful");
        entity.setLast_name("haqqi");
        entity.setPassword("my password")
        entity.addToRoles(roleOperator)
        entity.save(failOnError: true)
        assertNotNull(entity.id)

        /*
         * print find user
         */
        assertTrue(User.list().size() > 0)
        println(User.list())
    }
}