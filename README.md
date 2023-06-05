Selenium Chrome Browser Automation
This is a Java program that demonstrates how to automate the Chrome browser using Selenium WebDriver. It opens the Chrome browser, performs some actions on a web form, and then closes the browser.

Prerequisites
Java Development Kit (JDK) installed on your machine
Chrome browser installed
ChromeDriver executable downloaded and placed in a known location
Setup
Clone the repository or download the source code files.

Open the project in your preferred Java IDE.

Set the path to the ChromeDriver executable:

In the HalTest.java file, locate the line: System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");.
Replace "path/to/chromedriver" with the actual path to the ChromeDriver executable on your machine.
Make sure you have the Selenium WebDriver dependency added to your project:

If you are using Maven, ensure that the following dependency is present in your pom.xml file:
xml
Copy code
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.141.59</version>
</dependency>
If you are not using Maven, make sure you have manually added the Selenium Java bindings JAR files to your project.
Execution
Run the HalTest.java file.

The program will open the Chrome browser, navigate to the provided URL, maximize the window, and wait for elements to be visible.

It will then simulate user interactions by selecting options, filling in form fields, and clicking buttons.

Finally, it will print the pending items and close the browser.

Customization
You can modify the code to suit your requirements. Here are some areas you might want to customize:

URL: In the HalTest.java file, locate the line driver.get("https://forms.gle/eiiqRfHiRAiCXgPX7"); and replace the URL with the desired web page URL.

XPath locators: If you need to interact with different elements on the web page, you can modify the XPath locators in the code. Update the respective variable values to match the XPath of the desired elements.

Note
Ensure that the ChromeDriver version you downloaded is compatible with your Chrome browser version. If you encounter any issues, make sure to download the appropriate version of ChromeDriver.
That's it! You should now be able to run the program and observe the automation of the Chrome browser.
