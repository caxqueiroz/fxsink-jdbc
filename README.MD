## Introduction

This is a sink to jdbc module, spring cloud stream, which saves tick data into a RDBMS database. 


## To compile

```
$ mvn clean package
```

## To run

```
java -jar target/fxsink-1.0.0-MASTER.jar --spring.cloud.config.uri=<config server address>
```

Have a look at the  [config file example](fxsink-jdbc.yml)