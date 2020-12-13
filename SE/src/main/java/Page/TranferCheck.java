package Page;

import Call.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranferCheck extends Pageframe implements ActionListener {
    Control control=new Control();
    private String userid,desid,inmoney;
    JLabel idtxt =new JLabel("Id :");
    JLabel destination=new JLabel("To Id");
    JLabel moneytxt =new JLabel("Money :");
    Label idlabel=new Label();
    Label desidlabel=new Label();
    Label  inputmoneylabel=new Label();
    JButton confirm=new JButton("Confirm");
    JButton cancel=new JButton("Cancel");
    public TranferCheck(String id,String toid,String money){
        userid=id;desid=toid;inmoney=money;
        setFrame();
        idtxt.setBounds(660,300,30,20);
        destination.setBounds(660,330,30,20);
        moneytxt.setBounds(660,360,50,20);
        idlabel.setBounds(720,300,90,20);  idlabel.setText(userid);
        desidlabel.setBounds(720,330,90,20);  desidlabel.setText(desid);
        inputmoneylabel.setBounds(720,360,90,20);inputmoneylabel.setText(money);
        confirm.setBounds(660,400,80,30);
        cancel.setBounds(760,400,80,30);
        confirm.addActionListener(this);cancel.addActionListener(this);
        frame.add(idtxt);frame.add(destination);frame.add(moneytxt);
        frame.add(idlabel);frame.add(desidlabel);frame.add(inputmoneylabel);
        frame.add(confirm);frame.add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirm){
            boolean pagestat=control.callTranUpdate(userid,desid,inmoney);
            setVisible(pagestat);
        }
        if(e.getSource()==cancel){
            boolean pagestat=control.callFinancial(userid);
            setVisible(pagestat);
        }
    }
}
