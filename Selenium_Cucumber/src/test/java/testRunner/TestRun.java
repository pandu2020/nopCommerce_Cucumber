package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		   features =".//Features/",					//  Customers.features Login.feature",   
           glue="stepDefinitions",
           dryRun=false,        // false  dryRun=true,  -- If we true it will check all steps are there or not - it won't run
           monochrome=true,
           plugin = { "pretty" ,   "html:test-output" },
           tags  = {"@sanity"}
		)
public class TestRun {

}


//  features ={".//Features/Login.feature",".//Features/Customers.feature"}, -- Two run Mutiple
//  features =".//Features/", - To Run All	