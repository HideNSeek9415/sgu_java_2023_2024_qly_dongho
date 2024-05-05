DROP SCHEMA mywatchstore; 
CREATE SCHEMA mywatchstore;
USE mywatchstore;

CREATE TABLE roles (
    role_id ENUM('SLR', 'WHM', 'ADM', 'CTM') PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE permissions (
    permission_code ENUM ('PRODUCT', 'ORDER', 'RECEIPT', 'CUSTOMER', 'EMPLOYEE', 'SUPPLIER', 'WARRANTY') PRIMARY KEY,
    permission_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE decentralization (
    id INT AUTO_INCREMENT,
    role_id ENUM('SLR', 'WHM', 'ADM', 'CTM'),
    permission_code ENUM ('PRODUCT', 'ORDER', 'RECEIPT', 'CUSTOMER', 'EMPLOYEE', 'SUPPLIER', 'WARRANTY'),
    adding BOOLEAN DEFAULT FALSE,
    editing BOOLEAN DEFAULT FALSE,
    deleting BOOLEAN DEFAULT FALSE,
    other BOOLEAN DEFAULT FALSE,
	PRIMARY KEY (id, role_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (permission_code) REFERENCES permissions(permission_code)
);

CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(15) NOT NULL,
    passwd VARCHAR(20) NOT NULL,
    account_status ENUM('active', 'inactive') DEFAULT 'active',
    role_id ENUM('SLR', 'WHM', 'ADM', 'CTM') DEFAULT 'CTM',
    created_date DATE,
	FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

DELIMITER //
CREATE TRIGGER set_created_date BEFORE INSERT ON accounts
FOR EACH ROW
BEGIN
    SET NEW.created_date = CURDATE();
END;
//
DELIMITER ;

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    gender ENUM('Nam', 'Nữ') NOT NULL,
    date_of_birth DATE NOT NULL,
    phone_number VARCHAR(20) UNIQUE,
    address TEXT,
    account_id INT,
	FOREIGN KEY (account_id) REFERENCES accounts(id)
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    gender ENUM('Nam', 'Nữ') NOT NULL,
    date_of_birth DATE NOT NULL,
    phone_number VARCHAR(20) UNIQUE,
    address TEXT,
	account_id INT,
	FOREIGN KEY (account_id) REFERENCES accounts(id)
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    category ENUM('Đồng hồ cơ', 'Đồng hồ điện tử', 'Đồng hồ thông minh'),
    brand VARCHAR(100),
	sell_price INT NOT NULL,
    discount BOOLEAN DEFAULT FALSE,
    discount_price INT,
    quantity INT,
    product_status BOOLEAN DEFAULT TRUE,
    image_url VARCHAR(255)
);

CREATE TABLE suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    supplier_status ENUM('active', 'inactive') DEFAULT 'active',
    phone_number VARCHAR(20)
);

CREATE TABLE import_invoices (
    import_invoice_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    supplier_id INT,
    invoice_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);

CREATE TABLE import_invoice_details (
	details_id INT AUTO_INCREMENT PRIMARY KEY,
    import_invoice_id INT,
    product_id INT,
    quantity INT,
    import_price INT,
    FOREIGN KEY (import_invoice_id) REFERENCES import_invoices(import_invoice_id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE export_invoices (
    export_invoice_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    customer_id INT,
    export_invoice_status INT DEFAULT 0,
    invoice_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE export_invoice_details (
    details_id INT AUTO_INCREMENT PRIMARY KEY,
    export_invoice_id INT,
    product_id INT,
    sell_price INT,
    FOREIGN KEY (export_invoice_id) REFERENCES export_invoices(export_invoice_id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE warranty (
    warranty_id INT AUTO_INCREMENT PRIMARY KEY,
    detail_id INT,
    reason TEXT,
    status ENUM('pending', 'accepted', 'rejected'),
    FOREIGN KEY (detail_id) REFERENCES export_invoice_details(details_id)
);

CREATE TABLE product_supplier (
    product_id INT,
    supplier_id INT,
    PRIMARY KEY (product_id, supplier_id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);

CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    customer_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- THÊM DỮ LIỆU MẪU
INSERT INTO roles (role_id, role_name) VALUES
('SLR', 'Nhân viên bán hàng'),
('WHM', 'Nhân viên quản lý kho'),
('ADM', 'Người quản trị'),
('CTM', 'Khách hàng');

INSERT INTO permissions (permission_code, permission_name) VALUES
('PRODUCT', 'Sản phẩm'),
('ORDER', 'Phiếu xuất'),
('RECEIPT', 'Phiếu nhập'),
('CUSTOMER', 'Khách hàng'),
('EMPLOYEE', 'Nhân viên'),
('SUPPLIER', 'Nhà cung cấp'),
('WARRANTY', 'Bảo hành');
/*
Quyền của người dùng
1. Nhân viên bán hàng
    - Xem sản phẩm
    - Xem tạo phiếu xuất
    - Xem phiếu nhập
    - Xem và xác nhận/từ chối bảo hành
    - Xem nhà cung cấp (và thông tin chi tiết các sản phẩm NCC có thể CC)
2. Nhân viên quản lý kho 
    - Xem sản phẩm
    - Xem phiếu xuất
    - Xem và tạo phiếu nhập
    - Xem - thêm nhà cung cấp
    - Thêm sản phẩm từ NCC có thể CC
3. Người quản trị
    - Xem trang sản phẩm (trang mua hàng)
    - Xem - chỉnh sửa - thay đổi trạng thái sản phẩm
    - Xem - thêm - chỉnh sửa - thay đổi trạng thái nhân viên
    - Xem - thêm - chỉnh sửa - thay đổi trạng thái khách hàng
    - Xem - chỉnh sửa - thay đổi trạng thái tài khoản
    - Xem - thêm - chỉnh sửa - thay đổi trạng thái nhà cung cấp
    - Thêm sản phẩm từ NCC có thể CC
    - Xem - tạo phiếu xuất
    - Xem - tạo phiếu nhập
    - Xem và xác nhận/từ chối bảo hành
    - Xem trang thống kê
4. Khách hàng
    - Xem trang sản phẩm (trang mua hàng)
    - Xem lịch sử mua hàng
*/

INSERT INTO decentralization (role_id, permission_code, adding, editing, deleting, other) VALUES
('SLR', 'PRODUCT', FALSE, FALSE, FALSE, NULL),
('SLR', 'EMPLOYEE', FALSE, FALSE, FALSE, NULL),
('SLR', 'CUSTOMER', NULL, FALSE, FALSE, NULL),
('SLR', 'ORDER', TRUE, TRUE, NULL, NULL),
('SLR', 'RECEIPT', FALSE, FALSE, NULL, NULL),
('SLR', 'WARRANTY', NULL, NULL, NULL, TRUE),
('SLR', 'SUPPLIER', TRUE, TRUE, TRUE, TRUE),
('WHM', 'PRODUCT', TRUE, TRUE, TRUE, NULL),
('WHM', 'EMPLOYEE', FALSE, FALSE, FALSE, NULL),
('WHM', 'CUSTOMER', NULL, FALSE, FALSE, NULL),
('WHM', 'ORDER', FALSE, FALSE, NULL, NULL),
('WHM', 'RECEIPT', TRUE, TRUE, NULL, NULL),
('WHM', 'WARRANTY', NULL, NULL, NULL, FALSE),
('WHM', 'SUPPLIER', TRUE, TRUE, TRUE, TRUE);

INSERT INTO products (product_name, category, brand, sell_price, discount, discount_price, quantity, image_url) VALUES
('Đồng Hồ Casio Nam MTP-1374L-1AVDF', 'Đồng hồ cơ', 'CASIO', 2270000, FALSE, 0, 0, '/img/products/anh1.jpg'),
('Đồng Hồ Casio Nam AE-1200WHD-1AVDF', 'Đồng hồ điện tử', 'CASIO', 1506000, FALSE, 0, 0, '/img/products/anh2.jpg'),
('Đồng Hồ Casio Nam MTP-VT01L-1BUDF', 'Đồng hồ cơ', 'CASIO', 1182000, FALSE, 0, 0, '/img/products/anh3.jpg'),
('Đồng Hồ Casio Nam MTP-1374D-1AVDF', 'Đồng hồ cơ', 'CASIO', 2394000, FALSE, 0, 0, '/img/products/anh4.jpg'),
('Đồng Hồ Orient Nam FAG00002W0', 'Đồng hồ cơ', 'ORIENT', 8690000, FALSE, 0, 0, '/img/products/anh5.jpg'),
('Đồng Hồ Orient Nam FAG02005W0', 'Đồng hồ cơ', 'ORIENT', 6790000, FALSE, 0, 0, '/img/products/anh6.jpg'),
('Đồng Hồ Casio Nam G-Shock DW-9052-1VDR', 'Đồng hồ điện tử', 'CASIO', 2746000, FALSE, 0, 0, '/img/products/anh7.jpg'),
('Đồng Hồ Casio Nam F-91WM-9ADF', 'Đồng hồ điện tử', 'CASIO', 623000, FALSE, 0, 0, '/img/products/anh8.jpg'),
('Apple Watch Series 9 GPS', 'Đồng hồ thông minh', 'APPLE', 9790000, FALSE, 0, 0, '/img/products/anh9.jpg'),
('Apple Watch Ultra 2 GPS + Cellular', 'Đồng hồ thông minh', 'APPLE', 20990000, FALSE, 0, 0, '/img/products/anh10.jpg'),
('Apple Watch Ultra 2 GPS + Titanium', 'Đồng hồ thông minh', 'APPLE', 21990000, FALSE, 0, 0, '/img/products/anh11.jpg'),
('Apple Watch Series 9 GPS + Cellular', 'Đồng hồ thông minh', 'APPLE', 19990000, FALSE, 0, 0, '/img/products/anh12.jpg'),
('Đồng Hồ Citizen Nam BE9180-52E', 'Đồng hồ cơ', 'CITIZEN', 3780000, FALSE, 0, 0, '/img/products/anh13.jpg'),
('Đồng Hồ Citizen Nam NH8390-03X', 'Đồng hồ cơ', 'CITIZEN', 8177000, FALSE, 0, 0, '/img/products/anh14.jpg'),
('Đồng Hồ Citizen Nam AU1062-56E', 'Đồng hồ cơ', 'CITIZEN', 7185000, FALSE, 0, 0, '/img/products/anh15.jpg');
    
INSERT INTO accounts (username, passwd, role_id) VALUES 
('trunghieu', '3122560017', 'ADM'),
('thaibao', '3122410014', 'ADM'),
('giahuy', '3122560025', 'SLR'),
('maudien', '3122560014', 'SLR'),
('khanhnhu', '3122410286', 'WHM'),
('thang_at_o', '12345678', 'CTM'),
('con_at_o', '12345678', 'CTM'),
('uaaiday1', '12345678', 'CTM'),
('duanaoday2', '12345678', 'CTM');

INSERT INTO employees (full_name, gender, date_of_birth, phone_number, address, account_id) VALUES 
('Bùi Trung Hiếu', 'Nam', '2004-05-04', '0123456789', '123 Main Street, City, Country', 1),
('Cao Thái Bảo', 'Nam', '2004-07-02', '0987654321', '456 Oak Avenue, City, Country', 2),
('Tô Gia Huy', 'Nam', '2004-07-31', '0555123456', '789 Elm Street, City, Country', 3),
('Trương Mậu Điền', 'Nam', '2004-05-03', '0777888999', '321 Pine Street, City, Country', 4),
('Trần Thị Khánh Như', 'Nữ', '2004-08-11', '0111222333', '654 Cedar Street, City, Country', 5);

INSERT INTO customers (full_name, gender, date_of_birth, phone_number, address, account_id) VALUES
('Emma Wilson', 'Nam', '1980-07-12', '0123123123', '1010 Maple Street, City, Country', 6),
('Olivia Garcia', 'Nữ', '1992-04-18', '0333666999', '1313 Oak Street, City, Country', 7),
('Ava Martinez', 'Nữ', '1987-10-30', '0666777888', '1515 Elm Street, City, Country', 8),
('Sarah Clark', 'Nữ', '1989-12-30', '0444555666', '987 Birch Street, City, Country', 9);

INSERT INTO suppliers (supplier_name, email, phone_number) VALUES 
('ABC Electronics', 'abc_electronics@example.com', '1234567890'),
('Green Energy Solutions', 'green_energy@example.com', '9876543210'),
('Fresh Farms Ltd.', 'fresh_farms@example.com', '5551234567'),
('Tech Innovations Inc.', 'tech_innovations@example.com', '7778889999'),
('Fashion Trends Corp.', 'fashion_trends@example.com', '1112223333'),
('Nature''s Best Foods', 'natures_best@example.com', '4445556666');

INSERT INTO product_supplier (product_id, supplier_id) VALUES 
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9, 1), (10, 1), (11, 1), (12, 1),
(7, 2), (8, 2), (9, 2), (10, 2), (11, 2), (12, 2), (13, 2), (14, 2), (15, 2),
(8, 3), (14, 3), (3, 3), (6, 3), (10, 3), (2, 3), (12, 3),
(2, 4), (4, 4), (6, 4), (8, 4), (10, 4), (11, 4), (15, 4),
(1, 5), (2, 5), (3, 5),
(4, 6), (6, 6), (9, 6), (7, 6); 


-- TEST QUERY --
-- Xem danh sách nhân viên - tài khoản - mật khẩu - ngày tạo - vai trò
use mywatchstore;
select e.full_name, a.username, a.passwd, a.created_date, r.role_name
from employees as e
join accounts as a on a.id = e.account_id
join roles as r on a.role_id = r.role_id;

-- Xem danh sách khách hàng - tài khoản - mật khẩu - địa chỉ - ngày sinh
select c.full_name, a.username, a.passwd, c.address, c.date_of_birth
from customers as c
join accounts as a on a.id = c.account_id;

-- Xem danh sách các sản phẩm của nhà cung cấp có thể cung cấp
select s.supplier_name, p.product_name
from products as p
join product_supplier as ps on ps.product_id = p.id
join suppliers as s on s.supplier_id = ps.supplier_id;

-- select r.role_name from roles as r join accounts as a on a.role_id = r.role_id where a.id = 2;

use mywatchstore;
select * from export_invoices;
SELECT * FROM accounts as a join customers as c on a.id = c.account_id;
SELECT * FROM accounts as a join employees as e on a.id = e.account_id;



