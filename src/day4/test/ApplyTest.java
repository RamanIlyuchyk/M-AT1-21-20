package day4.test;

import day4.entity.AutomatedTest;
import day4.entity.ManualTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.TestEngineer;
import org.junit.Test;
import org.junit.Assert;

public class ApplyTest {
    @Test
    public void manualTestFailed() {
        ManualTest manualTest = new ManualTest(TestLevel.API, 5);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        Assert.assertEquals("Manual test by automation engineer with API(3), instability 5, anxiety 3:", Result.FAILED, manualTest.apply(automationEngineer));
    }

    @Test
    public void manualTestPassed() {
        ManualTest manualTest = new ManualTest(TestLevel.UNIT, 2);
        TestEngineer testEngineer = new TestEngineer();
        Assert.assertEquals("Manual test by test engineer with UNIT(1), instability 2, anxiety 1:", Result.PASSED, manualTest.apply(testEngineer));
    }

    @Test
    public void automatedTestFailed() {
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.GUI, 4);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        Assert.assertEquals("Automated test by automation engineer with GUI(9), instability 4, anxiety 1:", Result.FAILED, automatedTest.apply(automationEngineer));
    }

    @Test
    public void automatedTestPassed() {
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.API, 3);
        TestEngineer testEngineer = new TestEngineer();
        Assert.assertEquals("Automated test by test engineer with API(3), instability 3, anxiety 3:", Result.PASSED, automatedTest.apply(testEngineer));
    }
}