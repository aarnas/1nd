package pkg1nd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SlideButton extends JButton implements ActionListener{
    String value;
    
    public SlideButton(String value){
        setText(value);
        this.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        Window.Check(this);
    }
}
