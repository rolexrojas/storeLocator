DROP TABLE IF EXISTS store_location;

CREATE TABLE store_location (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  city VARCHAR(250),
  street VARCHAR(250),
  street2 VARCHAR(250),
  street3 VARCHAR(250),
  addressName VARCHAR(250),
  uuid VARCHAR(250),
  latitude DECIMAL (8,6),
  longitude DECIMAL(9,6),
  complexNumber INTEGER ,
  showWarningMessage BIT,
  todayOpen VARCHAR(250),
  locationType VARCHAR(250),
  collectionPoint BIT,
  sapStoreID INTEGER,
  todayClose VARCHAR(250)
);

/*INSERT INTO store_location (city, street, street2, street3, addressName, uuid, latitude, longitude, complexNumber, showWarningMessage, todayOpen, locationType, collectionPoint, sapStoreID, todayClose) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)

*/
/*
private String city; //:"Aalst",
    private String postalCode; //:"5582 CL",
    private String street; //:"Hortensialaan",
    private String street2; //:"2",
    private String street3; //:"",
    private String addressName; //:"Jumbo Aalst Paul en Marjon Houben",
    private String uuid; //:"Tk0KYx4XZ3YAAAFc_DRE1DKo",
    private Double longitude; //:"5.469597",
    private Double latitude; //:"51.399843",
    private int complexNumber; //:"33011",
    private boolean showWarningMessage; //:true,
    private String todayOpen; //:"08:00",
    private String locationType; //:"SupermarktPuP",
    private boolean collectionPoint; //:true,
    private int sapStoreID; //:"3754",
    private String todayClose; //:"20:00"

*/