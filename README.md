# API Documentation

## Endpoint

`http:/localhost:9000/api`

## Response Template

```json
{
  "status": boolean,
  "messages": [
    string,
    string,
    .....
  ],
  "playload": [
    {
      .....
    },
    {
      .....
    }
  ]
}
```

## USER

### Register

- URL: `/register`
- Method: `POST`
- Request Body:
  ```json
  {
    "name": string,
    "username": string,
    "email": string,
    "password": string
  }
  ```
- Response
  ```json
  {
    "status": true,
    "messages": ["Akun berhasil didaftarkan"],
    "playload": [
      {
        "id": 1,
        "username": "kana",
        "password": "$2a$10$XzDN3cVVL.RPYUS2TbrI9.1CAmIGnmKA6zLESEhZb81it8zLGzjdm",
        "is_enabled": true,
        "is_account_non_locked": true,
        "created_at": "2023-06-20T06:42:31.544+00:00",
        "roles": [
          {
            "id": 1,
            "name": "user",
            "privileges": [
              {
                "id": 1,
                "name": "create"
              },
              {
                "id": 2,
                "name": "read"
              },
              {
                "id": 3,
                "name": "update"
              },
              {
                "id": 4,
                "name": "delete"
              }
            ]
          }
        ]
      }
    ]
  }
  ```

### Login

- URL: `/login`
- Method: `POST`
- Request Body:
  ```json
  {
    "username": string,
    "password": string
  }
  ```
- Response

  ```json
  {
  "status": true,
  "messages": [
    "berhasil login"
  ],
  "playload": [
    {
      "username": "kana",
      "email": "kana@gmail.com",
      "authorities": [
        "ROLE_USER",
        ....
        ....
      ]
    }
  ]
  }
  ```

### Add course (Authorized)

- Method: `POST`
- URL: `/trasaction`
- Request Body:

```json
{
  "courseId": 2
}
```

## ADMIN

### CRUD Category

- Method Available: `GET, POST, PUT, DELETE`
- URL `GET, POST`: `/course/category`
- URL `PUT, DELETE`: `/course/category/{id}`
- Request Body `POST`:

  ```json
  {
    "name": "frontend"
  }
  ```

### CRUD course

- Method Available: `GET, POST, PUT, DELETE`
- URL `GET, POST`: `/course`
- URL `GET, PUT, DELETE`: `/course/{id}`
- Request Body `POST`:

  ```json
  {
  "thumbnail" : "this url img x",
  "title": "fullstack java",
  "instructor": "rizki",
  "description": "belajar fullstack springboot java dev",
  "price": "free",
  "periode": "3 bulan",
  "start" : "typedata date"
  "end": "typedata date"
   "category": {
     "id": 1
   }
  }
  ```

### Update Status Transaction

- Method: `PUT`
- URL: `/transaction`
- Request Body

```json
{
  "statusUpdate": "success" // success, process, failed
}
```
