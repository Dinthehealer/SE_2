package Model;

public class WithdrawUpdate {
    DatabaseConnection databaseConnection=databaseConnection=new DatabaseConnection();
    private String []Data=new String[5];

    public String[] CheckData(String id){
        Data= databaseConnection.findRow(id);
        return Data;
    }

    public void withdrawUpdate(String id,String money){
        Data=CheckData(id);
        int uid=Integer.parseInt(id);double inputmoney=Double.parseDouble(money);
        Double balanceupdate=Double.parseDouble(Data[4]);
        databaseConnection.dbUpdate(uid,balanceupdate-inputmoney);
    }
    public void TranUpdate(String sid,String id,String money){
        Data=CheckData(id);
        int uid=Integer.parseInt(id);double inputmoney=Double.parseDouble(money);
        Double balanceupdate=Double.parseDouble(Data[4]);
        databaseConnection.dbUpdate(uid,balanceupdate+inputmoney);
        Data=CheckData(sid);
        uid=Integer.parseInt(sid);inputmoney=Double.parseDouble(money);
        balanceupdate=Double.parseDouble(Data[4]);
        databaseConnection.dbUpdate(uid,balanceupdate-inputmoney);
    }
}
