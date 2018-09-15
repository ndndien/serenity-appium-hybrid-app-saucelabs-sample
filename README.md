# serenity-appium-hybrid-app-saucelabs-sample
Sample for Serenity Appium run on Saucelabs

### Configs before run

Change configs at: src/test/java/com/appium/serenirybdd/configs/MyConfigs.java
    
    - Change SAUCELABS_USERNAME
    - Change SAUCELABS_ACCESS_KEY
    - Change SYSTEM_USER_NAME to login http://demo.guru99.com/V4/index.php
    - Change SYSTEM_USER_PASSWORD to login to http://demo.guru99.com/V4/index.php
    
### Run


    mvn verify -Dtest=VerifyNewCustomerCucumber
    
With VerifyNewCustomerCucumber is a test runner

### Author

 Dien Nguyen
 
 Email: ndndien@gmail.com
 
 Skype: fetel.denis
 
