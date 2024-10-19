package Solutions;

import javax.swing.JOptionPane;

/**
 * Handles the creation and management of tasks.
 */
public class TaskManager 
{
    private int totalHours;

    /**
     * Prompts the user to add tasks and calculates total hours.
     */
    public void addTasks() 
    {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks:"));
        totalHours = 0;

        for (int i = 0; i < numTasks; i++) 
        {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration in hours:"));
            totalHours += duration;

            String taskID = createTaskID(taskName, i);
            String taskStatus = JOptionPane.showInputDialog("Please select task status: To Do, Doing, Done:");
            String taskDetails = printTaskDetails(taskName, i, taskDescription, duration, taskID, taskStatus);

            JOptionPane.showMessageDialog(null, taskDetails);
        }

        JOptionPane.showMessageDialog(null, "Total task hours: " + totalHours);
    }

    /**
     * Creates a unique Task ID based on task details.
     * 
     * @param taskName The name of the task.
     * @param taskNumber The number of the task.
     * @return A unique task ID.
     */
    private String createTaskID(String taskName, int taskNumber) 
    {
        return taskName.substring(0, 2) + ":" + taskNumber;
    }

    /**
     * Prints the details of a task.
     * 
     * @param taskName The name of the task.
     * @param taskNumber The number of the task.
     * @param taskDescription The description of the task.
     * @param duration The duration of the task.
     * @param taskID The ID of the task.
     * @param taskStatus The status of the task.
     * @return A formatted string containing task details.
     */
    private String printTaskDetails(String taskName, int taskNumber, String taskDescription, int duration, String taskID, String taskStatus) 
    {
        return String.format("Task: %s, Number: %d, Description: %s, Duration: %d hours, ID: %s, Status: %s",
                             taskName, taskNumber, taskDescription, duration, taskID, taskStatus);
    }
}
