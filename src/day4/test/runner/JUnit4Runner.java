package day4.test.runner;

import day4.test.tests.BaseEngineerTest;
import day4.test.tests.ExecuteTestTest;
import day4.test.tests.InstabilityTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BaseEngineerTest.class, ExecuteTestTest.class, InstabilityTest.class})
public class JUnit4Runner {
}