# Project name

## Description

Provide a short description explaining the what, why, and how of your project. Use the following questions as a guide:

- What was your motivation?
- Why did you build this project? (Note: the answer is not "Because it was a homework assignment.")
- What problem does it solve?
- What did you learn?

## Table of Contents (Optional)

If your README is long, add a table of contents to make it easy for users to find what they need.

- [Installation](#installation)
- [Usage](#usage)
- [Credits](#credits)
- [License](#license)

## Installation

What are the steps required to install your project? Provide a step-by-step description of how to get the development environment running.

## Usage

Provide instructions and examples for use. Include screenshots as needed.

To add a screenshot, create an `assets/images` folder in your repository and upload your screenshot to it. Then, using the relative filepath, add it to your README using the following syntax:

    ```md
    ![alt text](assets/images/screenshot.png)
    ```
How to use:
Start Kafka Zookeper with default config
Start one or more kafka brokers on localhost ports 9093-9095, customized configs is located in kafkaConfigs
Start a mysql server on port localhost:3306 make a Schema "pokedb"
create "user" with "password" and give them privileges to the schema
for testing create schema "testdb" and a user "test" password "test" with privileges to schema

                Run module "Pokemon producer" to get the web api running att localhost:8080
                Run module "Pokemon-consume-SQL" to store all the Pokémons in the database
                The "User-client" is a client application with a console menu.
                It will find random pokémons and the user can give the pokemon a name and send it to the webAPI




## Credits

List your collaborators, if any, with links to their GitHub profiles.
* [member 1](https://github.com/person1)
* [member 2](https://github.com/person1)

## Dependencies
If you used any third-party assets that require attribution, list the creators with links to their primary web presence in this section.
* [junit jupiter 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.7.0)

If you followed tutorials, include links to those here as well.

## License

The last section of a high-quality README file is the license. This lets other developers know what they can and cannot do with your project. If you need help choosing a license, refer to [MIT License](https://choosealicense.com/licenses/mit/).

---

🏆 The previous sections are the bare minimum, and your project will ultimately determine the content of this document. You might also want to consider adding the following sections.

## Badges

![badmath](https://img.shields.io/github/languages/top/lernantino/badmath)

Badges aren't necessary, per se, but they demonstrate street cred. Badges let other developers know that you know what you're doing. Check out the badges hosted by [shields.io](https://shields.io/). You may not understand what they all represent now, but you will in time.

## Features

If your project has a lot of features, list them here.

## How to Contribute

If you created an application or package and would like other developers to contribute it, you can include guidelines for how to do so. The [Contributor Covenant](https://www.contributor-covenant.org/) is an industry standard, but you can always write your own if you'd prefer.

## Tests

Go the extra mile and write tests for your application. Then provide examples on how to run them here.
