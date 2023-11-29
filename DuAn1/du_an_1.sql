drop database qlBanCafe 
go

create database qlBanCafe
go 

use qlBanCafe
go



create table nhanVien(
maNV nvarchar(10) not null,
tenNV nvarchar(50) not null,
gioiTinh bit not null,
chucVu bit not null,
ngayVaoLam date not null,
diaChi nvarchar(150) not null,
soDT nvarchar(10) not null,
matKhau nvarchar(32) not null,
khuVuc nvarchar(150) not null
Constraint pk_nhanvien primary key (maNV)
)
create table loaiHang(
maLH nvarchar(10) not null,
tenLH nvarchar(50) not null,
moTa nvarchar(150),
Constraint pk_loaiHang primary key (maLH)
)

create table nhaCungCap(
maNCC nvarchar(10) not null,
tenNCC nvarchar(50) not null,
diaChi nvarchar(150) not null,
soDT nvarchar(10) not null,
Constraint pk_maNCC primary key (maNCC)
)

create table sanPham(
maSP nvarchar(10)  not null,
maNCC nvarchar(10) not null,
maLH nvarchar(10) not null,
tenSP nvarchar(50) not null,
hinhAnh nvarchar(50) not null,
giaSP float not null,
Constraint pk_sanPham primary key (maSP),
Constraint fk_sanpham_maLH foreign key (maLH) references loaiHang(maLH),
Constraint fk_sanPham_maNCC foreign key (maNCC) references nhaCungCap(maNCC)
)

create table loaiKhachHang(
maLKH nvarchar(10) not null,
tenLKH nvarchar(50) not null,
giamGia int,
Constraint pk_loaiKhachHang primary key (maLKH)
)

create table khachHang(
maKH nvarchar(10) not null,
maLKH nvarchar(10) not null,
tenKH nvarchar(50) not null,
diaChi nvarchar(150) not null,
soDT nvarchar(10) not null,
diemTL int,
Constraint pk_khachHang primary key (maKH),
Constraint fk_khachHang_maLKH foreign key (maLKH) references loaiKhachHang (maLKH)
)



create table hoaDon(
maHD nvarchar(10) not null,
maNV nvarchar(10) not null,
maKH nvarchar(10) not null,
ngayHD datetime not null,
tongTien int not null,
diemTL int not null,
giamGia int,
chiPhiKhac int ,
Constraint pk_hoaDon primary key (maHD),
Constraint fk_hoadon_maNV foreign key (maNV) references nhanVien (maNV),
Constraint fk_hoaDon_maKH foreign key (maKH) references khachHang (maKh)
)

create table caLamViec(
maCLV nvarchar(10) not null,
tenCLV nvarchar(10) not null,
khuVuc nvarchar(50) not null,
gioBD datetime not null,
gioKT datetime not null,
soTien int not null,

constraint pk_caLamViec primary key (maCLV)

)
create table chiTietCaLamViec(
	maNV nvarchar(10) not null,
	maCLV nvarchar(10) not null,
	tenNV nvarchar(50) not null,
	khuVuc nvarchar(150) not null,

	constraint pk_chiTietCaLamViec primary key(maNV,maCLV),
	constraint fk_chiTietCaLamViec_maNV foreign key (maNV) references nhanvien(maNV),
	constraint fk_chiTietCaLamViec_maCLV foreign key (maCLV) references caLamViec(maCLV)
)

create table chiTietLuongNhanVien(
maCLV nvarchar(10) not null,
maNV nvarchar(10) not null,
tongSoCaLam int not null,
thanhTien int not null,
kyLuong nvarchar(7),
Constraint pk_chiTietLuongNhanVien primary key (maCLV,maNV),
Constraint fk_chiTietLuongNhanVien_maNV foreign key (maNV) references nhanVien (maNV),
Constraint fk_chiTietLuongNhanVien_maCLV foreign key (maCLV) references caLamViec (maCLV)

)

create table chiTietBanHang(
maHD nvarchar(10) not null,
maSP nvarchar(10) not null,
soLuong int not null,
Constraint pk_chiTietBanHang primary key (maHD,maSP),
Constraint fk_chiTietBanHang_maHD foreign key (maHD) references hoaDon(maHD),
Constraint fk_chiTietBanHang_maSP foreign key (maSP) references sanPham(maSP)
)

create table hoaDonNhapHang(
maHDNH nvarchar(10) not null,
maNV nvarchar(10) not null,
ngayHDHH datetime not null,
Constraint pk_hoaDonNhapHang primary key (maHDNH),
Constraint fk_hoaDonNhapHang_maNV foreign key (maNV) references nhanVien(maNV)
)

create table chiTietNhapHang(
maSP nvarchar(10) not null,
maHDNH nvarchar(10) not null,
soLuong int not null,
tongTien int not null,
Constraint pk_chiTietNhapHang primary key (maSP,maHDNH),
Constraint fk_chiTietNhapHang_maSP foreign key (maSP) references sanPham (maSP),
Constraint fk_chiTietNhapHang_maHDNH foreign key (maHDNH) references hoaDonNhapHang(maHDNH)
)

create table diemDanh(
 maDiemDanh nvarchar(10) not null,
 maNV nvarchar(10) not null,
 soNgayLamViec int not null,
 constraint pk_diemDanh primary key (maDiemDanh),
 constraint fk_diemDanh_maNV foreign key (maNV) references nhanVien(maNV)
)

-- Bảng nhanVien
INSERT INTO nhanVien VALUES
('NV001', N'Nguyễn Văn A', 1, 1, '2023-01-01', N'123 Đường ABC, Quận Gò vấp, TP.HCM', '0123456789','123', N'Gò Vấp');
INSERT INTO nhanVien VALUES
('NV002', N'Trần Thị B', 0, 0, '2023-02-15', N'456 Đường XYZ, Quận 1, TP.HCM', '0987654321','123', N'Quận 1');
INSERT INTO nhanVien VALUES
('NV003', N'Lê Thị C', 0, 0, '2023-03-10', N'789 Đường LMN, Quận 2, TP.HCM', '0123456788','123', N'Quận 2');
INSERT INTO nhanVien VALUES
('NV004', N'Phan Văn D', 1, 0, '2023-04-05', N'888 Đường XYZ, Quận 3, TP.HCM', '0987654322','123', N'Quận 3');

-- Bảng loaiHang
INSERT INTO loaiHang VALUES
('LH001', N'Đồ uống', N'Mô tả về Đồ uống');
INSERT INTO loaiHang VALUES
('LH002', N'Đồ ăn vặt', N'Mô tả về đồ ăn vặt');


-- Bảng nhaCungCap
INSERT INTO nhaCungCap VALUES
('NCC001', N'Công ty A', N'789 Đường PQR, Quận 3, TP.HCM', '0123456789');
INSERT INTO nhaCungCap VALUES
('NCC002', N'Công ty B', N'101 Đường LMN, Quận 4, TP.HCM', '0987654321');
INSERT INTO nhaCungCap VALUES
('NCC003', N'Công ty C', N'999 Đường PQR, Quận 9, TP.HCM', '0123456787');
INSERT INTO nhaCungCap VALUES
('NCC004', N'Công ty D', N'123 Đường ABC, Quận 10, TP.HCM', '0987654323');

-- Bảng sanPham
INSERT INTO sanPham VALUES
('SP001', 'NCC001', 'LH001', N'Capochino', 'laptop.jpg', 15000000);
INSERT INTO sanPham VALUES
('SP002', 'NCC002', 'LH001', N'Bạc xỉu đá', 'banhmi.jpg', 10000);
INSERT INTO sanPham VALUES
('SP003', 'NCC003', 'LH002', N'Bánh ngọt', 'den.jpg', 500000);
INSERT INTO sanPham VALUES
('SP004', 'NCC004', 'LH001', N'cafe muối', 'aopolo.jpg', 200000);

-- Bảng loaiKhachHang
INSERT INTO loaiKhachHang VALUES
('LKH001', N'Khách hàng thường', 0);
INSERT INTO loaiKhachHang VALUES
('LKH002', N'Khách hàng VIP', 10);
INSERT INTO loaiKhachHang VALUES
('LKH003', N'Khách hàng mới', 5);
INSERT INTO loaiKhachHang VALUES
('LKH004', N'Khách hàng đặc biệt', 15);

-- Bảng khachHang
INSERT INTO khachHang VALUES
('KH001', 'LKH001', N'Nguyễn Công Dân', N'111 Đường UVW, Quận Gò Vấp, TP.HCM', '0123456789', 100);
INSERT INTO khachHang VALUES
('KH002', 'LKH002', N'Phạm Thị E', N'222 Đường XYZ, Quận 1, TP.HCM', '0987654321', 200);
INSERT INTO khachHang VALUES
('KH003', 'LKH003', N'Võ Văn F', N'333 Đường MNO, Quận 2, TP.HCM', '0123456787', 50);
INSERT INTO khachHang VALUES
('KH004', 'LKH004', N'Nguyễn Thị G', N'444 Đường PQR, Quận 3, TP.HCM', '0987654323', 300);


-- Bảng hoaDon
INSERT INTO hoaDon VALUES
('HD001', 'NV001', 'KH001', '2023-03-01', 500000, 10, 50, 20000);
INSERT INTO hoaDon VALUES
('HD002', 'NV002', 'KH002', '2023-03-02', 800000, 20, 30, 15000);
INSERT INTO hoaDon VALUES
('HD003', 'NV003', 'KH003', '2023-03-03', 1200000, 15, 20, 10000);
INSERT INTO hoaDon VALUES
('HD004', 'NV004', 'KH004', '2023-03-04', 1000000, 25, 40, 18000);

-- Bảng caLamViec
INSERT INTO caLamViec VALUES
('CLV001', N'Ca sáng', N'Khu vực 1', '2023-01-01 08:00:00', '2023-01-01 17:00:00', 100000);
INSERT INTO caLamViec VALUES
('CLV002', N'Ca chiều', N'Khu vực 2', '2023-01-02 13:00:00', '2023-01-02 21:00:00', 120000);
INSERT INTO caLamViec VALUES
('CLV003', N'Ca tối', N'Khu vực 3', '2023-01-03 18:00:00', '2023-01-03 22:00:00', 150000);


-- Bảng chiTietCaLamViec
INSERT INTO chiTietCaLamViec VALUES
('NV001', 'CLV001', N'Nguyễn Văn A', N'Khu vực 1');
INSERT INTO chiTietCaLamViec VALUES
('NV002', 'CLV002', N'Trần Thị B', N'Khu vực 2');
INSERT INTO chiTietCaLamViec VALUES
('NV003', 'CLV003', N'Lê Thị C', N'Khu vực 3');
INSERT INTO chiTietCaLamViec VALUES
('NV004', 'CLV003', N'Phan Văn D', N'Khu vực 4');

-- Bảng chiTietLuongNhanVien
INSERT INTO chiTietLuongNhanVien VALUES
('CLV001', 'NV001', 20, 2000000, N'Một');
INSERT INTO chiTietLuongNhanVien VALUES
('CLV002', 'NV002', 18, 1800000, N'Hai');
INSERT INTO chiTietLuongNhanVien VALUES
('CLV003', 'NV003', 22, 2200000, N'Ba');
INSERT INTO chiTietLuongNhanVien VALUES
('CLV003', 'NV004', 25, 2500000, N'Bốn');

-- Bảng chiTietBanHang
INSERT INTO chiTietBanHang VALUES
('HD001', 'SP001', 2);
INSERT INTO chiTietBanHang VALUES
('HD002', 'SP002', 5);
INSERT INTO chiTietBanHang VALUES
('HD003', 'SP003', 1);
INSERT INTO chiTietBanHang VALUES
('HD004', 'SP004', 3);

-- Bảng hoaDonNhapHang
INSERT INTO hoaDonNhapHang VALUES
('HDNH001', 'NV001', '2023-04-01');
INSERT INTO hoaDonNhapHang VALUES
('HDNH002', 'NV002', '2023-04-02');
INSERT INTO hoaDonNhapHang VALUES
('HDNH003', 'NV003', '2023-04-03');
INSERT INTO hoaDonNhapHang VALUES
('HDNH004', 'NV004', '2023-04-04');

-- Bảng chiTietNhapHang
INSERT INTO chiTietNhapHang VALUES
('SP001', 'HDNH001', 10, 5000000);
INSERT INTO chiTietNhapHang VALUES
('SP002', 'HDNH002', 20, 200000);	
INSERT INTO chiTietNhapHang VALUES
('SP003', 'HDNH003', 5, 1000000);
INSERT INTO chiTietNhapHang VALUES
('SP004', 'HDNH004', 8, 400000);

-- Bảng diemDanh
INSERT INTO diemDanh VALUES
('DD001', 'NV001', 25);
INSERT INTO diemDanh VALUES
('DD002', 'NV002', 22);
INSERT INTO diemDanh VALUES
('DD003', 'NV003', 20);
INSERT INTO diemDanh VALUES
('DD004', 'NV004', 23);
--select maNV , matkhau from nhanVien
--select * from nhanVien
--select * from loaiHang
--select * from nhaCungCap
--select * from sanPham
--select * from khachHang
--select * from loaiKhachHang
--select * from hoaDon
--select * from caLamViec
--select * from chiTietCaLamViec
--select * from chiTietLuongNhanVien
--select * from chiTietBanHang
--select * from hoaDonNhapHang
--select * from chiTietNhapHang
--select * from diemDanh