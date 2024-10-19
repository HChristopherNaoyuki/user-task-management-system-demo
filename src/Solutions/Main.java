package Solutions;

import javax.swing.JOptionPane;

/**
 * Main class to run the User Management System and Task Management functionalities.
 */
public class Main 
{
    public static void main(String[] args) 
    {
        UserManagementSystem ums = new UserManagementSystem();
        TaskManager taskManager = new TaskManager();
        SearchManager searchManager = new SearchManager();

        // User Registration and Login
        String userName = JOptionPane.showInputDialog("Welcome! Please enter your username (must include an underscore):");
        String password = JOptionPane.showInputDialog("Please enter a password (minimum 8 characters):");
        String firstName = JOptionPane.showInputDialog("Please enter your first name:");
        String lastName = JOptionPane.showInputDialog("Please enter your last name:");
        
        String registrationMessage = ums.registerUser(userName, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);

        // Attempt user login
        boolean loggedIn = ums.loginUser(userName, password);
        JOptionPane.showMessageDialog(null, ums.returnLoginStatus(loggedIn));

        // If logged in, proceed to task management
        if (loggedIn) 
        {
            boolean continueManagingTasks = true;

            while (continueManagingTasks) 
            {
                String menuOptions = "1: Add Tasks\n2: Search Tasks\n3: Quit";
                String menuInput = JOptionPane.showInputDialog(menuOptions);
                
                try 
                {
                    int menuOption = Integer.parseInt(menuInput);
                    switch (menuOption) 
                    {
                        case 1:
                            taskManager.addTasks();
                            break;
                        case 2:
                            String[] tasks = {"Create Login", "Create Add Features", "Create Reports", "Create Arrays"};
                            String[] developers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
                            String searchTerm = JOptionPane.showInputDialog("Enter the task name you want to search:");
                            String searchResult = searchManager.searchByTask(searchTerm, tasks, developers);
                            JOptionPane.showMessageDialog(null, searchResult);
                            break;
                        case 3:
                            continueManagingTasks = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid menu item.");
                    }
                } 
                catch (NumberFormatException e) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number corresponding to the menu options.");
                }
            }
        }
    }
}
