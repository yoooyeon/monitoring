## Spring Actuator, Prometheus, Grafana

### Spring Actuator

스프링 프레임워크의 라이브러리 중 하나로 스프링부트 애플리케이션을 모니터링하고 관리할 수 있다.

`@Timed`, `@Gauge`, `@Counter` 을 활용해서 다양한 Metric을 커스텀하여 수집 가능하다. 

`@Timed`: 메서드 실행 시간을 측정하여 메서드의 평균 실행시간, 최소 실행시간 등 추적이 가능하다. 

`@Gauge`: 애플리케이션의 메모리 사용량, 스레드 수 등을 측정하여 모니터링 할 수 있다.

`@Counter`: 특정 이벤트가 발생한 횟수를 측정하여 추적한다. 비즈니스 로직에 맞게 커스텀하여 지표를 수집할 수 있다.


1. build.gradle에 디펜던시 추가하기
  ```groovy
      implementation 'org.springframework.boot:spring-boot-starter-actuator' 
  ```

2. 외부 설정(application.yml)에 노출할 endpoint 등 설정하기
```yml
management:
  endpoint:
    health:
      show-details: always
  endpoints:

    web:
      exposure:
        include: "*"
        exclude: "env, beans"
logging:
  level:
    hello.controller: debug
server:
  tomcat:
    mbeanregistry:
      enabled: true
```

3. 결과 확인 (http://localhost:8081/actuator)

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



### Prometheus
프로메테우스는 모니터링 관련 데이터의 데이터베이스 역할을 한다. 

1. 다운로드 및 설치
2. build.gradle에 다음 디펜던시 추가
  ```groovy
      implementation 'io.micrometer:micrometer-registry-prometheus' 
  ```
3. 애플리케이션을 실행한다.
4. prometheus.yml 작성
  ```yml
 global:
  scrape_interval: 15s
  evaluation_interval: 15s
alerting:
  alertmanagers:
    - static_configs:
        - targets:
  # - alertmanager:9093
rule_files:
scrape_configs:
  - job_name: "prometheus"
    static_configs:
      - targets: [ "localhost:9090" ]
  
  - job_name: "spring-actuator"
    metrics_path: '/actuator/prometheus'
    scrape_interval: 1s
    static_configs:
      - targets: [ 'localhost:8081' ]
  ```
5. 기본 포트는 9090으로 서버를 실행하고 http://localhost:9090/targets 로 들어가서 확인할 수 있다. 
![image](https://user-images.githubusercontent.com/89332391/229053295-1a093d40-6daf-4afd-b34d-e24fec1ca27d.png)

### Grafana
그라파나는 프로메테우스에서 가져온 데이터를 모니터링 해주는 오픈소스이다. 
프로메테우스 이외에도 AWS의 클라우드 워치 등 다른 데이터 소스를 지원한다. 
프로메테우스를 데이터 소스로 할 경우 `PromQL`이라는 문법을 사용한다. 
1. 다운로드 및 설치
2. 애플리케이션, 프로메테우스 실행
3. grafana-server.exe 실행
4. 3000 포트로 들어가 데이터 소스 설정 및 대시보드 생성
5. https://grafana.com/grafana/dashboards/ 다음 사이트에서 대시보드를 불러올 수 있음
![image](https://user-images.githubusercontent.com/89332391/229054925-e6c81c3f-85fc-4d3c-9b07-ea1f756cf7ca.png)

