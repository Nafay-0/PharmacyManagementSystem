create table Cashier
(
    EmployeeID       int auto_increment
        primary key,
    EmployeeName     varchar(200) not null,
    EmployeeAddress  varchar(255) null,
    EmployeePhone    varchar(13)  null,
    EmployeePassword varchar(100) not null
);

create table Manager
(
    EmployeeID       int auto_increment
        primary key,
    EmployeeName     varchar(100) not null,
    EmplyeeAddress   varchar(100) null,
    EmployeePhone    varchar(14)  null,
    EmployeePassword varchar(30)  not null,
    constraint Manager_pk
        unique (EmployeeName)
);

create table Medicine
(
    MedicineId int auto_increment
        primary key,
    quantity   int default 0 not null
);

create table MedicineDescription
(
    MedicineId          int auto_increment
        primary key,
    MedicineName        varchar(100) not null,
    MedicineDescription varchar(255) null,
    Company             varchar(100) null,
    price               double       not null,
    constraint MedicineDescription_Medicine_null_fk
        foreign key (MedicineId) references Medicine (MedicineId)
);

create table Sale
(
    SaleId     int auto_increment
        primary key,
    TotalPrice double     not null,
    SaleDate   date       not null,
    SaleStatus tinyint(1) not null
);

create table Receipt
(
    ReceiptID int auto_increment
        primary key,
    SaleID    int not null,
    constraint Receipt_Sale_null_fk
        foreign key (SaleID) references Sale (SaleId)
);

create table SaleLineItem
(
    itemID     int auto_increment
        primary key,
    medicineID int    not null,
    quantity   int    not null,
    price      double not null,
    SaleId     int    null,
    constraint SaleLineItem_Medicine_null_fk
        foreign key (medicineID) references Medicine (MedicineId),
    constraint SaleLineItem_Sale_null_fk
        foreign key (SaleId) references Sale (SaleId)
);

create table Supplier
(
    SupplierId      int auto_increment
        primary key,
    SupplierName    varchar(200) not null,
    SupplierAddress varchar(200) null,
    SupplierPhone   varchar(13)  null,
    SupplierEmail   varchar(50)  not null
);

create table CompletedOrder
(
    OrderId    int auto_increment
        primary key,
    MedicineId int    not null,
    quantity   int    null,
    Date       date   null,
    SupplierId int    not null,
    totalCost  double null,
    constraint CompletedOrder_Medicine_null_fk
        foreign key (MedicineId) references Medicine (MedicineId),
    constraint CompletedOrder_Supplier_null_fk
        foreign key (SupplierId) references Supplier (SupplierId)
);

create table MedicineOrder
(
    OrderID    int auto_increment
        primary key,
    MedicineID int    not null,
    quantity   int    not null,
    Date       date   null,
    SupplierID int    not null,
    totalCost  double not null,
    constraint MedicineOrder_Medicine_null_fk
        foreign key (MedicineID) references Medicine (MedicineId),
    constraint MedicineOrder_Supplier_null_fk
        foreign key (SupplierID) references Supplier (SupplierId)
);

create table MedicineSuppliers
(
    MedicineId int not null,
    SupplierId int not null,
    primary key (SupplierId, MedicineId),
    constraint MedicineSuppliers_Medicine_null_fk
        foreign key (MedicineId) references Medicine (MedicineId),
    constraint MedicineSuppliers_Supplier_null_fk
        foreign key (SupplierId) references Supplier (SupplierId)
);

