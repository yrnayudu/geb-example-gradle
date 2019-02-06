/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.BrowserType
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
	timeout = 2
}


environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		//driver = { new ChromeDriver() }
        println("instantiating remote driver ")
        def capabilities = new DesiredCapabilities()
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME)
        //capabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX)

        def remoteWebDriverUrl = new URL("http://browser:4444/wd/hub")
        driver = { new RemoteWebDriver(remoteWebDriverUrl, capabilities) }
	}

/*	// run via “./gradlew chromeHeadlessTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chromeHeadless {
		driver = {
			ChromeOptions o = new ChromeOptions()
			o.addArguments('headless')
			new ChromeDriver(o)
		}
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		atCheckWaiting = 1

		driver = { new FirefoxDriver() }
	}*/

}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = "http://gebish.org"
