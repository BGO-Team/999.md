import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/testResources/features",
        glue = "stepDefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@Vadim",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Runner {
}