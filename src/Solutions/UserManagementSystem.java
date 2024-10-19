package Solutions;

/**
 * Manages user registration and login functionalities.
 */
public class UserManagementSystem 
{
    private String storedUserName;
    private String storedPassword;
    private String storedFirstName;
    private String storedLastName;

    /**
     * Registers a new user with given credentials.
     * 
     * @param userName The username for registration.
     * @param password The password for registration.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @return A message indicating success or failure of registration.
     */
    public String registerUser(String userName, String password, String firstName, String lastName) 
    {
        // Validate username
        if (!isUserNameValid(userName)) 
        {
            return "Invalid username: must contain an underscore and be more than 4 characters.";
        }
        // Validate password
        if (!isPasswordComplex(password)) 
        {
            return "Invalid password: must be at least 8 characters.";
        }

        // Store user details
        storedUserName = userName;
        storedPassword = password;
        storedFirstName = firstName;
        storedLastName = lastName;
        return "User successfully registered!";
    }

    /**
     * Validates the format of the username.
     * 
     * @param userName The username to validate.
     * @return true if valid, false otherwise.
     */
    public boolean isUserNameValid(String userName) 
    {
        return userName.length() > 4 && userName.contains("_");
    }

    /**
     * Checks the complexity requirements for the password.
     * 
     * @param password The password to check.
     * @return true if valid, false otherwise.
     */
    public boolean isPasswordComplex(String password) 
    {
        return password.length() >= 8;
    }

    /**
     * Logs in a user with the provided credentials.
     * 
     * @param userName The username to log in with.
     * @param password The password to log in with.
     * @return true if login is successful, false otherwise.
     */
    public boolean loginUser(String userName, String password) 
    {
        return storedUserName != null && storedUserName.equals(userName) &&
               storedPassword != null && storedPassword.equals(password);
    }

    /**
     * Returns a message based on the login status.
     * 
     * @param loggedIn The status of the login attempt.
     * @return A welcome message or an error message.
     */
    public String returnLoginStatus(boolean loggedIn) 
    {
        if (loggedIn) 
        {
            return "Welcome " + storedFirstName + " " + storedLastName + ", great to see you again.";
        } 
        else 
        {
            return "Username or password incorrect, please try again.";
        }
    }
}
