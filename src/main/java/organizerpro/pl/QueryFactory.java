package organizerpro.pl;

import java.util.List;

public class QueryFactory {
    private String tableName;
    List<WhereArgs> argsList;
    
    public QueryFactory(String tableName){
        this.tableName = tableName;
    }
    
    public String createQueryToFindMany(List<WhereArgs> argsList){
        String query = "select e from " + tableName + " e where 1=1";
        for (WhereArgs whereArgs : argsList){
            query += " and e." + whereArgs.getColumnName() + " = '" + whereArgs.getValue() + "'";
        }
        return query;
    }
    
    public String createQueryToFindOne(WhereArgs objectToFind){
        String query = "select e from " + tableName + " e where e." + objectToFind.getColumnName() + " = '" + objectToFind.getValue() + "'";
        return query;
    }
    
}
