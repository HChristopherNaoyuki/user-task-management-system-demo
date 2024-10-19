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
        String userName = JOptionPane.showInputDialog("Enter Username:");
        String password = JOptionPane.showInputDialog("Enter Password:");
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        
        String registrationMessage = ums.registerUser(userName, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);

        boolean loggedIn = ums.loginUser(userName, password);
        JOptionPane.showMessageDialog(null, ums.returnLoginStatus(loggedIn));

        // If logged in, proceed to task management
        if (loggedIn) 
        {
            boolean continueManagingTasks = true;

            while (continueManagingTasks) 
            {
                int menuOption = Integer.parseInt(JOptionPane.showInputDialog("1: Add Tasks, 2: Search Tasks, 3: Quit"));

                switch (menuOption) 
                {
                    case 1:
                        taskManager.addTasks();
                        break;
                    case 2:
                        String[] tasks = {"Create Login", "Create Add Features", "Create Reports", "Create Arrays"};
                        String[] developers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
                        String searchTerm = JOptionPane.showInputDialog("Enter task name to search:");
                        String searchResult = searchManager.searchByTask(searchTerm, tasks, developers);
                        JOptionPane.showMessageDialog(null, searchResult);
                        break;
                    case 3:
                        continueManagingTasks = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
            }
        }
    }
}
