package pkg1nd;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConsoleGame extends Game{
    private JFrame frame;
    
    @Override
    public void launch() {
        Object[] options = {"Easy", "Medium", "Hard"};

        int difficulty = JOptionPane.showOptionDialog(frame, "Pasirinkite sudetinguma: ", "Slide Puzzle",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        switch (difficulty) {
            case 0:
                playGame(3);
                break;

            case 1:
                playGame(4);
                break;

            case 2:
                playGame(30);
                break;

            default:
                System.exit(0);
                break;
        }
    }
    
    public void playGame(int size){
        Window window = new Window(size);
        window.setVisible(true);
    }
}
