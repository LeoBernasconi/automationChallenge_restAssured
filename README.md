# Automation challenge 1: Rest Assured

Prepare automation project with Rest Assurance to validate the following use case. The QA Functional team want to know if the article service is working properly.
They add different articles with the following ids: 75885876, 76578325, 76250498 and 75918495.
You should show in a report who add the article that doesn’t has comments and mark as a bug

## Table of Contents

* [Introduction](#introduction)
* [Installation](#installation)
* [Usage](#usage)


## Introduction
The project is dividied into 2 layers:
1. Endpoints: Contain a class Endpoints with the 3 endpoints to be used during the testing.
2. Tests: Contain a testNG test to iterate through a list of articles id
**Initially, the approach was to create four different testNG test (one for each article id provided) and call the method testMain sending each article id. However, the approach of having one single test iterating based on the number of items in an array of articles id make the test more flexible, since n number of articles ids may be added and to further modification should be done on the code. Just by adding articles id, the code will be executed.**
   

## Installation

1. Verify that Java is installed in your computer, by opening the console/terminal and type "java --version".
2. If not, install Java: https://www.java.com/en/download/help/download_options.html.
3. Download or clone the repository.

## Usage

How to execute the tests?
* FromIDE (Example with Eclipse)
  - Open Eclipse (or the IDE of your preference).
  - Right click on src.test/testAPI.java
  - Click on "Run as"/ TestNG test.
  - The results will be shown in the console of the IDE showing: status of the test + user name (and article id) of those articles with no comments.
