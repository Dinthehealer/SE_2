package Model;

public class LoginCheck {
    public boolean Check(String userid,String userpass){
        boolean stat=false;
        try{
            int id=Integer.parseInt(userid);
            int pass=Integer.parseInt(userpass);
             stat=CheckId(userid,userpass);
            return stat;
        }
        catch (Exception e){
            return stat;
        }
     }
    public boolean CheckId(String id,String pass){
        boolean stat=false;
        DatabaseConnection databaseConnection=new DatabaseConnection();
        stat=databaseConnection.findRow(id,pass);
        return stat;
    }
}
