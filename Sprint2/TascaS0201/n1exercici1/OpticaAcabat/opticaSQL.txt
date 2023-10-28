DROP schema IF EXISTS `cul_ampolla`;
CREATE SCHEMA IF NOT EXISTS `cul_ampolla` DEFAULT CHARACTER SET utf8mb4; 
USE `cul_ampolla`;

-- table Address --
CREATE TABLE IF NOT EXISTS `address`(
  `idAddress` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45),
  `number` INT,
  `floor` INT,
  `city` VARCHAR(45),
  `postalCode` INT,
  `country` VARCHAR(45),
  PRIMARY KEY (`idAddress`))
  ENGINE = InnoDB;
  
-- table supplier (proveedor)--
CREATE TABLE IF NOT EXISTS `supplier`(
  `idSupplier` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `fk_Address_idAddress` INT NOT NULL,
  `phone` VARCHAR(45) NULL,
  `fax` VARCHAR(45) NULL,
  `nif` VARCHAR(45) NULL,
  PRIMARY KEY (`idSupplier`),
  CONSTRAINT `fk_Address_idAddress` FOREIGN KEY (`fk_Address_idAddress`)
  REFERENCES `address` (`idAddress`) ON DELETE CASCADE ON UPDATE CASCADE
  )
  ENGINE = InnoDB;
  
    
  -- TABLE glasses (gafas)--
  CREATE TABLE IF NOT EXISTS `glasses`(
  `glassesId`INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `graduation`DOUBLE,
  `typeFrame` ENUM('rimless', 'plastic', 'metal') NOT NULL,
  `colorFrame` VARCHAR(45),-- color montura--
  `colorLens` VARCHAR(45), -- color cristal--
  `price` DOUBLE,
  `fk_supplierId` INT NOT NULL,
  PRIMARY KEY (`glassesId`),
  CONSTRAINT `fk_supplierId` FOREIGN KEY (`fk_supplierId`) REFERENCES `supplier` (`idsupplier`) ON DELETE CASCADE ON UPDATE CASCADE
  )
  ENGINE=InnoDB;
  
  -- TABLE customer (cliente)--
  CREATE TABLE IF NOT EXISTS `customer`(
  `customerId`INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `postOffice` INT,
  `phone` INT,
  `email` VARCHAR(45),
  `registrationDate` DATE,
  `employeeSale` VARCHAR(25),
  `fk_glasses_glassesId` INT NOT NULL,
  `fk_customer_recomendedCustomerId`INT,
   PRIMARY KEY (`customerId`),
   CONSTRAINT `fk_glasses_glassesId` FOREIGN KEY (`fk_glasses_glassesId`) REFERENCES `glasses` (`glassesId`) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT `fk_customer_recomendedCustomerId` FOREIGN KEY (`fk_customer_recomendedCustomerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
  )
  ENGINE=InnoDB;
  
   ALTER TABLE supplier DROP CONSTRAINT fk_Address_idAddress;
   
  -- insert values in table supplier(proveedores)---
 INSERT INTO supplier (name, fk_Address_idAddress, phone, fax, nif)
  VALUES ('nike',1,'63569874','4006', '44182555m'),
         ('adidas',2,'963852741','4006', '44258269n'),
         ('chicchic',3,'333666888', '3025', '88956532b'),
         ('optica universitaria',5,'333555777', '2582', '22365987g'),
         ('general optica',4, '333444777', '3696', '123456789j'),
         ('optica urgell',2, '333999888', '9898', '32165895b');
         
   ALTER TABLE supplier ADD CONSTRAINT `fk_Address_idAddress` FOREIGN KEY (`fk_Address_idAddress`) REFERENCES `supplier` (`idSupplier`) ON DELETE CASCADE ON UPDATE CASCADE;
  
  -- insert values in table  address --
  INSERT INTO address VALUES
  (1,'James Street',4,2,'liverpool',08963,'United Kingdon'),
  (2,'Balmes',122,3,'Barcelona',965826,'Spain'),
  (3,'Paseo Miramar',44,9,'Alcorcon',1122658,'Madrid'),
  (4,'Gran avenue',466,21,'Michigan',25639874,'United States of Ameria'),
  (5,'Av Republique',251,17,'Paris',253987,'France'),
  (6,'Av Paralelo',8,2,'Vic',08963,'Spain');
  
  
 -- insert values in table glasses---
  INSERT INTO glasses (brand, graduation, typeFrame, colorFrame,colorLens, price,fk_supplierId)
  VALUES ('amporio', 2.1, 'plastic', 'red', 'black',120,5),
         ('rayban', 3.8, 'metal', 'green', 'black',160,1),
         ('okley', 3.3, 'rimless', 'yellow', 'yellow',220,1),
         ('oxford',1.6, 'metal', 'black', 'yellow',350,3),
         ('decathlon', 0.8, 'metal', 'black', 'white',300,4),
         ('calvinckley', 0.5, 'plastic', 'white', 'white',180,2),
		 ('rayban', 2.5, 'metal', 'black', 'white',200,6);


   -- ayuda contraints--------------------------
   -- ALTER TABLE TABLENAME  drop CONSTRAINT FK_CONSTRAINTNAME;
   -- ALTER TABLE TABLENAME ADD CONSTRAINT FK_CONSTRAINTNAME FOREIGN KEY (FId)
   -- REFERENCES OTHERTABLE (Id) ON DELETE CASCADE ON UPDATE NO ACTION;
   -- --------------------------------------------
         
         
 -- eliminamos constraint   fk_customer_recomendedCustomerId en tabla customer
 ALTER TABLE customer DROP CONSTRAINT fk_customer_recomendedCustomerId;
         
         
      -- insert values in table customer(clientes)---
  INSERT INTO customer (name, postOffice, phone, email,registrationDate, employeeSale,fk_glasses_glassesId,fk_customer_recomendedCustomerId)
  VALUES ('oscar cuevas', 08901, 933385465, 'oscuza@gmail.net',STR_TO_DATE('24-May-2005', '%d-%M-%Y'), 'Albert Castella',1,2),
         ('albert perez', 08901, 933385465, 'oscuza@gmail.net', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),'Albert Castella',3,null),
	     ('carlos gamboa', 08901, 933385465, 'oscuza@gmail.net', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),'Albert Castella',2,4),
	     ('bob marley', 08901, 933385465, 'oscuza@gmail.net', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),'Albert Castella',6,1),
	     ('lucas film', 08901, 933385465, 'oscuza@gmail.net', STR_TO_DATE('24-May-2005', '%d-%M-%Y'),'Albert Castella',1,1),
         ('george clooney', 08901, 933385465, 'oscuza@gmail.net',STR_TO_DATE('24-May-2005', '%d-%M-%Y'), 'Albert Castella',5,3),
	     ('james deen', 08901, 933385465, 'oscuza@gmail.net',STR_TO_DATE('24-May-2005', '%d-%M-%Y'), 'Albert Castella',4,2);    
         
 -- añadimos contraint fk_customer_recomendedCustomerId en tabla customer
 ALTER TABLE customer ADD CONSTRAINT `fk_customer_recomendedCustomerId` FOREIGN KEY (`fk_customer_recomendedCustomerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE