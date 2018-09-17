package pl.soflab.AutomationTestExercise;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		//format= {"pretty","json:target/"},
		features = {"src/test/resource/features/"}
		,glue={"stepDefinition"}
		)

public class RunnerTest {	
	
}
