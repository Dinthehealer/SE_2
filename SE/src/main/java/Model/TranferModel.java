package Model;

public class TranferModel {
    DatabaseConnection databaseConnection=databaseConnection=new DatabaseConnection();
    private String []Data=new String[5];

    public String[] CheckData(String id){
        Data= databaseConnection.findRow(id);
        return Data;
    }
    public boolean checkID(String id){
        boolean findId=databaseConnection.findID(id);
        return  findId;
    }
}
