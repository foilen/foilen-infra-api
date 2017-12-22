# About

This is the infra service API.

# Usage

## Dependency

You can see the latest version and the Maven and Gradle settings here:

https://bintray.com/foilen/maven/com.foilen:foilen-infra-api

## HTTPS Client

You need to create a json client configuration file that maps the object InfraApiUiConfigDetails.

A minimal file contains:

```
{
	"baseUrl" : "https://infra.example.com",
	"apiUser" : "xxxxxxx",
	"apiKey" : "xxxxxxx"
}
```

If you are using a certificate that is not in your Java trusts store, you can specify it in a file and give the path in *certFile* or put the certificate directly in *certText*. 

Once you created the file, you need to define the property "infraApi.configFile" with the path to the file.

Use the Spring Config class: *com.foilen.infra.api.InfraApiSpringConfig*. That will give you an *InfraApiService* bean.
