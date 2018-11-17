package pkg1nd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class Window extends JFrame{
    
    JPanel p = new JPanel();
    public static int click = 0;
    public static int size;
    public static SlideButton buttons[][] = null;
    
    public Window(int value){
        super("SlidePuzzle");
        setSize(800,800);
        //setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        size = value;
        buttons = new SlideButton[size][size];
        p.setLayout(new GridLayout(size,size));
        int txt = 0;
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
               txt++;
               if(txt == size*size){
                    buttons[i][j] = new SlideButton("");
                    buttons[i][j].setFont(new java.awt.Font("Tahoma", 1, 48));
                    p.add(buttons[i][j]); 
               }else{
                    buttons[i][j] = new SlideButton(txt+"");
                    buttons[i][j].setFont(new java.awt.Font("Tahoma", 1, 48));
                    p.add(buttons[i][j]); 
               }
            }
        }
        add(p);
        setVisible(true);
        //Randomize();
    }
    
    public static void Check(SlideButton button){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){  
                if(button == buttons[i][j]){
                    try{
                        if(buttons[i-1][j].getText() == ""){
                            buttons[i-1][j].setText(button.getText());
                            button.setText("");
                            click++;
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }
                    try{
                        if(buttons[i+1][j].getText() == ""){
                            buttons[i+1][j].setText(button.getText());
                            button.setText("");
                            click++;
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }    
                    try{
                        if(buttons[i][j-1].getText() == ""){
                            buttons[i][j-1].setText(button.getText());
                            button.setText("");
                            click++;
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }    
                    try{
                        if(buttons[i][j+1].getText() == ""){
                            buttons[i][j+1].setText(button.getText());
                            button.setText("");
                            click++;
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }
                }
            }
        }
    }
    
    public static void CheckIfWon(){
        int number = 1;
            for (int i=0;i<size;i++){
                for (int j=0;j<size;j++){
                    if(i==size-1 && j==size-1){
                        number++;
                    }
                    if(buttons[i][j].getText().equalsIgnoreCase(number+"")){
                        number++;
                    }
                    if(number-1 == size*size){
                        JOptionPane.showMessageDialog(null, "You win! "+click+" clicks.", "Well done!", JOptionPane.INFORMATION_MESSAGE);
                        Randomize();
                        click = 1;
                    }
                }
        }
    }
    
    public static void Randomize(){
        List<String> list = new ArrayList<>();
        int listid = 0;
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){  
                list.add(buttons[i][j].getText());
            }
        }
        Collections.shuffle(list);
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){ 
                buttons[i][j].setText(list.get(listid));
                listid++;
            }
        }
    }
}
