package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/testResources/features",
        glue = "stepDefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@Vadim"
)
public class RunnerVdones {
}
