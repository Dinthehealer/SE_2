package Model;

import Call.Control;

public class DepositCheckData {
    DatabaseConnection databaseConnection=databaseConnection=new DatabaseConnection();
    private String []Data=new String[5];
    public String[] CheckData(String id){
        Data= databaseConnection.findRow(id);
        return Data;
    }
    public void addMoney(String id,String money){
        Data=CheckData(id);
        int uid=Integer.parseInt(id);double inputmoney=Double.parseDouble(money);
        Double balanceupdate=Double.parseDouble(Data[4]);
        databaseConnection.dbUpdate(uid,balanceupdate+inputmoney);
    }
    public String[] CheckData(String id,String money,int in){
        Data= databaseConnection.findRow(id);
        double a = Double.parseDouble(Data[4]); a -= Double.parseDouble(money);
        Data [4] = String.valueOf(a);
        return Data;
    }
    public boolean checkinput(String id,String money){
        Data=CheckData(id);
        int uid=Integer.parseInt(id);double inputmoney=Double.parseDouble(money);
        Double balanceupdate=Double.parseDouble(Data[4]);
        if((balanceupdate-inputmoney)%100!=0){
            return false;
        }
        return true;
    }
}
