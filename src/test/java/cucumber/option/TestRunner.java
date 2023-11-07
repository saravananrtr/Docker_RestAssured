package cucumber.option;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/EndtoEndTesting.feature",
        glue= {"stepdefinations"},
        plugin = {"pretty","json:jsonReport.json","html:htmlReport.html","junit:xmlReport.xml",
                })
public class TestRunner {
}
