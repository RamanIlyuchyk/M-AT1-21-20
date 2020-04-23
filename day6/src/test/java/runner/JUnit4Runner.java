package runner;

import tests.BaseEngineerTest;
import tests.ExecuteTestTest;
import tests.InstabilityTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BaseEngineerTest.class, ExecuteTestTest.class, InstabilityTest.class})
public class JUnit4Runner {
}