package Solutions;

/**
 * Represents a user in the system with their credentials and personal details.
 */
public class User 
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    /**
     * Constructor to initialize User details.
     * 
     * @param username The user's username.
     * @param password The user's password.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     */
    public User(String username, String password, String firstName, String lastName) 
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }
}
