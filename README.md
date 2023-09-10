How To Run The Test Suites:
-->To run the test suite open terminal and goto project location and type
mvn test.
It will execute all the test cases mentioned in the suite file present in resource/TestNGxml.
We can run individual tests or class files using IntelliJ or eclipse as well.
failure happened, we can check the screenshot of failures in Reports Folder in the project with the Name of TestCase, also look for the stack trace in the report and verify the line where it failed.
Verify manually the flow and also give another run for that particular test to see if it is due to script issue.\
Also we are capturing device logical log for verifying the logs which will be present in appLog folder in the project location.\
Where to see reports:
We can get the report in the project folder
ExtentTestReport.html 