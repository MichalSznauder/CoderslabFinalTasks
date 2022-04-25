package ZadaniaZaliczeniowe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/Cucumber/Features/FinalTask1.feature",
        plugin = {
                "pretty",
                "html:out/FinalTask1report.html"
        }
)


public class FinalTask1Test {
}
