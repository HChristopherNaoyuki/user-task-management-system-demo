package Solutions;

public class UserManagementSystem 
{
    private String storedUserName;
    private String storedPassword;
    private String storedFirstName;
    private String storedLastName;

    // Method to register a user
    public String registerUser(String userName, String password, String firstName, String lastName) 
    {
        // Check for valid username
        if (!checkUserName(userName)) 
        {
            return "Invalid username: must contain an underscore and be 5 characters or less.";
        }
        // Check for valid password
        if (!checkPasswordComplexity(password)) 
        {
            return "Invalid password: must be at least 8 characters.";
        }

        // Store user details
        storedUserName = userName;
        storedPassword = password;
        storedFirstName = firstName;
        storedLastName = lastName;
        return "User successfully registered";
    }

    // Method to check username format
    public boolean checkUserName(String userName) 
    {
        // Username must be greater than 4 characters and contain an underscore
        return userName.length() > 4 && userName.contains("_");
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) 
    {
        // Password must be at least 8 characters
        return password.length() >= 8;
    }

    // Method to log in a user
    public boolean loginUser(String userName, String password) 
    {
        // Check if provided credentials match stored credentials
        return storedUserName != null && storedUserName.equals(userName) && storedPassword != null && storedPassword.equals(password);
    }

    // Method to return login status message
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
