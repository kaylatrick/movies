# movies

## API Documentation Assignment

### 7-11-2017 Spec:
Use Swagger to document all REST APIs on 'Movie Database' project and provide at least 4 customizations to the API documentation.

### Customizations
* Updated page heading
* Path changed from default to "/"
* Changed Operation Section Headings to be more easily readable
* Changed Operation Lists to describe what the method would do

### Additional Documentation
Added JavaDoc comments and generated JavaDocs for API.


## IMDB Clone API Assignment

## Routes
### Action	Method	Path
### MOVIES		
Movie Search	GET	http://localhost:8080/findMovies?title=t  
Get Movie by ID	GET	http://localhost:8080/api/movie/1  
Get All Movies	GET	http://localhost:8080/api/getAllMovies  
Add Movie	POST	http://localhost:8080/api/movie/ + json form data (returns movie w/ assigned movie ID)  
Update Movie	PUT	http://localhost:8080/api/movie/5 + json form data  
Delete Movie	DELETE	http://localhost:8080/api/movie/5  
### ROLES		
Role Search	GET	
Get Role by ID	GET	http://localhost:8080/role/3  
Get All Roles	GET	http://localhost:8080/role/all  
Add Role	POST	http://localhost:8080/role + json form data (returns role w/ assigned role ID)  
Update Role	PUT	http://localhost:8080/role/3 + json form data  
Delete Role	DELETE	http://localhost:8080/role/3  
### REVIEWS		
Get All Reviews	GET	http://localhost:8080//api/getAllReviews  
### USERS		
User Search	GET	http://localhost:8080/api/findUsers?screenname=screenname  
Get User by ID	GET	http://localhost:8080/api/user/2  
Get All Users	GET	http://localhost:8080/api/getAllUsers  
Add User	POST	http://localhost:8080/api/user/ + json form data (returns user w/ assigned user ID)  
Update User	PUT	http://localhost:8080/api/user/2 + json form data  
Delete User	DELETE	http://localhost:8080/api/user/4  
### TESTING		
Get All Movies		Returns success  
Get Movie by ID		Returns expected format  

## Next steps:
* Incorporate security to work more logically with a JSON API rather than using a form-based login as we saw in class this AM
* Accept collections of Movies, Roles, and Users and either add or update based on whether or not they are found in the DB
* Assign ownership of Movies & Roles to specific Users (ie, Paramount owns Paramount movies)
* Continue to build out functionality around joins (which has been a topic of research and discussion this week)
