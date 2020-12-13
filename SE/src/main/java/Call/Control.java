package Call;

import Model.*;
import Page.*;

public class Control {
    Login login;Financial finance; Deposit deposit;
    Withdraw withdraw; Tranfer tranfer;DepositCheck depositCheck;
    WithdrawUpdate withdrawUpdate;WithdrawCheckinput withdrawCheckinput;
    checkBalancePage balancePage;DepositCheckData checkData;
    TranferModel tranferModel;TranferCheck tranferCheck;
    public Control(){

    }
    public Control(int i){
        if(i==1){
            callLogin();
        }
    }
    public  void callLogin(){
        login=new Login();
        login.setVisible(true);
    }
    public  boolean callLogin(int i){
        login=new Login();
        login.setVisible(true);
        return false;
    }
    public boolean callLoginCheck(String userid,String userpass){
        LoginCheck loginCheck=new LoginCheck();
        boolean status=loginCheck.Check(userid,userpass);
        return status;
    }
    public boolean callFinancial(String userid){
        finance=new Financial(userid);
        finance.setVisible(true);
        return false;
    }
    public boolean callcheckbalance(String id){
        String []Data=new String[5];
        DepositCheckData checkData=new DepositCheckData();
        Data=checkData.CheckData(id);
        balancePage=new checkBalancePage(Data[1],Data[2],Data[3],Data[4]);
        balancePage.setVisible(true);
        return false;
    }
    public boolean callcheckbalance(String id,String money){
        String []Data=new String[5];
        DepositCheckData checkData=new DepositCheckData();
        checkData.addMoney(id,money);
        callFinancial(id);
        return false;
    }
    public boolean callDeposit(String id){
        deposit=new Deposit(id);
        deposit.setVisible(true);
        return false;
    }
    public boolean callWithdraw(String id){
        withdraw=new Withdraw(id);
        withdraw.setVisible(true);
        return false;
    }
    public boolean callTranfer(String id){
        tranfer=new Tranfer(id);
        tranfer.setVisible(true);
        return false;
    }
    public boolean callDepositCheck(String id,String money){
        String []Data=new String[5];
        checkData=new DepositCheckData();
        Data=checkData.CheckData(id);
        depositCheck=new DepositCheck(Data[1],Data[2],Data[3],money);
        depositCheck.setVisible(true);
        return false;
    }
    public boolean callWithdrawCheck(String id,String money){
        String []Data=new String[5];
        checkData=new DepositCheckData();
        Data=checkData.CheckData(id,money,1);
        WithdrawCheck check = new WithdrawCheck(Data[1],Data[2],Data[3],money,Data[4]);
        check.setVisible(true);
        return false;
    }
    public boolean callWithdrawUpdate(String id,String money){
        String []Data=new String[5];
        withdrawUpdate=new WithdrawUpdate();
        withdrawUpdate.withdrawUpdate(id,money);
        callFinancial(id);
        return false;
    }
    public boolean callWithdrawCheckinput(String id,String money){
        withdrawCheckinput=new WithdrawCheckinput();
        boolean stat=withdrawCheckinput.checkinput(id,money);
        return stat;
    }
    public boolean callTranferCheckID(String id){
        tranferModel=new TranferModel();
        boolean stat=tranferModel.checkID(id);
        return stat;
    }
    public boolean callDepositCheckinput(String id,String money){
        checkData=new DepositCheckData();
        boolean stat=checkData.checkinput(id,money);
        return stat;
    }
    public boolean callTranfercheck(String userid,String toid,String money){
        tranferCheck=new TranferCheck(userid,toid,money);
        tranferCheck.setVisible(true);
        return false;
    }
    public boolean callTranUpdate(String uid,String id,String money){
        withdrawUpdate=new WithdrawUpdate();
        withdrawUpdate.TranUpdate(uid,id,money);
        callFinancial(id);
        return false;
    }
}
