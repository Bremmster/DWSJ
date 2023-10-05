# DSWJ
Designa Web Service Java

ReadMe fil med väsentlig information för
set-up och drift av er applikation och Kafka Kluster på en ny maskin och
localhost.

## Description

Provide a short description explaining the what, why, and how of your project. Use the following questions as a guide:

- What was your motivation?
  - Learn to use Springboot, How to set up and use Kafka message brokers, and write a multimodule project.
 
- Why did you build this project? (Note: the answer is not "Because it was a homework assignment.")
- What problem does it solve?
  - Sending messages in realtime avoiding star/spagetti integration patterns
- What did you learn?

## Table of Contents (Optional)

If your README is long, add a table of contents to make it easy for users to find what they need.

- [Installation](#installation)
- [Usage](#usage)
- [Credits](#credits)
- [License](#license)

## Installation


What are the steps required to install your project? Provide a step-by-step description of how to get the development environment running.
-download and run kafka, give examples.

-use the server.properties, set up the storage path


## Usage

Provide instructions and examples for use. Include screenshots as needed.

To add a screenshot, create an `assets/images` folder in your repository and upload your screenshot to it. Then, using the relative filepath, add it to your README using the following syntax:

    ```md
    ![alt text](assets/images/screenshot.png)
    ```
How to use:
Start Kafka Zookeper with default config
Start one or more kafka brokers on localhost ports 9092-9094, customized configs is located in kafkaConfigs
You will need to set the logging directory's in the kafka server.properties files
Start a mysql server on port localhost:3306 make a Schema "pokedb"
create "user" with "password" and give them privileges to the schema
for testing create schema "testdb" and a user "test" password "test" with privileges to schema

Run module "Pokemon producer" to get the web api running att localhost:8080
Run module "Pokemon-consume-SQL" to store all the Pokémons in the database
The "User-client" is a client application with a console menu. It will find random pokémons and the user can give the pokemon a name and send it to the webAPI




## Credits

List your collaborators, if any, with links to their GitHub profiles.
* [member 1](https://github.com/person1)
* [member 2](https://github.com/person1)

## Dependencies

If you used any third-party assets that require attribution, list the creators with links to their primary web presence in this section.
* [junit jupiter 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.7.0)


## License
Copyright (c) <2023> Kristian Karlson

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
---

![java](https://img.shields.io/badge/Java-100%25-blue)
