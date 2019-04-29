[![CircleCI](https://circleci.com/gh/sumrid/soa2019_group7/tree/master.svg?style=svg)](https://circleci.com/gh/sumrid/soa2019_group7/tree/master)
# Project POS System
ระบบอช่วยอำนวยความสะดวกในการขายของตามร้านต่างๆ

## How to Build & Run
- ### complie -- > `mvnw clean package`

- ### run project -- > `mvnw spring-boot:run`

- ### test -- > `mvnw test`
  
## Deployment
  - ### API gateway [http://35.240.205.11](http://35.240.205.11/)
  ```
  https://soa-group7-235616.appspot.com/ {EndPoint}
  ```
   ###### example : https://<span></span>soa-group7-235616.appspot.com/employee

## API List
- [User Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/user)
   - ```POST /employee``` ~ เพิ่มข้อมูลบัญชีพนักงานสำหรับใช้งานระบบ<br>
   - ```GET /employee``` ~ แสดงข้อมูลบัญชีพนักงานทั้งหมด<br>
   - ```GET /employee/{id}``` ~ แสดงข้อมูลบัญชีพนักงานจากไอดี<br>
   - ```PUT /employee/{id}``` ~ แก้ไขข้อมูลบัญชีพนักงานจากไอดี<br>
   - ```DELETE /employee/{id}``` ~ ลบข้อมูลบัญชีพนักงานจากไอดี<br>
<br>

- [Product Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/product)
   - ```POST /product/save``` ~ เพิ่มข้อมูลรายการสินค้าในระบบ<br>
   - ```GET /product``` ~ แสดงข้อมูลสินค้าทั้งหมดในระบบ<br>
   - ```GET /product/{id}``` ~ แสดงสินค้างานจากไอดี<br>
   - ```PUT /product/{id}``` ~ แก้ไขข้อมูลสิค้าจากไอดี<br>
   - ```DELETE /product/{id}``` ~ ลบข้อมูลสินค้าจากไอดี<br>
- [Stock Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/stock)
   - ```POST /stocks``` ~ เพิ่มข้อมูลลงสต็อกสินค้า<br>
   - ```GET /stocks``` ~ แสดงข้อมูลสต็อกสินค้าทั้งหมดในระบบ<br>
   - ```GET /stocks/{id}``` ~ แสดงข้อมูลสต็อกสินค้าจากไอดี<br>
   - ```PUT /stocks/{id}``` ~ แก้ไขข้อมูลสต็อกสินค้าจากไอดี<br>
   - ```DELETE /stocks/{id}``` ~ ลบข้อมูลสต็อกสินค้าจากไอดี<br>
- [Bill Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/bill)
   - ```POST /bills``` ~ เพิ่มข้อมูลลงใบเสร็จสินค้า
   - ```GET /bills``` ~ แสดงข้อมูลใบเสร็จสินค้าทั้งหมดในระบบ
   - ```GET /bills/{id}``` ~ แสดงข้อมูลใบเสร็จสินค้าจากไอดี
   - ```PUT /bills/{id}``` ~ แก้ไขข้อมูลใบเสร็จสินค้าจากไอดี
   - ```DELETE /bills/{id}``` ~ ลบข้อมูลใบเสร็จสินค้าจากไอดี
- [Report Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/report)
   * `GET /reports` ~ แสดงข้อมูลรีพอร์ตทั้งหมดในระบบ 

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
