[Simple Machines Forum Testing Framework][github]
=================================================
[![Version][version_badge]][version]

I made this framework for my college coursework. It helps developers test the [Simple Machines Forum](https://www.simplemachines.org/) forum. The tests were done with Selenium WebDriver. Using webdriver factory the developer can test forum on many internet browsers. If the test fails then framework will capture a screenshot and save it in `target/screens`.

Installation
-----
1. [Install Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. [Install IntelliJ](https://www.jetbrains.com/idea/download/)
3. Download web driver (use web driver for the web browser you **use**):

|Driver |URL |
|----------------|--------------------------------------------------------------|
|Chrome |https://chromedriver.chromium.org/downloads |
|Gecko (Firefox) |https://github.com/mozilla/geckodriver/releases |
|Opera |https://github.com/operasoftware/operachromiumdriver/releases |
4. Clone this project:
`git clone https://github.com/B-Matt/forum-testing.git`
5. Find some dummy SMF forum or host it yourself ([SMF download](https://download.simplemachines.org/)).
	
This framework allows the user [cross browser testing](https://www.softwaretestinghelp.com/how-is-cross-browser-testing-performed).  To change testing browser you need to edit `init()` function inside [TestBase.java](https://github.com/B-Matt/forum-testing/blob/master/src/test/java/tests/TestBase.java).

Page Object Model (POM)
-----
The framework was coded using the Page Object Model (POM) design pattern. Page Object Model is a design pattern that allows better performance and reduces duplicate code. One page object is a Java class that serves as an interface with a page in an application under test (AUT). Page class contains all web elements and methods for interacting with them.

![Photo was taken from Page Object Model (POM) | Design Pattern](https://miro.medium.com/max/2064/1*Uz0xBEbnd7IhEubY392Cow.png)

**The benefits of POM are:**
1. Readability - All tests and web elements are inside smaller classes which increase code readability.
2. Reusability - One page class can be used within one or more tests, which means that the developer does not have to write the same code multiple times.
3. Maintainability - Due to the modularity of the code, the developer can easily make a new update that will reflect on code that uses the updated class.

Available tests
-----
For testing this framework I have used [dummy forum](https://gas-locator.com/smf/index.php). If you want to change testing URL's, you need to edit page classes.


| Class Name | Description |
|-----------------|-------------------------------------------------------------------------------------------------------------------------------------|
|[RegistrationTest][registertest] | Allows testing the registration of new forum accounts by completing a simple registration form without a captcha test. |
|[LoginTest][logintest] | Allows testing the logging of users into an existing forum account by filling out the login form on the forum homepage. |
|[SendingMessageTest][messagesend] | Allows testing sending a private message to the other users in the forum. |
|[ReadingMessageTest][messageread] | Allows testing reading a private message by the default message title. |
|[PostingInTopicTest][posting] | Allows testing writing new posts in existing forum threads. |
|[CreatingTopicTest][postingtopic] | Allows testing posting new forum threads in existing forum boards. |

License
-------
Licensed under the MIT license. For more information see [LICENSE](LICENSE).

References
-----
[LV 2 - Automatsko testiranje Web aplikacija (Frontend) - Selenium
Web Driver (FERIT)](https://www.ferit.unios.hr/studiji/sveucilisni-diplomski-studij/DRac1-06-18/38#anc)

[Page Object Model (POM) | Design Pattern](https://medium.com/tech-tajawal/page-object-model-pom-design-pattern-f9588630800b)

[Page Object Model (POM)](https://www.geeksforgeeks.org/page-object-model-pom)

[github]: https://github.com/B-Matt/forum-testing
[version]: https://badge.fury.io/gh/B-Matt%2Fsmf-forum-testing
[version_badge]: https://badge.fury.io/gh/B-Matt%2Fsmf-forum-testing.svg
[registertest]: https://github.com/B-Matt/smf-forum-testing/blob/master/src/test/java/tests/RegistrationTest.java
[logintest]: https://github.com/B-Matt/smf-forum-testing/blob/master/src/test/java/tests/LoginTest.java
[posting]: https://github.com/B-Matt/smf-forum-testing/blob/master/src/test/java/tests/PostingInTopicTest.java
[postingtopic]: https://github.com/B-Matt/smf-forum-testing/blob/master/src/test/java/tests/CreatingTopicTest.java
[messagesend]: https://github.com/B-Matt/smf-forum-testing/blob/master/src/test/java/tests/SendingMessageTest.java
[messageread]: https://github.com/B-Matt/smf-forum-testing/blob/master/src/test/java/tests/ReadingMessageTest.java
