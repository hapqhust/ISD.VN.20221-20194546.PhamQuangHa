# PHÁT TRIỂN PHẦN MỀM  THEO CHUẨN ITSS 
## Lab 01 - Use case diagram
> Phạm Quang Hà - 20194546

## Use case đặt hàng
- Luồng sự kiện chính

|#| Tác nhân | Hành động |
|------| ------ | ------ |
|1| Khách hàng | Xem giỏ hàng |
|2| Khách hàng | Yêu cầu đặt hàng khi muốn mua các sản phẩm có trong giỏ hàng |
|3| Hệ thống | Kiểm tra hàng tồn kho đủ cung cấp cho khách hàng |
|4| Khách hàng | Nhập thông tin giao hàng, phương thức giao hàng và chỉ dẫn giao hàng (nếu cần) 
|5| Khách hàng | Chọn phương thức giao hàng mặc định hoặc giao hàng nhanh||
|6| Hệ thống | Kiểm tra tính hợp lệ của các thông tin mà khách hàng đã nhập |
|7| Hệ thống | Kiểm tra xem khách hàng chọn phương thức giao hàng mặc định hay không |
|8| Hệ thống | Tính tổng đơn giá của các sản phẩm và phí giao hàng, ... |
|9| Hệ thống | Hiển thị lên giao diện người dùng tổng số tiền mà khách hàng phải thanh toán |
|10| Hệ thống | Hiển thị nút cho phép khách hàng thanh toán đơn hàng |

- Luồng sự kiện thay thế

|#| Tác nhân | Hành động |
|------| ------ | ------ |
|2a| Khách hàng | Khách hàng cập nhật giỏ hàng hoặc thoát ra do không muốn đặt hàng |
|3a| Hệ thống | Thông báo hàng tồn kho không đủ cung cấp cho khách hàng. Quay lại bước 1, yêu cầu khách hàng cập nhật lại giỏ hàng và đặt hàng lại |
|6a| Hệ thống |Thông báo khách hàng nhập thông tin không hợp lệ hoặc thiếu thông tin, yêu cầu nhập lại|
|7a| Hệ thống | Nếu khách hàng chọn giao hàng nhanh thì chuyển đến chức năng giao hàng nhanh |
