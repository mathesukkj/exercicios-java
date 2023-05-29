# API-RESTful-Spring

API REST simples feita em Java com o framework Spring Boot, e o banco de dados NOSql MongoDB.

Desenvolvi esse projeto durante o [Curso de Java Completo do Nélio Alves](https://www.udemy.com/course/java-curso-completo/), na Udemy. 

### Features da API
* CRUD de usuários
* Ver todos os posts existentes, ou de um usuário especificado


## API Requests

#### Get users

```
  GET /users
  GET /users/{id}
```

#### Create a new user

```
  POST /users
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**.  |
| `email`      | `string` | **Required**.  |

#### Update user

```
  PUT /users/{id}
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**.  |
| `email`      | `string` | **Required**.  |


#### Delete user

```
  DELETE /users/{id}
```

#### Get posts

```
  GET /posts
  GET /posts/{id}
  GET /posts/{userId}/posts
```

#### Get posts by text

```
  GET /posts/search?{}
```

| Params | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `text`      | `string` | **Required**. Text to search for  |

#### Get posts by author

```
  GET /posts/author?{}
```

| Params | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `text`      | `string` | **Required**. Author username  |

#### Get posts by text and dates

```
  GET /posts/fullsearch?{}
```

| Params | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `text`      | `string` | **Required**. Text to search for  |
| `minDate`      | `string` | **Required**. Format (yyyy-MM-dd)  |
| `maxDate`      | `string` | **Required**. Format (yyyy-MM-dd)  |
