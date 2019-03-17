# User Service
## POST/ Add Employee

* http://localhost:8080/employee/1


```JSON

    {
        "name": "Sedah Endless",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": "7/65 Bangkok 10170",
        "role": "manager"
    }

```


## Expectation

Employee info should be updated.

| Assert | Expected |
| - | - |
| StatusCode | 200 |
