package Solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserManagementSystemTest 
{
    // Test 1: Check successful user registration
    @Test
    public void testRegisterUserSuccess() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        String result = ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertEquals("User successfully registered", result);
    }

    // Test 2: Check registration with invalid username (no underscore)
    @Test
    public void testRegisterUserInvalidUsername() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        String result = ums.registerUser("invaliduser", "validPassword", "First", "Last");
        assertEquals("Invalid username: must contain an underscore and be 5 characters or less.", result);
    }

    // Test 3: Check registration with invalid password (too short)
    @Test
    public void testRegisterUserInvalidPassword() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        String result = ums.registerUser("valid_user", "short", "First", "Last");
        assertEquals("Invalid password: must be at least 8 characters.", result);
    }

    // Test 4: Check valid username format
    @Test
    public void testCheckUserNameValid() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertTrue(ums.checkUserName("valid_user"));
    }

    // Test 5: Check invalid username formats
    @Test
    public void testCheckUserNameInvalid() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertFalse(ums.checkUserName("invaliduser")); // No underscore
        assertFalse(ums.checkUserName("user@name"));   // Contains special character
    }

    // Test 6: Check password complexity requirements
    @Test
    public void testCheckPasswordComplexity() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertTrue(ums.checkPasswordComplexity("validPassword"));
        assertFalse(ums.checkPasswordComplexity("short")); // Too short
    }

    // Test 7: Check successful login
    @Test
    public void testLoginUserSuccess() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertTrue(ums.loginUser("valid_user", "validPassword"));
    }

    // Test 8: Check login failure with incorrect credentials
    @Test
    public void testLoginUserFailure() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertFalse(ums.loginUser("invalid_user", "validPassword")); // Wrong username
        assertFalse(ums.loginUser("valid_user", "wrongPassword"));   // Wrong password
    }

    // Test 9: Check return login status for a successful login
    @Test
    public void testReturnLoginStatusSuccess() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        ums.registerUser("valid_user", "validPassword", "First", "Last");
        assertEquals("Welcome First Last, great to see you again.", ums.returnLoginStatus(true));
    }

    // Test 10: Check return login status for a failed login
    @Test
    public void testReturnLoginStatusFailure() 
    {
        UserManagementSystem ums = new UserManagementSystem();
        assertEquals("Username or password incorrect, please try again.", ums.returnLoginStatus(false));
    }
}
