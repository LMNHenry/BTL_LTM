# fa-3_4
# **Ứng dụng Mail Client sử dụng giao thức SMTP, POP3, IMAP thông qua máy chủ Gmail và Outlook.**
## Các chức năng đã đạt được.

 - [Gửi Mail thông qua Gmail](https://github.com/jnp2018/fa-3_4/tree/main/src/main)
 - [Gửi Mail thông qua Outlook](https://github.com/jnp2018/fa-3_4/tree/main/src/main)
 - [Gửi Mail đính kèm tệp thông qua Gmail](https://github.com/jnp2018/fa-3_4/tree/main/src/main)
 - [Gửi Mail đính kèm tệp thông qua Outlook](https://github.com/jnp2018/fa-3_4/tree/main/src/main)
 - [Xuất Mail ra têp eml thông qua giao thức IMAP](https://github.com/jnp2018/fa-3_4/tree/main/src/main)

## Tổng hợp công việc.

| STT |     MSV- Họ Tên                 | Các nội dung thực hiện                      | Thể hiện            |Ghi chú      |
| :-- | :-------------------------------| :------------------------------------------ |:---------------------------------------------- |:----------|
| `1` | `B19DCCN306 - Lê Nhật Huy`      | 21-5/10/2022: thực hiện gửi gmail bằng java |**SendEmail.java**||
|     |                                 | 5-12/10/2022: lưu mail gửi/ nhận vào database|**Email.java**||
|     |                                 | 12-19/10/2022: Thực hiện lưu mail/ import mail vào excel  với Apache Poi| **SaveMail.java**||
|     |                                 | 19-26/10/2022:  Thực hiện lưu mail vào file eml, config outlook để gửi đi với mail ptit| ||
|     |                                 | 3-16/10/2022: Thực hiện import và export với mail outlook|**ExportMail.java, ImportPst.java**||
| `2` | `B19DCCN708 - Nguyễn Văn Trưởng`| 21-5/10/2022: Thực hiện nhận và đọc gmail bằng java.|**ReceiveEmail.java**||
|     |                                 | 5-12/10/2022: lấy email từ database.|**SentMail.java**||
|     |                                 | 12-19/10/2022:config outlook, gửi và nhận mail trong outlook.|**SendEmail.java**||
|     |                                 | 19-26/10/2022: Format code, test các chức năng hiện có (với mail outlook)|**Home.java**||     
| `3` | `B19DCCN126 - Nguyễn Tiến Dũng` | 5-12/10/2022: nghiên cứu tìm hiểu nhận mail bằng IMAP/POP3|||
|     |                                 | 12-19/2022: Tổng hợp lý thuyết smtp, pop3, imap|**Readme.md**||
|     |                                 | 19-26/2022: Thực hiện gửi mail đính kèm file   |**SendMailAttachment**||   



## Quá trình phát triển sản phẩm.
| STT |    Phiên bản                    | Vấn đề                                      | Xử lý trong phiên bản tiếp theo                    | Tự đánh giá      |Người thực hiện|
| :---| :-------------------------------| :------------------------------------------ |:-------------------------------------------------- |:-----------------|:--------------|
| `1` | `1.0                     `      |                                             |config host và port để có thể gửi được mail outlook |outlook thường có thể nhận và gửi mail |Huy, Trưởng|
|     | `12/10/2022     `               | chưa thử nghiệm với outlook                 |                                                    |                                       |           |
| `2` | `1.1`                           |                                             |                                                    |                                       |           |
|     | `19/10/2022`                    | Chưa có lưu mail (huỷ bỏ lưu mail với excel)| bổ sung thêm lưu mail(với định dạng chuẩn)         |lưu các mail nhận về dưới dạng file eml|Huy        |
|     |                                 | Bổ sung thêm tính năng gửi mail kèm         |Bổ sung tính năng gửi mail kèm file                 |                                       |Dũng       |       
| `3` | `1.2`                           |                                             |                                                    |                                       |           |
|     | `26/10/2022`                    | chưa có import và export                    |       Thêm export và import mail                   |                                       |  Huy      |
| `4` | `2.0`                           |                                             |                                                    |                                       |           |
|     | `16/11/2022`                    |                                             |                                                    |                                       |           |






