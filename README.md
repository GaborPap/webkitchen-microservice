# WebKitchen

Backend for the WebKitchen webpage.

The frontend of the application you can find [here](https://github.com/GaborPap/webkitchen-client/)

<hr>

**Information about the backend of the WebKitchen project:**

This project is created with a Spring boot framework using Microservices Architecture. 

Servers in the project:
- Ingredient server: handle ingredients operations. Store ingredients in the PostgreSQL database. Handle CRUD operations via controllers. 
- Recipe server: handle recipe operations. Store ingredients in the PostgreSQL database. Handle CRUD operations via controllers. 
- WebKitchen server: handle incoming and outgoing requests and responses from and to the frontend. It is in contact with ingredients and recipe servers.
- Eureka server: holds the information about all client-service applications.
- Zuul server: a gateway application that handles all the requests and does the dynamic routing of microservice applications.

<hr>

**Screenshots from the project:**

***Ingredient list page***

<img src=/public/static/images/screenshots/ingredient_list.png width=700 />


On the ingredient list page, we can see the ingredients which are stored in our database. 

***Ingredient edit/add page***

<img src=/public/static/images/screenshots/ingredient_update.png width=700>

On this page, we can edit the data of existing ingredients. On the same page can we add a new recipe to our kitchen.  

***Recipe list page***

<img src=/public/static/images/screenshots/recipe_list.png width=700>

On this page, we can see the recipes stored in our WebKitchen. We can see the basic details and the ingredients by the recipes. 

***Recpie update/add page***

<img src=/public/static/images/screenshots/recipe_update.png width=700>

On this page, we can edit the existing recipe or we can add a new recipe. The ingredients can be added and removed by drag and drop. 


<hr>

**Used technologies:**

- [Spring boot framework](https://spring.io/projects/spring-boot)
- Microservices (Eureka, zuul)
- [PostgreSql](https://www.postgresql.org/)

