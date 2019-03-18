# Project POS System
ระบบอช่วยอำนวยความสะดวกในการขายของตามร้านต่างๆ

## How to Build & Run
- ### complie -- > `mvnw clean package`

- ### run project -- > `mvnw spring-boot:run`

- ### test -- > `mvnw test`
  
   
## API List
- [User Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/user)
   - ```POST /employee``` ~ เพิ่มข้อมูลบัญชีพนักงานสำหรับใช้งานระบบ<br>
   - ```GET /employee``` ~ แสดงข้อมูลบัญชีพนักงานทั้งหมด<br>
   - ```GET /employee/{id}``` ~ แสดงข้อมูลบัญชีพนักงานจากไอดี<br>
   - ```PUT /employee/{id}``` ~ แก้ไขข้อมูลบัญชีพนักงานจากไอดี<br>
   - ```DELETE /employee/{id}``` ~ ลบข้อมูลบัญชีพนักงานจากไอดี<br>
<br>

- Product Service
- Stock Service
- Bill Service

## Feature
-	สร้างบิล
-	เพิ่ม/ลบพนักงาน
-	ดูรีพอร์ท
-	จัดการสินค้า
-	จัดการสต๊อก
-	เพิ่ม/ลบสินค้า
## Core Feature
-	การสร้างบิล

## Flow
![Imgur](https://i.imgur.com/ta07pOC.png)
