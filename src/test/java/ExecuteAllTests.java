import junit.framework.*;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Alex on 4/23/2019.
 */
@RunWith(AllTests.class)
public class ExecuteAllTests extends TestBase {

    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
//        for(int i= 0; i<1; i++){
            suite.addTest(new JUnit4TestAdapter(RegistrationTest.class));
//        }
        return suite;
    }


}
