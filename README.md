Backend for the WebKitchen webpage.

The frontend of the application you can find [here](https://github.com/GaborPap/webkitchen-client/)

<hr>

**Information about backen of the application:**

This poject is created with Spring boot framework usin Microservices Architecture. 

Servers in the project:
- Ingredient server: handle ingredients operatinons. Store ingredients in PostgreSql database. Handle CRUD operations via controllers. 
- Recipe server: handle recipe operatinons. Store ingredients in PostgreSql database. Handle CRUD operations via controllers. 
- Webkitchen server: handle incoming and outgoing requests and responses from and to to the frontend. Its in conact with ingredient and recipe servers.
- Eureka server: holds the information about all client-service applications.
- Zuul server: a gateway application that handles all the requests and does the dynamic routing of microservice applications.

<hr>

**Screenshots from the project:**

***Ingredient list page***

<img src=/public/static/images/screenshots/ingredient_list.png width=700 />


On the ingredient list page we can see the ingredients which are stored in our database. 

***Ingredient edit/add page***

<img src=/public/static/images/screenshots/ingredient_update.png width=700>

On this page we can edit data of existing ingredient. IóOn the same page can we add new recipe to our kitchen.  

***Recpie list page***

<img src=/public/static/images/screenshots/recipe_list.png width=700>

On this page we can see the recipes stored in our WebKitchen. We can see the basic details and the ingredients by the recipes. 

***Recpie update/add page***

<img src=/public/static/images/screenshots/recipe_update.png width=700>

On this page we can edit the existin recipe or we can add new recipe. The ingredients  can added and removed by drag and drop. 


<hr>

**Used technologies:**

- [Spring boot framework](https://spring.io/projects/spring-boot)
- Microservices (Eureka, zuul)
- [PostgreSql](https://www.postgresql.org/)


