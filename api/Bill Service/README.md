# Bill Service
### วิธีการ run service
 * ต้องติดตั้ง Gradle ลงบนเครื่องก่อน
 * เปิด command prompt แล้วเข้าไปยังโฟลเดอร์ของ service
 * พิมพ์คำสั่ง `gradle clean build`
 * พิมพ์คำสั่ง `gradle bootRun` เพื่อเริ่ม service
 
 ### Endpoint
 * `GET /bills`
 * `GET /bills/{id}`
 * `POST /bills`
 * `PUT /bills/{id}`
 * `DELETE /bills/{id}` 