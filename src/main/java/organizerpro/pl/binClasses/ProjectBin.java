package organizerpro.pl.binClasses;

import organizerpro.pl.controllers.ProjectController;
import entity.TProject;
import entity.TTask;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@javax.faces.bean.ManagedBean
@javax.faces.bean.ViewScoped
public class ProjectBin implements java.io.Serializable{

    private String name;
    private String category;
    private String priority;
    private java.util.Date term;
    private TTask newTask;
    private ProjectController projectControler;
    private TProject newProject;
    private TProject selectedProject;

    public ProjectBin() {
        newTask = new TTask();
        projectControler = new ProjectController();
        newProject = new TProject();
    }

    public ProjectController getProjectControler() {
        return projectControler;
    }

    public void setProjectControler(ProjectController projectControler) {
        this.projectControler = projectControler;
    }

    public TProject getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(TProject selectedProject) {
        this.selectedProject = selectedProject;
    }

    public TTask getNewTask() {
        return newTask;
    }

    public void setNewTask(TTask newTask) {
        this.newTask = newTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public java.util.Date getTerm() {
        return term;
    }

    public void setTerm(java.util.Date term) {
        this.term = term;
    }

    public TProject getNewProject() {
        return newProject;
    }

    public void setNewProject(TProject newProject) {
        this.newProject = newProject;
    }

    public List<TProject> returnAllProjects() {
        return projectControler.returnAllProjects();
    }

    public void addNewProject() {
        try {
            projectControler.addProject(newProject);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Project added");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch(Exception ex){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        newProject.setName(null);
        newProject.setTerm(null);
        newProject.setCategory(null);
        newProject.setPriority(null);
    }

    public void removeProject() {
        projectControler.removeProject(selectedProject);
        try {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Remove", "Project was removed");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch(Exception ex){
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void updateProject(){
        projectControler.updateProject(selectedProject);
    }
}
