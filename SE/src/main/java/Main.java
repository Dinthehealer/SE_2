import Call.Control;
import Model.DatabaseConnection;
import Page.Financial;
import Page.Login;
import Page.Tranfer;

import java.awt.*;

public class Main {
    public static void main(String[]args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Control control=new Control(1);
                Tranfer tran=new Tranfer("1115228392");
            }
        });

    }
}
