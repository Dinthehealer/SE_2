package Page;
import Call.Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends Pageframe implements ActionListener {
    Control control=new Control();
    JLabel Id=new JLabel("Username :");
    JLabel pass=new JLabel("Password :");
    JTextField idfield=new JTextField();
    JTextField passfield=new JTextField();
    JButton nextbutton=new JButton("Next");
    public Login(){
        setFrame();
        Id.setBounds(600,300,100,20);
        idfield.setBounds(720,300,100,20);
        pass.setBounds(600,340,100,20);
        passfield.setBounds(720,340,100,20);
        nextbutton.setBounds(670,380,80,30);
        nextbutton.addActionListener(this);
        frame.add(Id);frame.add(pass);frame.add(idfield);
        frame.add(passfield);frame.add(nextbutton);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==nextbutton){
            boolean stat;
            String userid= idfield.getText().trim();
            String userpass= passfield.getText().trim();
            stat=control.callLoginCheck(userid,userpass);
            if(stat==false){
                JOptionPane.showMessageDialog(null,"WorngID or Password");
                clearText();
            }else{
                clearText();
                boolean pagestat=control.callFinancial(userid);
                setVisible(pagestat);
            }
        }

    }
    public void clearText(){
        idfield.setText(" ");
        passfield.setText(" ");
    }
}
