package Solutions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for UserManagementSystem functionalities.
 */
public class UserManagementSystemTest 
{
    // Test successful user registration
    @Test
    public void testRegisterUserSuccess() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        String result = ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertEquals("User successfully registered!", result);
    }

    // Test registration with invalid username (no underscore)
    @Test
    public void testRegisterUserInvalidUsername() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        String result = ums.registerUser("invaliduser", "validPassword", "First", "Last");
        assertEquals("Invalid username: must contain an underscore and be more than 4 characters.", result);
    }

    // Test registration with invalid password (too short)
    @Test
    public void testRegisterUserInvalidPassword() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        String result = ums.registerUser("valid_user", "short", "First", "Last");
        assertEquals("Invalid password: must be at least 8 characters.", result);
    }

    // Test valid username format
    @Test
    public void testIsUserNameValid() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertTrue(ums.isUserNameValid("valid_user"));
    }

    // Test invalid username formats
    @Test
    public void testIsUserNameInvalid() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertFalse(ums.isUserNameValid("invaliduser")); // No underscore
        assertFalse(ums.isUserNameValid("user@name"));   // Contains special character
    }

    // Test password complexity requirements
    @Test
    public void testIsPasswordComplex() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertTrue(ums.isPasswordComplex("validPassword"));
        assertFalse(ums.isPasswordComplex("short")); // Too short
    }

    // Test successful login
    @Test
    public void testLoginUserSuccess() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertTrue(ums.loginUser("valid_user", "validPassword"));
    }

    // Test login failure with incorrect credentials
    @Test
    public void testLoginUserFailure() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertFalse(ums.loginUser("invalid_user", "validPassword")); // Wrong username
        assertFalse(ums.loginUser("valid_user", "wrongPassword"));   // Wrong password
    }

    // Test return login status for a successful login
    @Test
    public void testReturnLoginStatusSuccess() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertEquals("Welcome First Last, great to see you again.", ums.returnLoginStatus(true));
    }

    // Test return login status for a failed login
    @Test
    public void testReturnLoginStatusFailure() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertEquals("Username or password incorrect, please try again.", ums.returnLoginStatus(false));
    }
}
