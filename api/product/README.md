# Product Service 
ใช้สำหรับดึงข้อมูลสินค้ามาแสดงบนเว็บ

## วิธีทดสอบ
ทำการ build ด้วย Gradle version 2.0+

## EndPoint
- ```GET /api/product```<br>
ดึงข้อมูลสินค้าทั้งหมดใน database มาแสดง<br>

- ```POST /api/product/save```<br>
เพิ่มข้อมูลรายการสินค้าใหม่ไปยัง database<br>

- ```PUT /api/product/:id```<br>
ลบข้อมูลสินค้าตาม id ที่กำหนด<br>

- ```DELETE /api/product/:id```<br>
ลบข้อมูลสินค้าตาม id ที่กำหนด<br>
