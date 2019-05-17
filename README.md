[![CircleCI](https://circleci.com/gh/sumrid/soa2019_group7/tree/master.svg?style=svg)](https://circleci.com/gh/sumrid/soa2019_group7/tree/master)
[![codecov](https://codecov.io/gh/sumrid/soa2019_group7/branch/master/graph/badge.svg)](https://codecov.io/gh/sumrid/soa2019_group7)
![java](https://img.shields.io/static/v1.svg?label=made%20with&message=java&color=f268b4&logo=java&style=flat)
![docker](https://img.shields.io/static/v1.svg?label=container&message=Docker&color=1488C6&logo=docker&style=flat&logoColor=white)
![google](https://img.shields.io/static/v1.svg?label=deployed&message=cloud%20platform&color=4285f4&logo=google&style=flat&logoColor=white)
# Project POS System
ระบบอช่วยอำนวยความสะดวกในการขายของตามร้านต่างๆ

สวัสดีครับ

## How to Build & Run
- ### complie -- > `mvnw clean package` `gradlew build`

- ### run project -- > `mvnw spring-boot:run` `gradlew bootrun`

- ### test -- > `mvnw test` `gradlew test`
  
## Deployment
  ```
  https://soa-group7-235616.appspot.com/ {EndPoint}
  ```
   ###### example : https://<span></span>soa-group7-235616.appspot.com/employee

## API List
- [User Service](https://github.com/sumrid/soa2019_group7/tree/master/src/main/java/com/example/pos/api/user)
   - ```POST /user``` ~ เพิ่มข้อมูลบัญชีพนักงานสำหรับใช้งานระบบ<br>
   - ```GET /user``` ~ แสดงข้อมูลบัญชีพนักงานทั้งหมด<br>
   - ```GET /user/{username}``` ~ แสดงข้อมูลบัญชีพนักงานจากไอดี<br>
   - ```PUT /user/{username}``` ~ แก้ไขข้อมูลบัญชีพนักงานจากไอดี<br>
   - ```DELETE /user/{username}``` ~ ลบข้อมูลบัญชีพนักงานจากไอดี<br>
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

## API Documents
[![](https://img.shields.io/badge/swagger-api%20document-blue.svg)](https://app.swaggerhub.com/apis-docs/sumrid/posSystem/1.0.0#/)
[![](https://img.shields.io/static/v1.svg?label=github&message=Wiki&color=7150aa&logo=github&style=flat)](https://github.com/sumrid/soa2019_group7/wiki/Services)
