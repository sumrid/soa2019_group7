# User Service
## POST/ Add Employee

* http://localhost:8080/employee


```JSON

    {
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": "7/65 Bangkok 10170",
        "role": "manager"
    }

```


## Expectation

New post should be created.

| Assert | Expected |
| - | - |
| StatusCode | 201 |
