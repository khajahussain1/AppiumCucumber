package com.Appium;

public class Cucumber_Concepts 
{
	/*
	 * 
	 * There is an abstract AppiumDriver class which inherits from the Selenium Java Client. The AppiumDriver class contains 
	 * all methods shared by iOS and Android. IOSDriver and AndroidDriver both extend AppiumDriver and provide more methods, 
	 * and specific implementations for some methods.
	 * 
	1-Plugin: plugin Option is used to specify different formatting options for the output reports. Various options that can be 
	  used as for-matters are:
		Note – Format option is deprecated . Use Plugin in place of that.

	2- Pretty: Prints the Gherkin source with additional colors and stack traces for errors.
	  Ex:- @CucumberOptions(plugin = {"pretty"}, strict = false)
	  
	3- HTML: This will generate a HTML report at the location mentioned in the for-matter itself.
	   Ex:- @CucumberOptions(plugin ={"pretty" , "html:Folder_Name"})
	   
	4-JSON: This report contains all the information from the gherkin source in JSON Format. This report is meant to be 
	    post-processed into another visual format by 3rd party tools such as Cucumber Jenkins. 
	    Ex:- @CucumberOptions(plugin = {"pretty", "json:Folder_Name/cucumber.json"})   
	    
	5-JUnit: This report generates XML files just like Apache Ant’s JUnit report task. This XML format is understood by most 
	       Continuous Integration servers, who will use it to generate visual reports.
	       Ex:- @CucumberOptions(plugin = {"pretty","junit:Folder_Name/cucumber.xml"})
	       
	6-DryRun: This option can either set as true or false (default value is false). If it is set as true, it means that 
	  Cucumber will only checks that every Step mentioned in the Feature File have corresponding code written in Step Definition
	   file or not. So in case any of the function is missed in the Step Definition for any Step in Feature File, it will give us 
	   the message. So If you writing scenarios first and then implementing step definitions then add dryRun = true.
	 Ex:- @CucumberOptions(plugin = {"pretty"}, dryRun = true)
	 
   7-Strict=false: if strict option is set to false then at execution time if cucumber encounters any undefined/pending steps then 
     cucumber does not fail the execution and undefined steps are skipped and BUILD is SUCCESSFUL.
     Ex:- @CucumberOptions(plugin = {"pretty"}, strict = false)
     
  8-Strict=true: if Strict option is set to true then at execution time if cucumber encounters any undefined/pending steps then 
    cucumber does fails the execution and undefined steps are marked as fail and BUILD is FAILURE. This is what the Console output
    looks like:
   Ex:- @CucumberOptions(plugin = {"pretty"}, strict = true)
   
 9-Monochrome: This option can either set as true or false (default value is false). If it is set as true, it means that the 
   console output for the Cucumber test are much more readable. And if it is set as false, then the console output is not as 
   readable as it should be. For practice just add the code ‘monochrome = true‘ in TestRunner class.
   Ex:- @CucumberOptions(plugin = {"pretty"}, strict = true, monochrome = true)
   
 10-Features: Features Options helps Cucumber to locate the Feature file in the project folder structure.All we need to do is to 
    specify the folder path and Cucumber will automatically find all the ‘.features‘ extension files in the folder.It can be 
   defined like:
   Ex:- @CucumberOptions(features = “Feature“) Or if the feature file is in the deep folder structure- 
      @CucumberOptions(features = “src/test/features“)
      
 11-Glue: It is almost the same think as Features Option but the only difference is that it helps Cucumber to locate the Step 
    Definition file. Whenever Cucumber encounters a Step, it looks for a Step Definition inside all the files present in the folder
    mentioned in Glue Option.It can be defined like-
    Ex:- @CucumberOptions(features = “Feature“ glue = “stepDefinition“) Or if the Step Definition file is in the deep folder
        structure-@CucumberOptions(features = “src/test/features“ glue = “src/test/stepDeinition“)  
        
  12-Snippet Style: Cucumber generates code snippets in Underscore style by default. If you want to change the format of cucumber
     snippets then you can set snippet type in your cucumber options. There are two types of snippets,

   1- SnippetType.CAMELCASE
   2- SnippetType.UNDERSCORE   
   Ex:- @CucumberOptions(plugin = {"pretty"}, monochrome = true Snippets = SnippetType.CAMELCASE)
     
 13-Running cucumber tests based on Tags
    The tags can be used when specifying what tests to run through any of the running mechanism. So, tags is just another 
    parameter in the cucumber options annotation. We can also pass multiple tags as values separated by commas if we need so.

    Tag expressions-

    Running Scenarios with a Tag

    Cucumber run scenarios with a particular tag. 
    Ex:- @CucumberOptions(features = “src/test/features“, tags ={“@Webdriver“},...  )
    
 14-Running Scenarios without Tag
   Cucumber can exclude scenarios with a particular tag by inserting the tilde character before the tag.
   For the following command will run all Scenarios without the SoapUI tag.
   Ex:- @CucumberOptions(features = “src/test/features“, tags ={“~@SoapUI“},...  ) 
   
 15-Logical OR
    Separate a list of tags by commas for a Logical OR tag expression.
    Ex:-@CucumberOptions(features = “src/test/features“, tags ={“@SoapUI,@Functional"},...  ) 
    
 16-Logical AND
    Specifying multiple tag arguments creates a logical AND between each tag expression.
    Ex:- @CucumberOptions(features = “src/test/features“, tags ={“@SoapUI","@Functional"},...  )
    
 17-AND OR NOT
    Specifying multiple tag arguments creates a logical AND between each tag expression.
    Ex:-@CucumberOptions(features = “src/test/features“, tags ={“@SoapUI,@Functional","~@Regression"},...  )
                
                
   
   


*/
}
