## Introduction
This project is aimed at covering the basic steps to automate both UI & REST API in one framework.
It is aimed at providing skeleton for automation and is demonstrated with only chrome.
If any alternative version of chromedriver is needed - it can be updated in driver/ folder.

You must check manually whether new driver was released.
You must download different version of the driver when you upgrade your browser
Your code will not be able to run against various browsers without refactoring


## Run tests locally
This project is tested on - maven version -  3.6.3 and java version - 15.0.1   
Have MAVEN_HOME environment variable configured to point to maven home path
Have JAVA_HOME environment variable configured to point to jdk home path

Checkout and move to checked out folder and execute -> "mvn clean test"

## Run test in a CI/CD pipeline
Ensure to have JAVA_HOME  pointed to home path of JDK in Global tool configuration in jenkins

Ensure to have MAVEN_HOME  pointed to home path of mvn in Global tool configuration in jenkins

Add credentials provided separately to the Jenkins Global credentials as Secret Text 

Api key of Calliope as CALLIOPE_API_KEY

Profile id of Calliope as CALLIOPE_PROFILE_ID


Create a pipeline using "Pipeline script from SCM" and provide github repository path and necessary credentials 
Point to correct branch of the repository

Under "Script Path" - mention - Jenkinsfile

Trigger "Build now" after this configuration


## Link to the results in Calliope.pro
Although the results are automatically uploaded to Calliope.pro from the pipeline, they are not automatically shared as this feature is not available.

Example result - https://app.calliope.pro/reports/147670/public/ee622c55-8370-48c4-a063-96089b06943f

## Calliope.pro improvement
The information seems to be cluttered in one place and there is a lot of information in one place.
There should be more visual presentation for stakeholders 
Also the report which can be shared with others needs to be done one at a time and some stakeholders would need to have access to all reports 

## Scenarios selection 
Scenarios is selected to showcase capability of different areas of automation . For example - POST,DELETE for REST api automation.
Features of UI like visibility, timeout, change in UI based on action by user is showcased.

## Why this scenarios ?
API scenarios were selected to show Areas of various http protocols like GET,POST,DELETE.

UI scenarios were selected to demonstrate - driver wait, visibility of elements & basic login. There were other scenarios which can be built on top of this.


## Next steps 
Reports can be improved to include screenshot of UI pages. 
More libraries can be introduced and put in common to help with API automation like - having common methods to create request body
Support for other browsers needs to be introduced.
API automation tests can be more parameterized.
