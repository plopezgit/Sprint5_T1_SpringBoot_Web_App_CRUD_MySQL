# Sprint5_T1_Spring Boot_Web_App_CRUD_MySQL

We have an entity called Branch, which has the following properties:

- Integer pk_BranchID
- String nameBranch
- String countryBranch

We also have a DTO called BranchDTO, which will have the same properties as the Branch entity, adding one:

- String typeBranch.

This property, depending on the country of the branch, must indicate whether it is "EU" or "Non-EU". To do this, you can have a private list in the same DTO (for example: List<String> countries), with the countries that are part of the EU.

Leveraging the JPA specification, you will need to persist the Branch entity to a MySql database, following the MVC pattern.

The advice is that you use BranchDTO in the Controller and the View, and Branch in the Repository. The service layer will be in charge of translating between the two.
For this, depending on the main package, you will create a package structure, where you will place the classes you need:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers
- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n01.model.domain
- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n01.model.dto
- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n01.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository

The class located in the controllers package (SucursalController, for example), must be able to respond to the following requests to update and consult information:

http://localhost:9000/branch/add
http://localhost:9000/branch/update
http://localhost:9000/sucursal/delete/{id}
http://localhost:9000/sucursal/getOne/{id}
http://localhost:9000/branch/getAll

As you can see, in the application.properties file, you must configure that the port to be used is 9000.

The view must be developed with Thymeleaf.

In order to make it more attractive, you can optionally use a CSS library that makes it easier for you, such as bootstrap, tailwind, material, etc.

Very important:

In addition to the Git link for the solved assignment, you must include at least two links, other than the resources we have provided you with on campus, that have helped you, or could have helped you, in solving the entire assignment or some parts.