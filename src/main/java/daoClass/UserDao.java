package daoClass;

import entity.TEmployee;
import java.util.ArrayList;
import java.util.List;
import organizerpro.pl.WhereArgs;

public class UserDao extends Dao {

    public UserDao() {
    }

    public TEmployee findUser(String email, String password) {
        TEmployee foundUser = null;
        List<WhereArgs> userArgs = new ArrayList<>();
        userArgs.add(new WhereArgs("email", email));
        userArgs.add(new WhereArgs("password", password));
        List<TEmployee> resultList = findObject("TEmployee", userArgs);
        if (resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
    
    public void removeUser(){
        
    }
}
