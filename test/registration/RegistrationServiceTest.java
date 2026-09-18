/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package registration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class RegistrationServiceTest {
    
    public RegistrationServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class RegistrationService.
     */
@Test
public void testCheckUserName() {
    System.out.println("checkUserName");
    RegistrationService instance = new RegistrationService();

    boolean result = instance.checkUserName("kt_p");
    assertEquals(true, result);
}
    /**
     * Test of checkPasswordComplexity method, of class RegistrationService.
     */
    @Test
public void testCheckPasswordComplexity() {
    System.out.println("checkPasswordComplexity");
    RegistrationService instance = new RegistrationService();

    boolean result = instance.checkPasswordComplexity("Ch&&sec@ke99!");
    assertEquals(true, result);
}
    /**
     * Test of checkCellPhoneNumber method, of class RegistrationService.
     */
    @Test
public void testCheckCellPhoneNumber() {
    System.out.println("checkCellPhoneNumber");
    RegistrationService instance = new RegistrationService();

    boolean result = instance.checkCellPhoneNumber("+27838968976");
    assertEquals(true, result);
}

    /**
     * Test of registerUser method, of class RegistrationService.
     */
   @Test
public void testRegisterUser() {
    System.out.println("registerUser");
    RegistrationService instance = new RegistrationService();

    String result = instance.registerUser("kt_p", "Ch&&sec@ke99!", "+27838968976");
    assertEquals("User kt_p successfully registered !!", result);
}
    /**
     * Test of loginUser method, of class RegistrationService.
     */
  @Test
public void testLoginUser() {
    System.out.println("loginUser");
    RegistrationService instance = new RegistrationService();
    instance.registerUser("kt_p", "Ch&&sec@ke99!", "+27838968976");

    boolean result = instance.loginUser("kt_p", "Ch&&sec@ke99!");
    assertEquals(true, result);
}

    /**
     * Test of returnLoginStatus method, of class RegistrationService.
     */
   @Test
public void testReturnLoginStatus() {
    System.out.println("returnLoginStatus");
    RegistrationService instance = new RegistrationService();

    String result = instance.returnLoginStatus("kt_p", true);
    assertEquals("Welcome kt_p, it is great to see you again.", result);
}
    
}
