package day4.test;

import day4.entity.AutomatedTest;
import day4.entity.ManualTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Test;
import org.junit.Assert;

public class EntityAndWorkerTest {
    private static final String MSG_FOR_INSTABILITY = "Test instability is not correct!";
    private static final String MSG_FOR_TEST_EXECUTION = "Test execution for %s by %s with anxiety %s is not correct!";

    private day4.entity.Test test;
    private final Engineer testEngineer = new TestEngineer();
    private final Engineer automationEngineer = new AutomationEngineer();

    @Test
    public void verifyInstabilityAfterSettingLessThanOrEqualToZero() {
        test = new ManualTest(TestLevel.UNIT, 0);
        Assert.assertEquals(MSG_FOR_INSTABILITY, 1, test.getInstability());
    }

    @Test
    public void verifyInstabilityAfterSettingMoreThanTen() {
        test = new ManualTest(TestLevel.UNIT, 11);
        Assert.assertEquals(MSG_FOR_INSTABILITY, 10, test.getInstability());
    }

    @Test
    public void verifyInstabilityAfterSettingInTheRangeFromOneToTen() {
        test = new ManualTest(TestLevel.UNIT, 5);
        Assert.assertEquals(MSG_FOR_INSTABILITY, 5, test.getInstability());
    }

    @Test
    public void verifyDefaultAnxietyByTestEngineer() {
        Assert.assertEquals("Default engineer anxiety is not correct!", 3, testEngineer.getAnxiety());
    }

    @Test
    public void verifySetAnxietyByTestEngineer() {
        testEngineer.setAnxiety(2);
        Assert.assertEquals("Engineer anxiety was set not correct!", 2, testEngineer.getAnxiety());
    }

    @Test
    public void verifyRandomSkillByAutomationEngineer() {
        Assert.assertTrue("Random engineer skill is not correct!",
                1 <= automationEngineer.getSkill() && automationEngineer.getSkill() <= 10);
    }

    @Test
    public void verifySetSkillByAutomationEngineer() {
        automationEngineer.setSkill(2);
        Assert.assertEquals("Engineer skill was set not correct!", 2, automationEngineer.getSkill());
    }

    // executeTest by apply method: first if: true(&&) || false(&&) -> true; second if: true
    @Test
    public void manualTestByAutomationEngineerFailed() {
        test = new ManualTest(TestLevel.GUI, 4);
        automationEngineer.setSkill(2);
        Assert.assertEquals(String.format(MSG_FOR_TEST_EXECUTION,
                test.getClass().getSimpleName(), automationEngineer.getClass().getSimpleName(),
                automationEngineer.getAnxiety()), Result.FAILED, automationEngineer.executeTest(test));
    }

    // executeTest by apply method: first if: true(&&) || false(&&) -> true; second if: false
    @Test
    public void manualTestByAutomationEngineerPassed() {
        test = new ManualTest(TestLevel.UNIT, 8);
        automationEngineer.setSkill(4);
        Assert.assertEquals(String.format(MSG_FOR_TEST_EXECUTION,
                test.getClass().getSimpleName(), automationEngineer.getClass().getSimpleName(),
                automationEngineer.getAnxiety()), Result.PASSED, automationEngineer.executeTest(test));
    }

    // executeTest by apply method: first if: false(&&) || true(&&) -> true; second if: true
    @Test
    public void automatedTestByTestEngineerFailed() {
        test = new AutomatedTest(TestLevel.API, 10);
        testEngineer.setSkill(2);
        Assert.assertEquals(String.format(MSG_FOR_TEST_EXECUTION,
                test.getClass().getSimpleName(), testEngineer.getClass().getSimpleName(),
                testEngineer.getAnxiety()), Result.FAILED, testEngineer.executeTest(test));
    }

    // executeTest by apply method: first if: false(&&) || true(&&) -> true; second if: false
    @Test
    public void automatedTestByTestEngineerPassed() {
        test = new AutomatedTest(TestLevel.GUI, 2);
        testEngineer.setSkill(6);
        Assert.assertEquals(String.format(MSG_FOR_TEST_EXECUTION,
                test.getClass().getSimpleName(), testEngineer.getClass().getSimpleName(),
                testEngineer.getAnxiety()), Result.PASSED, testEngineer.executeTest(test));
    }

    // executeTest by apply method: first if: false(&&) || false(&&) -> false; second if: true
    @Test
    public void automatedTestByAutomationEngineerFailed() {
        test = new AutomatedTest(TestLevel.GUI, 8);
        automationEngineer.setSkill(2);
        Assert.assertEquals(String.format(MSG_FOR_TEST_EXECUTION,
                test.getClass().getSimpleName(), automationEngineer.getClass().getSimpleName(),
                automationEngineer.getAnxiety()), Result.FAILED, automationEngineer.executeTest(test));
    }

    // executeTest by apply method: first if: false(&&) || false(&&) -> false; second if: false
    @Test
    public void manualTestByTestEngineerPassed() {
        test = new ManualTest(TestLevel.API, 10);
        testEngineer.setSkill(5);
        Assert.assertEquals(String.format(MSG_FOR_TEST_EXECUTION,
                test.getClass().getSimpleName(), testEngineer.getClass().getSimpleName(),
                testEngineer.getAnxiety()), Result.PASSED, testEngineer.executeTest(test));
    }
}