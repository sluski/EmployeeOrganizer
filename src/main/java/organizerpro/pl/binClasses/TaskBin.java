package organizerpro.pl.binClasses;

import entity.TTask;
import java.util.List;
import organizerpro.pl.controllers.TaskController;

@javax.faces.bean.ManagedBean
@javax.faces.bean.ViewScoped
public class TaskBin {

    private final TaskController taskController;

    private TTask newTask = new TTask();
    private TTask selectedTask;
    private java.util.Date start;
    private java.util.Date end;

    
    public TaskBin() {
        taskController = new TaskController();
    }

    public TTask getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(TTask selectedTask) {
        this.selectedTask = selectedTask;
    }

    public TTask getNewTask() {
        return newTask;
    }

    public void setNewTask(TTask newTask) {
        this.newTask = newTask;
    }

    public List<TTask> returnAllTasks() {
        return taskController.selectAllTasks();
    }

    public void createTask() {
        taskController.createTask(newTask);
    }
    
    public void remove(){
        taskController.remove(selectedTask);
    }
}
