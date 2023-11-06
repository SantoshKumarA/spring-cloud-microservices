# currency-conversion-service
Currency Conversion Service project using Spring Boot - 03.Nov.2023

Using https://start.spring.io/ for generating the dependencies.

# Usage
URL: http://localhost:8050/currency-conversion/from/USD/to/INR/quantity/10

Sample Response:
```json
{
"codeId": 1001,
"codeFrom": "USD",
"codeTo": "INR",
"conversionRate": 65,
"serviceName": "currency-conversion-service",
"quantity": 10,
"totalConvertedAmount": 650
}
```

Other URLs:

Based on Rest Template microservice client invocation by hard coding the URL: 
http://localhost:8050/currency-conversion-rest-template/from/USD/to/INR/quantity/10

Feign Rest Client with hard coded URLs:
http://localhost:8050/currency-conversion-feign/from/USD/to/INR/quantity/10
