insert into Category(CAT_NAME) values('Sport');
insert into Category(CAT_NAME) values('Electronics');
insert into Category(CAT_NAME) values('Books');
insert into Category(CAT_NAME) values('Cosmetics');
insert into Category(CAT_NAME) values('Musical');
insert into Category(CAT_NAME) values('Cloths');
 
insert into Address(city,state,street,zipcode) values ('fairfield','IA','1000 N 4th',525);
insert into Address(city,state,street,zipcode) values ('Pitsburgh','PA','Beacon Hill',119);
insert into Address(city,state,street,zipcode) values ('Irving','Tx','501 N W Stone',787);

insert into RequestedCard(cardHolder,cardNum,cardType,expiration,purchaseAmount,securityCode)
values('Tek Ale', '12345678912345','Master','10/10/2018',2500,'213');

insert into VENDOR(OWNER_NAME,VENDOR_NAME,address_id,requestedCard_id,VENDOR_ID)
values('Tek Ale', 'Tek Company',1,1,1);

insert into Product(ProductID,ProductName,ProductPrice,ProductQuantity,category_CAT_ID,vendor_VENDOR_SN,lockNumber,maxPerCustomer)
values(1,'T-shirt',12,50,6,1,0,10);
insert into Product(ProductID,ProductName,ProductPrice,ProductQuantity,category_CAT_ID,vendor_VENDOR_SN,lockNumber,maxPerCustomer)
values(2,'Laptop',175,20,2,1,0,10);
insert into Product(ProductID,ProductName,ProductPrice,ProductQuantity,category_CAT_ID,vendor_VENDOR_SN,lockNumber,maxPerCustomer)
values(3,'Lakme',40,100,4,1,0,10);
  
insert into CREDENTIALS(username,password,enabled,verifyPassword)values('Jannatul','prg123',1,'prg123');
insert into CREDENTIALS(username,password,enabled,verifyPassword)values('Mihir','col123',1,'col123');
insert into CREDENTIALS(username,password,enabled,verifyPassword)values('Ahmad','row123',1,'row123');

insert into authority(authority,username)values('ROLE_USER','Jannatul');
insert into authority(authority,username)values('ROLE_USER','Mihir');
insert into authority(authority,username)values('ROLE_VENDOR','Tek');
  
insert into Customer(FIRSTNAME,LASTNAME,EMAIL,USERCREDENTIAL) values('Mihir','Palakurthi','mihir@gmail.com','Mihir');
insert into Customer(FIRSTNAME,LASTNAME,EMAIL,USERCREDENTIAL) values('Jannatul','Mou','jannatul@gmail.com','Jannatul');
insert into Customer(FIRSTNAME,LASTNAME,EMAIL,USERCREDENTIAL) values('Tek','Bahdur','tek@gmail.com','Ahmad'); 