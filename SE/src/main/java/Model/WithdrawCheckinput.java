package Model;

public class WithdrawCheckinput {
    DatabaseConnection databaseConnection=databaseConnection=new DatabaseConnection();
    private String []Data=new String[5];
    public String[] CheckData(String id){
        Data= databaseConnection.findRow(id);
        return Data;
    }
    public boolean checkinput(String id,String money){
        Data=CheckData(id);double inputmoney;
        try{
            int uid=Integer.parseInt(id); inputmoney=Double.parseDouble(money);
        }catch (Exception e){
            return false;
        }
        Double balanceupdate=Double.parseDouble(Data[4]);
        if((balanceupdate-inputmoney)<0||(balanceupdate-inputmoney)%100!=0){
            return false;
        }
        return true;
    }
}
