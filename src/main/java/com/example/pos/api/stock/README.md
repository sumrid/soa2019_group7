# Stock Service

## End Point
- ### เพิ่มข้อมูลลงสต็อกสินค้า
  #### POST >> http://localhost:8080/stocks
  **raw input**
  ```
    {
        "name": "Honda",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 100,
        "price": 9000000.25,
        "status": "Stored",
        "productId": 1100111
    }
   ```
    
  **Expectation**<br>
  Stock created.

  | Assert | Expected |
  | - | - |
  | StatusCode | 201 Created |
  
---
  
- ### แสดงข้อมูลสต็อกสินค้าทั้งหมด
  #### GET >> http://localhost:8080/stocks
  **Expectation**<br>
  Show all stocks. (Example)
  
  ```
  [
    {
        "id": 1,
        "name": "Honda",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 50,
        "price": 4500000,
        "status": "Stored",
        "productId": 1100111
    },
    {
        "id": 2,
        "name": "Toyota",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 50,
        "price": 4500000,
        "status": "Stored",
        "productId": 1100111
    },
    {
        "id": 3,
        "name": "Ipad",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 50,
        "price": 4500000,
        "status": "Stored",
        "productId": 1100111
    }
  ]

    ```
  
  | Assert | Expected |
  | - | - |
  | StatusCode | 200 OK |

---

- ### แสดงข้อมูลสต็อกสินค้าจากไอดี
  #### GET >> http://localhost:8080/stocks/1
  **Expectation**<br>
  Show stock that match the ID.
  ```
     {
        "id": 1
        "name": "Honda",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 100,
        "price": 9000000.25,
        "status": "Stored",
        "productId": 1100111
    }
    ```
    | Assert | Expected |
  | - | - |
  | StatusCode | 200 OK |
 ---
 
- ### แก้ไขข้อมูลสต็อกสินค้าจากไอดี
  #### PUT >> http://localhost:8080/stocks/1
  
    **raw input**
  ```
    {
        "name": "Honda",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 50,
        "price": 4500000,
        "status": "Stored",
        "productId": 1100111
    }
    
   ```
  
    **Expectation**<br>
Stock that match the ID will be updated.

  ```
     {
        "id": 1,
        "name": "Honda",
        "date_in": "10/04/40",
        "date_out": "10/09/62",
        "quantity": 50,
        "price": 4500000,
        "status": "Stored",
        "productId": 1100111
     }

  ```
  
  | Assert | Expected |
  | - | - |
  | StatusCode | 200 OK |
  ---
  
- ### ลบข้อมูลสต็อกสินค้าจากไอดี
  #### DELETE >> http://localhost:8080/stocks/1
  **Expectation**<br>
  Stock that match the ID will be deleted.
  
  | Assert | Expected |
  | - | - |
  | StatusCode | 200 OK |
  
  
