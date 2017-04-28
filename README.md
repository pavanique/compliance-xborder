# compliance-xborder

### Running and accessing application
`mvn clean install`
`java -jar target/compliance-xborder-0.0.1-SNAPSHOT.jar`

point your browser http://localhost:8080/xborder

### H2 Console
H2 Console is enabled in dev environment for development at the below location

http://localhost:8080/xborder/h2console/login.do

### Swagger URL
http://localhost:8080/xborder/swagger-ui.html

#### Notes to share
To search for document, please look into `policy-document-controller : Policy Document Controller` in Swagger
GET /policy/country/{countryISO}

To Lookup for countries `references-controller : References Controller ` in swagger
GET /reference/values/countries

For categories
GET /reference/values/policyType/{countryISO}
