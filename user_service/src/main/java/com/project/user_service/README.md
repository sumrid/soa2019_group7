# User Service

## วิธีทดสอบใช้งาน
1. build และ run โปรแกรมด้วย Spring boot version 2+
2. ทดสอบตามรายการ End point 

## End Point
- ### เพิ่มข้อมูลบัญชีพนักงานสำหรับใช้งานระบบ
  #### POST >> http://localhost:8080/employee
  **raw input**
  ```
    {
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": "7/65 Bangkok 10170",
        "role": "manager"
    }
   ```
    
  **Expectation**<br>
  New employee should be created.

  | Assert | Expected |
  | - | - |
  | StatusCode | 201 |
  
---
  
- ### แสดงข้อมูลบัญชีพนักงานทั้งหมด
  #### GET >> http://localhost:8080/employee

---

- ### แสดงข้อมูลบัญชีพนักงานจากไอดี
  #### GET >> http://localhost:8080/employee/1
  **Expectation**<br>
  Here is the expectation response
  ```
     {
        "id": "1",
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": "7/65 Bangkok 10170",
        "role": "manager"
    }
    ```
 ---
 
- ### แก้ไขข้อมูลบัญชีพนักงานจากไอดี
  #### PUT >> http://localhost:8080/employee/1
  
    **raw input**
  ```
    {
        "name": "Sedah Endless",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": "7/65 Bangkok 10170",
        "role": "manager"
    }
   ```
  
    **Expectation**<br>
Employee info should be updated.

  | Assert | Expected |
  | - | - |
  | StatusCode | 200 |

---
  
- ### ลบข้อมูลบัญชีพนักงานจากไอดี
  #### DELETE >> http://localhost:8080/employee/1
  **Expectation**<br>
  Employee should be deleted.
  
  | Assert | Expected |
  | - | - |
  | StatusCode | 200 |
  
  
