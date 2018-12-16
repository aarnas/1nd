package pkg1nd;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class Window extends JFrame{

    JPanel p = new JPanel();
    public static int click, buttonsCount;
    public static int size;
    public static SlideButton buttons[][] = null;
    
    public Window(int value){
        super("SlidePuzzle");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setButtonsCount(0);
        setClick(0);
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
               }increaseButtonsCount();
            }
        }
        Randomize();
        add(p);
        setVisible(true); 
    }
    
    public static void setClick(int click) {
        Window.click = click;
    }
    
    public static void increaseClick(){
        click++;
    }
    
    public static int getClick() {
        return click;
    }
    
    public int getButtonsCount(){
        return buttonsCount;
    }
    
    public void increaseButtonsCount(){
        buttonsCount++;
    }
    
    public void setButtonsCount(int value){
        Window.buttonsCount = value;
    }
    
    public static void Check(SlideButton button){
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){  
                if(button == buttons[i][j]){
                    try{
                        if(buttons[i-1][j].getText() == ""){
                            buttons[i-1][j].setText(button.getText());
                            button.setText("");
                            increaseClick();
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }
                    try{
                        if(buttons[i+1][j].getText() == ""){
                            buttons[i+1][j].setText(button.getText());
                            button.setText("");
                            increaseClick();
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }    
                    try{
                        if(buttons[i][j-1].getText() == ""){
                            buttons[i][j-1].setText(button.getText());
                            button.setText("");
                            increaseClick();
                            CheckIfWon();
                        }
                    }catch (Exception e){
                    }    
                    try{
                        if(buttons[i][j+1].getText() == ""){
                            buttons[i][j+1].setText(button.getText());
                            button.setText("");
                            increaseClick();
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
                        setClick(1);
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
        
        while(isSolvable(list)==false){
           Collections.shuffle(list);
        }  
        
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){ 
                buttons[i][j].setText(list.get(listid));
                listid++;
            }
        }
        
        
    }
    
    public static boolean isSolvable(List<String> list) {
        int inversions = 0;

        Object[] array = list.toArray();
        for(int i = 0; i < size*size - 1; i++) {
            for(int j = i + 1; j < size*size; j++) {
                try{
                if (Integer.parseInt((String) array[i]) > Integer.parseInt((String) array[j])) inversions++;
                }catch(Exception e){
                }
            }
            try{
            if(Integer.parseInt((String) array[i]) == 0 && i % 2 == 1) inversions++;
            }catch(Exception e){
            }
        }
        return (inversions % 2 == 0);
    }
}
