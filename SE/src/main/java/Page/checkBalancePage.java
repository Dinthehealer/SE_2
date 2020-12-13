package Page;

import Call.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkBalancePage extends Pageframe implements ActionListener {
    Control control=new Control();
    private  String id1,name1,lastname1,inputmoney;
    JLabel idtxt=new JLabel("Id  :");
    JLabel nametxt=new JLabel("Name  :");
    JLabel lastnametxt=new JLabel("Lastname  :");
    JLabel balancetxt=new JLabel("Balance  :");
    Label idlabel=new Label();
    Label  namelabel=new Label();
    Label  lastnamelabel=new Label();
    Label  balancelabel=new Label();
    JButton confirm=new JButton("Confirm");
    public checkBalancePage(String id,String name,String lastname,String money){
        id1=id;name1=name;lastname1=lastname;
        setFrame();
        inputmoney=money;
        idtxt.setBounds(600,300,90,20);
        nametxt.setBounds(600,330,90,20);
        lastnametxt.setBounds(600,360,90,20);
        balancetxt.setBounds(600,390,90,20);
        idlabel.setBounds(700,300,90,20);  idlabel.setText(id1);
        namelabel.setBounds(700,330,90,20);  namelabel.setText(name1);
        lastnamelabel.setBounds(700,360,90,20);  lastnamelabel.setText(lastname1);
        balancelabel.setBounds(700,390,90,20);  balancelabel.setText(inputmoney);
        confirm.setBounds(630,420,90,40);
        confirm.addActionListener(this);
        frame.add(idtxt);frame.add(nametxt);frame.add(lastnametxt);frame.add(balancetxt);
        frame.add(idlabel);frame.add(namelabel);frame.add(lastnamelabel);frame.add(balancelabel);
        frame.add(confirm);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirm){
            boolean pagestat=control.callFinancial(id1);
            setVisible(pagestat);
        }
    }
}
