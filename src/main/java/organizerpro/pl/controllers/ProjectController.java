package organizerpro.pl.controllers;

import daoClass.Dao;
import entity.TProject;
import java.util.List;

public class ProjectController {
    private Dao dao;

    public ProjectController() {
        dao = new Dao();
    }
    
    public List<TProject> returnAllProjects() {
        return dao.returnAllObjects("TProject");
    }
    
    public void addProject(TProject project){
        dao.addObject(project);
    }
    
    public void removeProject (TProject projectToRemove){
        dao.removeObject(projectToRemove, projectToRemove.getId());
    }
    
    public void updateProject (TProject projectToUpdate){
        dao.updateObject(projectToUpdate);
    }
}
