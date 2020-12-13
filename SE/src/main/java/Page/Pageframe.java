package Page;

import javax.swing.*;
import java.awt.*;

abstract class Pageframe {
        JFrame frame=new JFrame();
        public void setFrame(){
            frame.getContentPane().setLayout(null);
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
        }
        public void setVisible(boolean status){
            frame.setVisible(status);
        }
}
