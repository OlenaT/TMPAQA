package runner;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private static final String RUNNER_XML = "../DDT_TASK/DDT/suites/ExampleRunner.xml";

    public static void main (String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add(RUNNER_XML);
        testng.setTestSuites(suites);
        testng.run();
    }
}
