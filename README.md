
# Loyalty

a. Viết API cho phép chỉnh sửa cấu hình tích điểm lưu trữ vào database

    - ConfigController.java (/api/config)
    - Sử dụng H2 Database (http://localhost:8080/h2-console)

b. Xử lý tích điểm vào thẻ cho khách hàng dựa trên giao dịch, thay đổi thông tin hạng thẻ của khách hàng tương ứng

    - Đọc xong em không biết phải làm gì thật. Nên em viết các hàm nhỏ xử lý các vấn đề.
    - Khi có giao dịch thành công:
    + Chuyển đổi 'Số doanh thu điều chỉnh' sang 'Số điểm điều chỉnh' của giao dịch
    + Tìm thông tin thẻ tích điểm theo LoyaltyCardId của giao dịch
    + Cộng điểm, doanh thu từ giao dịch thành công vào thẻ tích điểm
    + Kiểm tra lại 'tổng doanh thu' của thẻ tích điểm so sách với 'doanh thu lên hạng'
        của các hạng thẻ để nâng hạng thẻ cho khách hàng.

c. Unit test

    - Test các hàm xử lý ở service

d.1 Nếu giao dịch được tổng hợp từ các hệ thống khác và định kỳ được tải lên hệ thống tích điểm,
thì xử lý như thế nào trong trường hợp cấu hình quy đổi điểm bị thay đổi giữa các lần giao dịch của khách hàng?

    - Theo em thì nên lưu lại dữ liệu trước khi cấu hình quy đổi điểm được thay đổi.
    - Khi thực hiện xử lý tích điểm vào thẻ cho khách hàng thì sẽ thực hiện
        Chuyển đổi 'Số doanh thu điều chỉnh' sang 'Số điểm điều chỉnh' của giao dịch với
        cấu hình có thời gian thay đổi gần nhất trước khi thực hiện giao dịch thành công.

d.2 Để tăng hiệu năng hệ thống khi có rất nhiều giao dịch của nhiều khách hàng đồng thời thì có giải pháp nào không?

    - ......... :D
