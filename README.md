# Currency_Converter
* [Technological Stack](#technological-stack)
* [Endpoints](#endpoints)

## Technological Stack
### Back-End
* Java (11)
* Spring-Boot
* Spring-Data-JPA
  - Hibernate
* Spring-Web

### Data Base
* PostgreSQL

### Build Tools
* Maven
* Docker

## Endpoints

### Available Currencies
* PLN
* EUR
* USD
* AUD
* GBP

Sell currency -> 
``` 
/api/sell?value=3&fromCode=PLN&toCode=AUD
```
Returns the calculated value of selling a currency.


Purchase Currency ->
```
api/Purchase?value=3&fromCode=PLN&toCode=AUD
```
Returns the calculated purchase value of a currency.


Purchase Currency ->
```
api/all
```
Returns all available currencies 
