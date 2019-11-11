# triangle-testing

How to Run:
  Requirements: Java 1.8 SDK; IntelliJ as the preferable IDE
Option 1) Download the whole project folder labeled "triangle2" and place it into your IdeaProjects folder.
Option 2) Create your own project and open the "JustTheJavaCodeFiles" folder, copy and past the files for "pom.xml", "Triangle.java", and "TriangleTest.java" into your project.


Goal:
This project is aimed to better understand the topic of code coverage by making a project using Apache Maven and its plugin JaCoCo to create a code coverage report in Java.

How To Create a Maven Build:
1) You must create new environment variables and edit the path.
  a) JDK download: https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html
  b) Apache Maven download: https://maven.apache.org/download.cgi
  c) After downloading both of these, you will want to unzip them, place them in a directory (C:/ will be the easiest), go to System Properties > Advanced Tab > Environment Variables in the Control Panel, add a "New..." under User Variables for JAVA_HOME (with the JDK path), MAVEN_HOME (with the Maven path), and M2_HOME(with the Maven path), and edit both "Path" under User variables and System variables to include the Maven path with the \bin added.
2) Create a new project and click on the tab "Maven" to instantiate a Maven project. This will create the necessary folders and generate a pom.xml file to help get started.
3) In the Project_Name > src > main, create a java file and code as normal. Ideally, classes with functions will be used for testing purposes.
4) Afterwards, you want to edit the pom.xml file. (Note: depending on your JDK, SDK, and Maven versions, plugin and dependency version will slightly differ).
  a) Dependencies:
    i) junit: used for JUnit testing that you will see when we integrate the testing java file
  b) Plugins:
    i) maven-compiler-plugin: used to help compile using maven
    ii) maven-surefire-plugin: allows you to use JaCoCo to generate results
    iii) jacoco-maven-plugin: used to generate code coverage reports (Note: you must include an execution with the phase "test" in order to run mvn test in the command prompt.
5) Under Project_Name > src > test > java, create a file \*Test.java and create a public class with that same name. You will want to import "org.junit.Test" and "static junit.framework.TestCase.assertEquals".
  a) Here, you will hardcode expected values of variables you want to test in your main java file you will be running to compare it to. 
  b) Afterwards, you will create a void function with the "@Test" above it (without quotes). These will be your tests that Maven will run your program against. These functions and tests should be used to test the main java file's classes, class functions, branches, etc., so be as thorough in terms of creating variables, calling functions, etc. When you are done, you will use the function "assertEquals(var1, var2)" where var1 is the hard-coded value of the variables and var2 is the actual use of datatypes, variables, objects, object return types, etc. You can call this function multiple times. 
6) When all the coding is done, you will use the command prompt, go to the project's main folder, and type the commands: "mvn compile" and then "mvn test". Depending on if you decide to add a path for your reports, it will be under Project_Name > target > site.
