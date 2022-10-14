# PHÁT TRIỂN PHẦN MỀM  THEO CHUẨN ITSS 
## Lab 01 - Use case diagram
> Phạm Quang Hà - 20194546

## Use case đặt hàng nhanh
Luồng chính của sự kiện
|#| Tác nhân | Hành động |
|------| ------ | ------ |
|1| Khách hàng | Chọn phương thức giao hàng nhanh (Tiếp tục từ hành động thứ 5 của Use case đặt hàng)|
|2| Hệ thống | Kiểm tra sản phẩm và địa chỉ có hỗ trợ giao hàng nhanh không |
|3| Hệ thống | Yêu cầu khách hàng cập nhật thông tin giao hàng nhanh |
|4| Khách hàng | Cập nhật thông tin theo yêu cầu của hệ thống | 
|5| Hệ thống | Kiểm tra lại số lượng sản phẩm hỗ trợ giao hàng nhanh và số lượng sản phẩm giao hàng bình thường|
|6| Hệ thống | Tính tổng đơn giá của các sản phẩm và phí giao hàng, ... |
|7| Hệ thống | Hiển thị lên giao diện người dùng tổng số tiền mà khách hàng phải thanh toán |
|8| Hệ thống | Hiển thị nút cho phép khách hàng thanh toán đơn hàng |


Luồng sự kiện thay thế
|#| Tác nhân | Hành động |
|------| ------ | ------ |
|2a| Hệ thống | Yêu cầu khách hàng cập nhật lại thông tin giao hàng nếu không có sản phẩm nào hoặc địa chỉ nhận hàng không hỗ trợ giao hàng nhanh |
