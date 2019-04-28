[![Build Status](https://travis-ci.com/sumrid/Bill.svg?token=AQTAKJS8ztptGV6L7YzB&branch=master)](https://travis-ci.com/sumrid/Bill)

# Bill service

### Endpoint
`GET /bills` แสดงรายการบิลทั้งหมด

`GET /bills/{id}`

`GET /bills/name/{name}`

`GET /bills/date/{date}` แสดงรายการตามวันที่กำหนด เช่น "2016-04-12", "today"

`GET /bills/company/{company name}`