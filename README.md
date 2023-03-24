# User CRUD Back End

[Front end demo](https://user-crud-front.netlify.app/)

Base url demo: https://back.jorgesala.site/crudUser/api/

#### Authentication & authorization

##### Roles & permission

CUSTOMER role can perform following 

1. Find user by id.  GET /api/users/{userId}

   

EMPLOYEE role can perform the previous and following 

1. Get a list of all users.  GET /api/users
2.  Find user by first name. GET /search/users/{firstName}

​        

MANAGER role can perform the previous and following 

1. Add a new user.  POST /api/users
2. Update an existing user.  PUT /api/users



ADMIN role can perform the previous and following 

1. Delete a user.  DELETE /api/users/{userId}



Users and their roles are hard coded at the moment so I'll just list them for testing purposes

| Username | password | Role(s)            |
| -------- | -------- | ------------------ |
| Jorge    | test123  | customer           |
| Enrique  | test123  | employee           |
| Miguel   | test123  | employee + manager |
| Patrobas | test123  | employee + admin   |



#### Endpoints

#### List all users

<details>
 <summary><code>GET</code> <code><b>/api/users/</b></code> <code>(gets all users)</code></summary>

 ##### Parameters

> | name | type     | data type             | description |
> | ---- | -------- | --------------------- | ----------- |
> | None | required | object (JSON or YAML) | N/A         |

</details>

#### Find by id

<details>
 <summary><code>GET</code> <code><b>/api/users/{id}</b></code> <code>(gets user by its id)</code></summary>

 ##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | int   | id of the user  |

</details>

#### Find by first name
<details>
 <summary><code>GET</code> <code><b>/search/{firstName}</b></code> <code>(gets user by its first name)</code></summary>

 ##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | firstName      |  required | String   | First name of the user |

</details>

#### Create new user

<details>
 <summary><code>POST</code> <code><b>/api/users/</b></code> <code>Creates a new user</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | None      |  required | object (JSON or YAML)   | N/A  |


</details>

#### Update existing user

<details>
  <summary><code>PUT</code> <code><b>/api/users/</b></code> <code>(updates users with the data given)</code></summary>

##### Parameters

> | name              |  type     | data type      | description                         |
> |-------------------|-----------|----------------|-------------------------------------|
> | `` |  required | int   |         |


</details>

#### Delete existing user

<details>
  <summary><code>DELETE</code> <code><b>/{id}</b></code> <code>(deletes a user by the given id)</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | int   | id of the user  |

</details>