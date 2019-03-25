# Product Service

## วิธีทดสอบใช้งาน
1. build และ run โปรแกรมด้วย Spring boot version 2+
2. ทดสอบตามรายการ End point 

## End Point
- ### เพิ่มข้อมูลสินค้าใหม่ลงในระบบ
  #### POST >> http://localhost:8080/product/save
  **raw input**
  ```
  {
      "name": "ProductName1",
      "price": 2500,
      "quantity": 300,
      "detail" : "product detail",
      "img": "http://img.url"
  }
   ```
    
  **Expectation**<br>
  Add new Product Success.

  | Assert | Expected |
  | - | - |
  | StatusCode | 201 |
  
---
  
- ### แสดงข้อมูลสินค้าทั้งหมด
  #### GET >> http://localhost:8080/product

---
 
- ### แก้ไขข้อมูลสินค้าจากไอดี
  #### PUT >> http://localhost:8080/product/ { id }
  
    **raw input**
  ```
    {
        "detail": "detail product to edit",
        "name": "ProductName Edited",
        "price": 200,
        "quantity": 10,
        "img": "http://img.url"
    }
   ```
  
    **Expectation**<br>
Product info should be updated.

  | Assert | Expected |
  | - | - |
  | StatusCode | 200 |

---
  
- ### ลบข้อมูลสินค้าจากไอดี
  #### DELETE >> http://localhost:8080/product/ { id }
  **Expectation**<br>
  Product should be deleted.
  
  | Assert | Expected |
  | - | - |
  | StatusCode | 200 |
  
  
