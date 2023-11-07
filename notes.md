# URLs


- http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR

- http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/CURRENCY-CONVERSION/currency-conversion-feign/from/USD/to/INR/quantity/10



Lower Case

- http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10



Custom Routes

- http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10


## Base: (also with 8080) -- Exchange

- http://localhost:8081/currency-exchange/from/USD/to/INR

- http://localhost:8081/currency-exchange/from/EUR/to/INR

- http://localhost:8081/currency-exchange/from/CAD/to/INR

- For failure http://localhost:8081/currency-exchange/from/AUD/to/INR

## Base at 8050 -- Conversion

- http://localhost:8050/currency-conversion/from/EUR/to/INR/quantity/10

- http://localhost:8050/currency-conversion-rest-template/from/EUR/to/INR/quantity/10

- http://localhost:8050/currency-conversion-feign/from/EUR/to/INR/quantity/10

## EUREKA server at 8761

- http://localhost:8761/

## API Gateway at 8765

- http://localhost:8765/actuator/health

## Initial with Gateway Discovery:

- http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/EUR/to/INR

- http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-conversion/from/EUR/to/INR/quantity/10

- http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-conversion-rest-template/from/EUR/to/INR/quantity/10

- http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-conversion-feign/from/EUR/to/INR/quantity/10

## Small Case URLs with Gateway Discovery:

- http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion-service/currency-conversion/from/EUR/to/INR/quantity/11

- http://localhost:8765/currency-conversion-service/currency-conversion-rest-template/from/EUR/to/INR/quantity/11

- http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/EUR/to/INR/quantity/11

## With Routes in Configuration Bean - URLs with Gateway Discovery - with application.properties for Gateway commented out:

- http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/EUR/to/INR/quantity/12

- http://localhost:8765/currency-conversion-rest-template/from/EUR/to/INR/quantity/12

- http://localhost:8765/currency-conversion-feign/from/EUR/to/INR/quantity/12

- For new URL rewrite http://localhost:8765/currency-conversion-new/from/EUR/to/INR/quantity/12

