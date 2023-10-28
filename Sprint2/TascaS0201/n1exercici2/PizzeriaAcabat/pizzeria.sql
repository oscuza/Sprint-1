DROP DATABASE IF EXISTS pizzeria;
CREATE DATABASE IF NOT EXISTS pizzeria DEFAULT CHARACTER SET utf8mb4;
USE pizzeria;

-- table province
CREATE TABLE IF NOT EXISTS Province (
    idProvince INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (idProvince)
)  ENGINE=INNODB;

-- insert provinces
INSERT INTO Province  VALUES (1,'Barcelona'),(2,'Lerida'),(3,'Gerona'),(4,'Tarragona');

-- table locality
CREATE TABLE IF NOT EXISTS Locality (
    idLocality INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (idLocality),
    fk_Province_IdProvince INT NOT NULL,
    FOREIGN KEY (fk_Province_IdProvince)
        REFERENCES Province (idProvince)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

-- insert locality
INSERT INTO Locality  VALUES (1,'Barcelona',1),
(2,'Badalona',1),
(3,'Tarrega',2),
(4,'Vallverd',2),
(5,'Amposta',4),
(6,'Cunit',4),
(7,'Begur',3),
(8,'Cadaques',3),
(9,'Esplugues',1),
(10,'Agramunt',2);

-- table customer
CREATE TABLE IF NOT EXISTS Customer (
    idCustomer INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    firstLastName VARCHAR(45),
    address VARCHAR(45),
    postalCode INT,
    phone INT,
    fk_Locality_idLocality INT NOT NULL,
    PRIMARY KEY (idCustomer),
    FOREIGN KEY (fk_Locality_idLocality)
        REFERENCES Locality (idLocality)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

-- insert customers into table customer
INSERT INTO Customer VALUES 
(1,	'Petey','Rawlinson','24 Mccormick Center',24357,204926477,2),
(2,'Nan','Hanbury','68 Summit',87567,92842889,3),
(3,'Raffarty','Covely','9 Briar Cresst Avenue',75549,51260462,1),
(4,'Willow','Maylin','25 Larry Drive',72564,31855997,4),
(5,'Myron','Kohring','78 Western avenue',98658,	53972375,1),
(6,'Genevra','Folca','67 Monica Point',96706,	71750965,1),
(7,'Holly','Alfonsetti','23 Hoard Plaza',89561,89270364,2),
(8,'Chadd','Airey','58 Spain street',98587,49519406,	4),
(9,'Timmie','Winthrop','158 ChinaTown',36985,83680989,	3),
(10,'Antonetta','Betjes','229 Street A',672563,25325651,1);

-- table store
CREATE TABLE IF NOT EXISTS Store (
    idStore INT NOT NULL AUTO_INCREMENT,
    address VARCHAR(45),
    postalCode INT,
    locality VARCHAR(45),
    province VARCHAR(45),
    PRIMARY KEY (idStore)
   )  ENGINE=INNODB;

-- insert store into table Store
INSERT INTO Store VALUES
(1,'5 Grantfather street',08901,'barcelona','Barcelona'),
(2,'25 Maroon street',08901,'badalona','Barcelona'),
(3,'289  avenue',08901,'cunit','Tarragona'),
(4,'123 sillycon street',08901,'vic','Gerona'),
(5,'78 picadilly street',08901,'Tarrega','Lerida'),
(6,'8 apple steet',08901,'Riells','Lerida'),
(7,'26 pink avenu',08901,'Camprodon','Gerona'),
(8,'9 long street',08901,'Calella','Gerona');

-- table employee
CREATE TABLE IF NOT EXISTS Employee (
    idEmployee INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25),
    firstLastName VARCHAR(45),
    nif VARCHAR(25),
    phone INT,
    typeEmployee ENUM('Chef', 'Delivery') NOT NULL,
    fk_Store_idStore INT,
    PRIMARY KEY (idEmployee),
    FOREIGN KEY (fk_Store_idStore)
        REFERENCES Store (idStore)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

-- insert employees in table Employye
INSERT INTO Employee VALUES
(1,'James','Bond','456987456n',654987456,'Chef',1),
(2,'Charles','Dodge','123456987l',123456789,'Delivery',2),
(3,'George','Lucas','564987213o',569874123,'Chef',4),
(4,'Mary','James','654236874k',528147369,'Delivery',1),
(5,'Angelina','Jules','264794269',321654852,'Delivery',8)
;

-- table deliveryHome (reparto domicilio)
CREATE TABLE IF NOT EXISTS DeliveryHome (
    idBuyHome INT NOT NULL AUTO_INCREMENT,
    regDate DATE,
    fk_Employee_idEmployee INT,
    PRIMARY KEY (idBuyHome),
    FOREIGN KEY (fk_Employee_idEmployee)
        REFERENCES Employee (idEmployee)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;


 -- eliminamos constraint   fk_Employee_idEmployee en tabla DeliveryHome
 -- ALTER TABLE DeliveryHome DROP CONSTRAINT deliveryhome_ibfk_1;
 
-- insert deliveryHome in table DeliveryHome
INSERT INTO DeliveryHome VALUES
(1,STR_TO_DATE('24-Apr-2005', '%d-%M-%Y'),2),
(2,STR_TO_DATE('24-Jun-2006', '%d-%M-%Y'),2),
(3,STR_TO_DATE('24-Aug-2008', '%d-%M-%Y'),4),
(4,STR_TO_DATE('24-Feb-2007', '%d-%M-%Y'),4),
(5,STR_TO_DATE('24-Aug-2005', '%d-%M-%Y'),5)
;

-- añadimos contraint fk_customer_recomendedCustomerId en tabla customer
--  ALTER TABLE customer ADD CONSTRAINT  fk_Employee_idEmployee FOREIGN KEY (fk_Employee_idEmployee) REFERENCES Employee (idEmployee) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE IF NOT EXISTS Category (
    idCategory INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25),
    PRIMARY KEY (idCategory)
)  ENGINE=INNODB;

-- insert categoris in Category
INSERT INTO Category  VALUES 
(1,'Fomarggio'),
(2,'Calçonne'),
(3,'Drinks'),
(4,'Hamburuers'),
(5,'desserts')
;

-- table CashOrder (pedido)
CREATE TABLE IF NOT EXISTS CashOrder (
    idOrder INT NOT NULL AUTO_INCREMENT,
    regDateTime DATETIME,
    inHome BOOLEAN,
    totalPrice DOUBLE,
    quantityProduct INT,
    PRIMARY KEY (idOrder),
    fk_Customer_idCustomer INT not null,
    fk_Store_idStore INT not null,
    fk_Employee_idEmployee INT not null,
    FOREIGN KEY (fk_Customer_idCustomer)
        REFERENCES Customer (idCustomer)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fk_Store_idStore)
        REFERENCES Store (idStore)
        ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (fk_Employee_idEmployee)
        REFERENCES Employee (idEmployee)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

-- insert orders in table CashOrder
INSERT INTO CashOrder VALUES
(1,STR_TO_DATE('24-Aug-2005', '%d-%M-%Y'),true,25,8,1,3,1),
(2,STR_TO_DATE('25-Aug-2005', '%d-%M-%Y'),true,39.1,8,9,5,2),
(3,STR_TO_DATE('25-Feb-2005', '%d-%M-%Y'),true,56.2,8,8,5,4),
(4,STR_TO_DATE('25-Jul-2005', '%d-%M-%Y'),true,18.7,8,7,7,3),
(6,STR_TO_DATE('25-Aug-2005', '%d-%M-%Y'),false,215.3,1,7,3,5),
(7,STR_TO_DATE('25-Oct-2005', '%d-%M-%Y'),false,14.5,6,7,3,2)
 ;

-- table product
CREATE TABLE IF NOT EXISTS Product (
    idProduct INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    description VARCHAR(45),
    image LONGBLOB,
    price DOUBLE,
    PRIMARY KEY (idProduct),
    fk_Category_idCategory INT,
    fk_CashOrder_idOrder INT,
    FOREIGN KEY (fk_Category_idCategory)
        REFERENCES Category (idCategory)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fk_CashOrder_idOrder)
        REFERENCES CashOrder (idOrder)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

-- insert orders in table Product
INSERT INTO Product  (name,description,price,fk_Category_idCategory,fk_CashOrder_idOrder) VALUES
('pizza margarita','pizza con muchos ingredientes',25,2,4),
('pizza formaggio','variedad de quesos',17.5,1,2),
('coca cola','bebida fria',3.5,3,6),
('coca cola','bebida fria',3.5,3,1),
('Sprite','bebida fria',2.5,3,1),
('Fanta','bebida fria',1.8,3,1),
('coca cola','bebida fria',3.5,3,6),
('hamburguerToro','Hamburgues gigante',15.2,4,7)
 ;