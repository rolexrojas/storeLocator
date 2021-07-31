FORMAT: 1A

*note: * <>

#storeLocator

This document describes the backend service interface available.

Notes to be aware of:
* This is a Restful JSON API web-service, which conforms to the constraints and characteristic of the Rest architectural style and uses JSON as its data representational format.

## getUserCurrentLocation [/storeLocator/{latitude}/{longitude}]

This endpoint receives two String parameters {latitude} and {longitude}
this parameters represent de coordinates of the current location of the user.

This endpoint will evaluate and transform de input coordinates, then will query the H2 in memory database to
find top 5 stores that are near the given location.

If everything goes well it should return a http status ok (200) with the payload below:


+ request 
*/storeLocator/19.3062315/-69.5457977* [GET]

+ Response 200 (json)
```
[
{
"city": "Aardenburg",
"postalCode": null,
"street": null,
"street2": null,
"street3": null,
"addressName": "Jumbo Aardenburg Ingels",
"uuid": null,
"longitude": 3.444601,
"latitude": 51.275006,
"complexNumber": 0,
"showWarningMessage": false,
"todayOpen": null,
"locationType": null,
"collectionPoint": false,
"sapStoreID": 0,
"todayClose": null
},
{
"city": "Breskens",
"postalCode": null,
"street": null,
"street2": null,
"street3": null,
"addressName": "Jumbo Breskens Burg. van Zuyenstraat",
"uuid": null,
"longitude": 3.548912,
"latitude": 51.395932,
"complexNumber": 0,
"showWarningMessage": false,
"todayOpen": null,
"locationType": null,
"collectionPoint": false,
"sapStoreID": 0,
"todayClose": null
},
{
"city": "Middelburg",
"postalCode": null,
"street": null,
"street2": null,
"street3": null,
"addressName": "Jumbo Middelburg Sir W. Churchilllaan",
"uuid": null,
"longitude": 3.612508,
"latitude": 51.509157,
"complexNumber": 0,
"showWarningMessage": false,
"todayOpen": null,
"locationType": null,
"collectionPoint": false,
"sapStoreID": 0,
"todayClose": null
},
{
"city": "Vlissingen",
"postalCode": null,
"street": null,
"street2": null,
"street3": null,
"addressName": "Jumbo Vlissingen Hermesweg",
"uuid": null,
"longitude": 3.586242,
"latitude": 51.453082,
"complexNumber": 0,
"showWarningMessage": false,
"todayOpen": null,
"locationType": null,
"collectionPoint": false,
"sapStoreID": 0,
"todayClose": null
},
{
"city": "Oost-Souburg",
"postalCode": null,
"street": null,
"street2": null,
"street3": null,
"addressName": "Jumbo Oost-Souburg Oranjeplein",
"uuid": null,
"longitude": 3.604443,
"latitude": 51.465257,
"complexNumber": 0,
"showWarningMessage": false,
"todayOpen": null,
"locationType": null,
"collectionPoint": false,
"sapStoreID": 0,
"todayClose": null
}
]
```

#Database creator

EveryTime the applications runs the inMemory databse h2 runs and self configured to execute the 
data.sql file located in path [src/main/resources] this file creates the database structure.

#InitialDataLoader

Once Database is in memory and application runs the Command line runner interface executes a process
to read a json file located in path [src/main/resources] folder, then exectues a data mapping using the
jackson library and populates the database with the 587 stores locations contained in the file.

+ Sample data

"stores" [ {
          "city":"Zwolle",
          "postalCode":"8031 HR",
          "street":"Bachplein",
          "street2":"14",
          "street3":"",
          "addressName":"Jumbo Zwolle Groeneveld",
          "uuid":"WXIKYx4XBRYAAAFIIgoYwKxK",
          "longitude":"6.082377",
          "latitude":"52.526612",
          "complexNumber":"33233",
          "showWarningMessage":true,
          "todayOpen":"08:00",
          "locationType":"Supermarkt",
          "sapStoreID":"3589",
          "todayClose":"21:00"
       }]