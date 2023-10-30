## Word Counter REST API

### Introduction

This is my hand-over for the Word Count Java test for the JTech Area within Ordina. 
The project is made using Intelij IDE. THe main project that is made to satisfy the requirements of the assignment is in the folder **"word-counter-rest"**. 
This folder contains the implementation part of the assignment. The word coutner funcationality together with the API interface made with Springboot.

### Usage

Open both projects:

- Word-counter-rest
- Word-counter-client

To start using the application, please run the main function of _WordCounterRestAppliation_ first. This starts the API interface and makes it available for the Client. This uses port 8080, please make sure this is available on your device.
After this is done, please run the main function of _WordCounterClientApplication_. This will prompt a simple console app to come up where you can add the parameters for each function before running it. The client application runs on port 8081.
If you run into the problem that these ports are not available, please use applicaiton.properties to set the app to an available port using: _'server.port=[**DESIRED_PORT**]'_

### Testing

The API interface is provided with a set of test cases. These testcases test both the funcationality of the API as the funcationality of the Word Counter. You will fin dthem in the 'test' folder provided in the project.

### Errors

I've tried to build in some error protections against wrong and empty parameters, as well as a wrong URL. These will throw an error code in the terminal.

### Choices

A few points of interest I wanted to address on this page were about the choices made during development of this application.

- Jakarta EE vs SpringBoot

The reason I've chosen SpringBoot over Jakarta was very simple. I've chosen Springboot because I've had the chance to make a very simple SpringBoot application before. The software was a little more clear to me, and I found the wiki a little easier to read. No technical difference has made me make this decision.

- StringTokenizer vs String.Split

While doing some research as I was working on this assignment, I found the StringTokenizer class which provides for an easier way to apply loops in the application. This might just be personal preference, but I found this easier than working with an Array that's returned from String.Split()

- StringJoiner vs StringBuilder

A string joiner made it easier to add a delimter character to the string. This was I could more easily add a space between the provided results from _calculateMostFrequentNWords()_ making it easier to format. 

