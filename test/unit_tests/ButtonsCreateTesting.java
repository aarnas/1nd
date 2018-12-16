package unit_tests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import pkg1nd.*;

public class ButtonsCreateTesting {
    @Test 
    public void test_ifThereEnoughtButtons(){
        Window window = new Window(4);
        int buttonsCount = window.getButtonsCount();
        int exactButtonsCount = 4*4;
        
        assertTrue(buttonsCount == exactButtonsCount);
    }
}
