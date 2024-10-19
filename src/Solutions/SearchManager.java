package Solutions;

import javax.swing.JOptionPane;

/**
 * Manages searching tasks based on given criteria.
 */
public class SearchManager 
{
    /**
     * Searches for a task by name and displays the associated developer.
     * 
     * @param taskName The name of the task to search for.
     * @param tasks An array of task names.
     * @param developers An array of developer names.
     * @return A string containing the search result.
     */
    public String searchByTask(String taskName, String[] tasks, String[] developers) 
    {
        for (int i = 0; i < tasks.length; i++) 
        {
            if (tasks[i].equalsIgnoreCase(taskName)) 
            {
                return tasks[i] + " is assigned to " + developers[i];
            }
        }
        return "No tasks match the search term: " + taskName + ". Please try again.";
    }
}
