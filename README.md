## Spring Actuator, Prometheus, Grafana

### Spring Actuator
```json
{
  "_links": {
    "self": {
      "href": "http://localhost:8081/actuator",
      "templated": false
    },
    "caches-cache": {
      "href": "http://localhost:8081/actuator/caches/{cache}",
      "templated": true
    },
    "caches": {
      "href": "http://localhost:8081/actuator/caches",
      "templated": false
    },
    "health": {
      "href": "http://localhost:8081/actuator/health",
      "templated": false
    },
    "health-path": {
      "href": "http://localhost:8081/actuator/health/{*path}",
      "templated": true
    },
    "info": {
      "href": "http://localhost:8081/actuator/info",
      "templated": false
    },
    "conditions": {
      "href": "http://localhost:8081/actuator/conditions",
      "templated": false
    },
    "configprops": {
      "href": "http://localhost:8081/actuator/configprops",
      "templated": false
    },
    "configprops-prefix": {
      "href": "http://localhost:8081/actuator/configprops/{prefix}",
      "templated": true
    },
    "loggers": {
      "href": "http://localhost:8081/actuator/loggers",
      "templated": false
    },
    "loggers-name": {
      "href": "http://localhost:8081/actuator/loggers/{name}",
      "templated": true
    },
    "heapdump": {
      "href": "http://localhost:8081/actuator/heapdump",
      "templated": false
    },
    "threaddump": {
      "href": "http://localhost:8081/actuator/threaddump",
      "templated": false
    },
    "prometheus": {
      "href": "http://localhost:8081/actuator/prometheus",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://localhost:8081/actuator/metrics/{requiredMetricName}",
      "templated": true
    },
    "metrics": {
      "href": "http://localhost:8081/actuator/metrics",
      "templated": false
    },
    "scheduledtasks": {
      "href": "http://localhost:8081/actuator/scheduledtasks",
      "templated": false
    },
    "httpexchanges": {
      "href": "http://localhost:8081/actuator/httpexchanges",
      "templated": false
    },
    "mappings": {
      "href": "http://localhost:8081/actuator/mappings",
      "templated": false
    }
  }
}
```

### Grafana
![image](https://user-images.githubusercontent.com/89332391/229054925-e6c81c3f-85fc-4d3c-9b07-ea1f756cf7ca.png)


### Prometheus
![image](https://user-images.githubusercontent.com/89332391/229053295-1a093d40-6daf-4afd-b34d-e24fec1ca27d.png)
