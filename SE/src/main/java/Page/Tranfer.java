package Page;

import Call.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tranfer extends Pageframe implements ActionListener {
        Control control=new Control();
        private String userid,inmoney;
        JLabel idtxt =new JLabel("Id :");
        JLabel toid=new JLabel("To Id");
        JLabel moneytxt =new JLabel("Money :");
        JTextField inputid=new JTextField("");
        JTextField inputmoney=new JTextField("");
        Label idlabel=new Label();
        Label  inputmoneylabel=new Label();
        JButton confirmtxt=new JButton("Confirm");
        JButton cancel=new JButton("Cancel");

        public Tranfer(String id1){
            userid=id1;
            setFrame();setVisible(true);
            idtxt.setBounds(660,300,30,20);
            toid.setBounds(660,330,30,20);
            inputid.setBounds(720,330,100,20);
            moneytxt.setBounds(660,360,100,20);
            inputmoney.setBounds(720,360,100,20);
            confirmtxt.setBounds(660,400,80,30);
            cancel.setBounds(760,400,80,30);
            idlabel.setBounds(720,300,90,20);  idlabel.setText(id1);
            cancel.addActionListener(this);confirmtxt.addActionListener(this);
            frame.add(idtxt);frame.add(toid);frame.add(inputid); frame.add(moneytxt);frame.add(inputmoney);frame.add(confirmtxt);
            frame.add(confirmtxt);frame.add(cancel);
            frame.add(idlabel);frame.add(inputmoneylabel);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==cancel){
                boolean pagestat=control.callFinancial(userid);
                setVisible(pagestat);
            }
            if(e.getSource()==confirmtxt){
                String trantoid=inputid.getText().trim();
                String money=inputmoney.getText().trim();
                boolean checkid=control.callTranferCheckID(trantoid);
                boolean checkmoney=control.callWithdrawCheckinput(userid,money);
                if(checkid){
                    if(checkmoney){
                        boolean pagestat = control.callTranfercheck(userid,trantoid,money);
                        setVisible(pagestat);
                    }else{
                        JOptionPane.showMessageDialog(null,"Please enter Money last 2 digit is 0 or " +
                                "money is not enough  to withdraw.");
                        clearText();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Destination Id not found.");
                    clearText();
                }
            }
        }
    public void clearText(){
        inputid.setText(" ");
        inputmoney.setText(" ");
    }

}
