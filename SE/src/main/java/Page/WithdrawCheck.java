package Page;

import Call.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawCheck extends Pageframe implements ActionListener {
    Control control=new Control();
    private  String id1,name1,lastname1,inputmoney,balance;
    JLabel idtxt=new JLabel("Id  :");
    JLabel nametxt=new JLabel("Name  :");
    JLabel lastnametxt=new JLabel("Lastname  :");
    JLabel moneytxt=new JLabel("WithdrawMoney  :");
    JLabel balancetxt =new JLabel("Balance :");
    Label  idlabel=new Label();
    Label  namelabel=new Label();
    Label  lastnamelabel=new Label();
    Label  inputmoneylabel=new Label();
    Label  inputbalancelabel=new Label();
    JButton confirm=new JButton("Confirm");
    JButton cancel=new JButton("Cancel");

    public WithdrawCheck(String id,String name,String lastname,String withdraw,String balance){
        id1=id;name1=name;lastname1=lastname; this.balance=balance;
        setFrame();
        inputmoney=withdraw;
        idtxt.setBounds(660,300,110,20);
        nametxt.setBounds(660,330,110,20);
        lastnametxt.setBounds(660,360,110,20);
        moneytxt.setBounds(660,390,110,20);
        balancetxt.setBounds(660,420,110,20);
        confirm.setBounds(660,500,80,30);
        confirm.addActionListener(this);
        cancel.setBounds(760,500,80,30);
        cancel.addActionListener(this);
        idlabel.setBounds(790,300,90,20);  idlabel.setText(id1);
        namelabel.setBounds(790,330,90,20);  namelabel.setText(name1);
        lastnamelabel.setBounds(790,360,70,20);  lastnamelabel.setText(lastname1);
        inputmoneylabel.setBounds(790,390,70,20);  inputmoneylabel.setText(inputmoney);
        inputbalancelabel.setBounds(790,420,70,20);  inputbalancelabel.setText(balance);
        frame.add(idtxt);frame.add(nametxt);frame.add(lastnametxt);frame.add(moneytxt);frame.add(balancetxt);
        frame.add(confirm);frame.add(cancel);
        frame.add(idlabel);frame.add(namelabel);frame.add(lastnamelabel);frame.add(inputmoneylabel);
        frame.add(inputbalancelabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel) {
            boolean pagestat=control.callFinancial(id1);
            setVisible(pagestat);
        }
        if (e.getSource()==confirm) {
            boolean pagestat=control.callWithdrawUpdate(id1,inputmoney);
            setVisible(pagestat);
        }
    }
}
