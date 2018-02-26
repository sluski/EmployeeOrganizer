package organizerpro.pl.controllers;

import daoClass.Dao;
import daoClass.UserDao;
import entity.TEmployee;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import organizerpro.pl.binClasses.LoggedUsersBin;
import organizerpro.pl.WhereArgs;

@ManagedBean
@SessionScoped
public class EmployeeController {

    @ManagedProperty("#{loggedUsersBin }")
    LoggedUsersBin loggedUser;
    UserDao userDao;
    Dao dao;

    public LoggedUsersBin getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUsersBin loggedUser) {
        this.loggedUser = loggedUser;
    }

    public EmployeeController() {
        userDao = new UserDao();
        dao = new Dao();
    }

    public List<TEmployee> returnAllEmployees() {
        return dao.returnAllObjects("TEmployee");
    }

    public String registration(TEmployee newEmployee, String confirmedPassword) {
        try {
            WhereArgs userToCheck = new WhereArgs("email", newEmployee.getEmail());
            if (dao.findOneObject("TEmployee", userToCheck).isEmpty()) {
                if (confirmedPassword.equals(newEmployee.getPassword())) {
                    dao.addObject(newEmployee);
                    loggedUser.setLoggedUser(newEmployee);
                    return "/Logged/standard_view.xhtml?faces-redirect=true";
                } else {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Passwords are not the same");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    return null;
                }
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Email is in use");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
            }
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }

    public String login(TEmployee userToLogin) {
        try {
            TEmployee user = userDao.findUser(userToLogin.getEmail(), userToLogin.getPassword());
            if (user != null) {
                loggedUser.setLoggedUser(user);
                loggedUser.createTimeLine();
                return "/Logged/standard_view.xhtml?faces-redirect=true";
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Incorrect login or password");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
            }
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }

    public void removeUser(TEmployee userToRemove) {
        dao.removeObject(userToRemove, userToRemove.getId());
    }

    public void modifyEmployee(TEmployee userToModify) {
        if(userToModify.getId() == null) userToModify.setId(loggedUser.getLoggedUser().getId());
        if(userToModify.getEmail() == null) userToModify.setEmail(loggedUser.getLoggedUser().getEmail());
        if(userToModify.getPassword() == null) userToModify.setPassword(loggedUser.getLoggedUser().getPassword());
        dao.updateObject(userToModify);
        loggedUser.getLoggedUser().setFirstName(userToModify.getEmail());
        loggedUser.getLoggedUser().setLastName(userToModify.getLastName());
        loggedUser.getLoggedUser().setReward(userToModify.getReward());
    }

    public boolean skipLogin() {
        if (loggedUser.isLoggedIn() == true) {
            loggedUser.createTimeLine();
            return true;
        } else {
            return false;
        }
    }

    public boolean emailExist(String email) {
        WhereArgs emailToCheck = new WhereArgs("email", email);
        if (dao.findOneObject("TEmployee", emailToCheck).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkData() {
        if (loggedUser.getLoggedUser().getFirstName() == null || loggedUser.getLoggedUser().getLastName() == null) {
            return false;
        } else {
            return true;
        }
    }
}
