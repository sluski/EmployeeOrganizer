package organizerpro.pl.binClasses;

import entity.TEmployee;
import entity.TTask;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import organizerpro.pl.controllers.EmployeeController;

@javax.faces.bean.ManagedBean
@javax.faces.bean.ViewScoped
public class EmployeeBin {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmedPassword;
    private int permissions;
    private int reward;
    private List<TTask> tasksList;
    private List<TEmployee> foundEmployees;
    @ManagedProperty("#{employeeController}")
    private EmployeeController employeeController;
    private TEmployee employee;
    private Boolean registered;

    public EmployeeBin() {
        employee = new TEmployee();
        registered = false;
    }

    public Boolean isRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TTask> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<TTask> tasksList) {
        this.tasksList = tasksList;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public List<TEmployee> getFoundEmployees() {
        return foundEmployees;
    }

    public void setFoundEmployees(List<TEmployee> foundEmployees) {
        this.foundEmployees = foundEmployees;
    }

    public TEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(TEmployee employee) {
        this.employee = employee;
    }

    public String registration() {
        employee.setPermissions(3);
        TEmployee local_employee = employee;
        String confirmedPassword_local = confirmedPassword;
        employee = new TEmployee();
        registered = true;
        return employeeController.registration(local_employee, confirmedPassword_local);
    }

    public boolean emailExist(String email) {
        boolean result = employeeController.emailExist(email);
        clearVariable();
        return result;
    }

    public String loginUser() {
        TEmployee local_employee;
        local_employee = employee;
        employee = new TEmployee();
        return employeeController.login(local_employee);
    }

    public List<TEmployee> returnAllEmployees() {
        return employeeController.returnAllEmployees();
    }

    public void removeUser() {
        employeeController.removeUser(employee);
    }

    public void modify() {
        employeeController.modifyEmployee(employee);
    }

    public String skipLogin() {
        if (employeeController.skipLogin() == true) {
            return "startpage_logged";
        } else {
            return "login";
        }
    }

    public void clearVariable() {
        firstName = null;
        lastName = null;
        email = null;
        password = null;
        confirmedPassword = null;
        permissions = 0;
        reward = 0;
        tasksList = null;
        foundEmployees = null;
        employeeController = null;
        employee = null;
        registered = null;
    }

    public String checkData() {
        if (employeeController.checkData()) {
            return "";
        }
        return "PF('complete_dlg').show();";
    }

    @PostConstruct
    public void init() {
        employee = new TEmployee();
    }
    
    public TEmployee getLoggedUser(){
        return employeeController.getLoggedUser().getLoggedUser();
    }
}
