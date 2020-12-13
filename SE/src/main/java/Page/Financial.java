package Page;

import Call.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Financial extends Pageframe implements ActionListener {
    Control control=new Control();
    JButton checkbalance=new JButton("checkbalance");
    JButton deposit=new JButton("Deposit");
    JButton withdraw=new JButton("withdraw");
    JButton tranfer=new JButton("tranfer");
    JButton cancel=new JButton("Cancel");
    private  String userid;
    public Financial(String id){
        userid=id;
        setFrame();
        checkbalance.setBounds(650,210,150,40);
        deposit.setBounds(650,270,150,40);
        withdraw.setBounds(650,330,150,40);
        tranfer.setBounds(650,390,150,40);
        cancel.setBounds(650,450,150,40);
        checkbalance.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        tranfer.addActionListener(this);
        cancel.addActionListener(this);
        frame.add(deposit);frame.add(withdraw);frame.add(tranfer);frame.add(checkbalance);frame.add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==checkbalance) {
            boolean pagestat=control.callcheckbalance(userid);
            setVisible(pagestat);
        }
        if (e.getSource()==deposit) {
            boolean pagestat=control.callDeposit(userid);
            setVisible(pagestat);
        }
        if (e.getSource()==withdraw) {
            boolean pagestat=control.callWithdraw(userid);
            setVisible(pagestat);
        }
        if (e.getSource()==tranfer) {
            boolean pagestat=control.callTranfer(userid);
            setVisible(pagestat);
        }
        if (e.getSource()==cancel) {
            boolean pagestat=control.callLogin(1);
            setVisible(pagestat);
        }
    }
}
