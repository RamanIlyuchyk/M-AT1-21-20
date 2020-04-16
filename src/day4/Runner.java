package day4;

import day4.entity.Test;
import day4.entity.AutomatedTest;
import day4.entity.ManualTest;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;

public class Runner {
    public static void main(String[] args) {
        Engineer testEngineer = new TestEngineer();
        Engineer automationEngineer = new AutomationEngineer();

        Test manualTest = new ManualTest(TestLevel.API, 3);
        Test automatedTest = new AutomatedTest(TestLevel.GUI, 5);

        testEngineer.executeTest(manualTest);
        testEngineer.executeTest(automatedTest);
        automationEngineer.executeTest(manualTest);
        automationEngineer.executeTest(automatedTest);
    }
}