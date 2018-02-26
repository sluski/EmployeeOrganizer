package organizerpro.pl.controllers;

import daoClass.Dao;
import entity.TTask;
import java.util.List;

public class TaskController {
    private final Dao dao;
    
    public TaskController(){
        dao  = new Dao();
    }
    
     public List<TTask> selectAllTasks() {
        return dao.returnAllObjects("TTask");
    }
    
    public void createTask(TTask newTask) {
        dao.addObject(newTask);
    }
    
    public void remove(TTask taskToRemove){
        dao.removeObject(taskToRemove, taskToRemove.getId());
    }
}
