# Bill Service

## วิธีทดสอบ
  1.build และ run service ด้วย spring boot version 2+
  
## Endpoint
* #### เพิ่มข้อมูลใบเสร็จลงในระบบ
  POST >> http://localhost:8080/bills
  
  raw input:
  ```java
  {
	"date":"2019-03-01",
	"productId":1,
	"amount":1,
	"totalPrice":99.99,
	"companyName":"companyName"
  }
  ```
  
* #### เรียกข้อมูลใบเสร็จทั้งหมด
  GET >> http://localhost:8080/bills
  
  output:
  ```java
  [
	{
		"id":1,
		"date":"2019-03-01",
		"productId":1,
		"amount":1,
		"totalPrice":99.99,
		"companyName":"companyName"
	},
	{
		"id":2,
		"date":"2019-03-02",
		"productId":1,
		"amount":1,
		"totalPrice":99.99,
		"companyName":"companyName"
	}
  ]
  ```
* #### เรียกข้อมูลใบเสร็จจากไอดี
  GET >> http://localhost:8080/bills/{id}
  
  output:
  ```java
  {
        "id":1,
	"date":"2019-03-01",
	"productId":1,
	"amount":1,
	"totalPrice":99.99,
	"companyName":"companyName"
  }
  ```
  
* #### แก้ไขข้อมูลใบเสร็จ
  PUT >> http://localhost:8080/bills/{id}

  raw input:
  ```java
  {
        "id":1,
	"date":"2019-03-01",
	"productId":1,
	"amount":5,
	"totalPrice":185.9,
	"companyName":"companyName"
  }
  ```
  
  * #### ลบใบเสร็จ
    DELETE >> http://localhost:8080/bills/{id}
  
