### TOKOIN TEST
Using the provided data (**tickets.json** and **users.json** and **organization.json**)

Write a simple command line application to search the data and return the results
in a human readable format.

* Feel free to use libraries or roll your own code as you see fit.
* Where the data exists, values from any related entities **MUST** be included in
  the results, i.e.
    * Searching **organization MUST** return its **ticket subject** and **users name**.
    * Searching **users MUST** return his/her **assignee ticket subject** and **submitted ticket subject** and his/her **organization name**.
    * Searching **tickets MUST** return its **assignee name**, **submitter name**, and **organization name**.
* The user should be able to search on any field, full value matching is fine
  (e.g. "mar" won't return "mary").
* The user should also be able to search for empty values, e.g. where
  description is empty.
* Search can get pretty complicated pretty easily, we just want to see that you
  can code a basic search application.
  
### Application Structure
The app is developed with:
- Java 8 : main coding language.
- Spring boot 2.4.4 : to build java web.
- jackson-databind : binding data from json file.
- lombok : generate class automatically.

The app is developed with serveral packages:

- **model**: define objects used in the app.

- **entity**: define data work with service layer.

- **repository**: parse json files into model objects.

- **service**: interact with repository layer to handle businesses.

- **resources/json**: json files.

- **Tokoin.java**: A main class.

- **test**: contains UT.

- **constant**: constant Variables

To build application via cmd: **mvn clean install**

To run application via cmd: **java -jar <file name>.jar**

or

Run on IDE: **run with spring boot application**

### Solution
Read json files, parse data to object then hold them to List (called repository in this app) and do search via *id* or *key/value*
