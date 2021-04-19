package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "Features",
        glue={"stepDefinitions"},
        dryRun = true,
        monochrome = true,
        //plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        //plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        plugin = {"pretty", "html:test-output",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags =  "@vitalpacs"
        //tags= {"@sanity","@regression"} This represents AND operation between both tags. All test cases having both tags at same time will be executed
        //tags= {"@sanity, @regression"} This represents OR operation between both tags. All test cases with either of tags will be executed

                )
public class TestRunner extends AbstractTestNGCucumberTests

{

    /* // For parallel execution of test cases
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
     */

}
