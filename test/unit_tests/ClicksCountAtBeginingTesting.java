package unit_tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pkg1nd.Window;

public class ClicksCountAtBeginingTesting {
    @Test
    public void test_ifClicksIsZeroAnBegining(){
        Window window = new Window(4);
        int clicks = window.getClick();
        
        assertTrue(clicks == 0);
    }
}
