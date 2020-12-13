package Page;

import Call.Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends Pageframe implements ActionListener {
    Control control=new Control();
    private String userid;
    JLabel deposit =new JLabel("deposit :");
    JTextField input=new JTextField("");
    JButton confirm=new JButton("Confirm");
    JButton cancel=new JButton("Cancel");
    public Deposit(String id){
        userid=id;
        setFrame();
        deposit.setBounds(600,300,100,20);
        input.setBounds(720,300,100,20);
        confirm.setBounds(620,380,80,30);
        cancel.setBounds(710,380,80,30);
        confirm.addActionListener(this);cancel.addActionListener(this);
        frame.add(deposit);frame.add(input);frame.add(confirm);frame.add(cancel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirm&&input.getText()!=" "){
           String money=input.getText().trim();
            boolean check=control.callDepositCheckinput(userid,money);
            if(check){
                boolean pagestat=control.callDepositCheck(userid,money);
                setVisible(pagestat);
            }else{
                JOptionPane.showMessageDialog(null,"Please enter Money last 2 digit is 0 ");
                clearText();
            }

        }
        if(e.getSource()==confirm&&input.getText()==" "){
            JOptionPane.showMessageDialog(null,"Please enter Money ");
        }
        if(e.getSource()==cancel){
            boolean pagestat = control.callFinancial(userid);
            setVisible(pagestat);
        }
    }
    public void clearText(){
        input.setText(" ");
    }
}
