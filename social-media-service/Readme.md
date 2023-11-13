https://github.com/in28minutes/spring-microservices-v2/blob/main/02.restful-web-services/01-step-by-step-changes/v2.md#step-21

## Content Negotiation
- Different content Type (XML, JSON) via Accept header MIME Types (application/xml, application/json)
- Different Language (English, Dutch) via Accept-Language header (en, nl, fr, de)

- <dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  </dependency>

Add a Header called,
Accept: application/xml
(default is JSON)

POST http://localhost:8080/users
Accept : application/xml
Content-Type : application/xml

Request
<item>
<name>Ganga</name>
<birthDate>1980-07-19</birthDate>
</item>

## Internationalization - i18n
- HTTP Request Header -- Accept-Language: en (for English)
- Accept-Language: nl (for Dutch); fr - for French

- Create src/main/resources/messages.properties file

## Versioning
Variety of Options
1. URL - Twitter (v1, v2)  (/v2/person) - part of URI
2. Request Parameter - Amazon (/person?version=2) - code --> params = ""
3. Header - Microsoft (X-API-VERSION=2) - code --> headers = ""
4. Media Type - Github (using Accept headers: Accept: application/vnd.company.app-v2+json)  - code --> produces = ""

### Factors to Consider:
- URI Pollution
- Misuse of HTTP Headers
- Caching
- Can one execute request on the browser?
- API Documentation
- Summary: No Perfect solution.
- Think about versioning before it is needed. When starting the API design itself.
- One Enterprise - One versioning Approach.
- 

URLs
URI Versioning

V1: http://localhost:8080/v1/person

@GetMapping("/v1/person")

V2: http://localhost:8080/v2/person

@GetMapping("/v2/person")

Request Param Versioning

V1: http://localhost:8080/person?version=1

@GetMapping(path = "/person", params = "version=1")

V2: http://localhost:8080/person?version=2

@GetMapping(path = "/person", params = "version=2")

Header Versioning

V1: http://localhost:8080/person/header

HEADER - X-API-VERSION:1

@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")

V2: http://localhost:8080/person/header

HEADER - X-API-VERSION:2