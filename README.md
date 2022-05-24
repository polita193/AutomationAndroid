# FixIT-Automation

Take into account to run this repository you will need to have installed the following tools:

* [Java 8 Open JDK]
* [Maven]
* [Appium]
* [IntelliJ IDEA] or any code editor you prefer

To run this repository locally you will need to install the following tools:
* [Android Studio] to run tests on Android local emulators or physical devices
* [Xcode] to run tests on IOS local emulators or physical devices
* [Appium] to connect with IOS local emulators or physical devices

## Installation

For [Java] and [Maven], the installation information is available on each official site. If you want to check if you
currently have them installed

For [Java]:

```sh
java -version
```

The [Java] response will be something like:

```sh
java version "1.8.0_221"
Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
```
For [Maven]
```sh
mvn -v
```

The [Maven] response will be something like:

```sh
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: /Applications/apache-maven-3.8.5
Java version: 11.0.14, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-11.0.14.jdk/Contents/Home
Default locale: en_CO, platform encoding: UTF-8
OS name: "mac os x", version: "12.3.1", arch: "x86_64", family: "mac"
 ```

For [Appium]:

```sh
appium -v
```

The response will be something like:

```sh
1.20.2
```

## Set up before running

- Update config.properties

For obtaining udid run:
```sh 
adb devices
 ```
- Update credentials
- Start appium server in terminal
```sh
  appium
 ```

## Notes: 
- Each test has a priority sett indicate the order to run.
- Log out test can be run apart before running the suite when the app keeps logged.


