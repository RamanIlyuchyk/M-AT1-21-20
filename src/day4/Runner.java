package day4;

import day4.entity.AutomatedTest;
import day4.entity.ManualTest;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.TestEngineer;

public class Runner {
    public static void main(String[] args) {
        ManualTest manualTest = new ManualTest(TestLevel.API, 5);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        AutomatedTest automatedTest = new AutomatedTest(TestLevel.GUI, 2);
        TestEngineer testEngineer = new TestEngineer();
        System.out.println("Test " + manualTest.apply(automationEngineer));
        System.out.println("Test " + automatedTest.apply(testEngineer));
        System.out.println("Test " + manualTest.apply(testEngineer));
        System.out.println("Test " + automatedTest.apply(automationEngineer));
    }
}