# jobrunr-jsonb-issue

```
$ ./gradlew build -Dquarkus.package.type=native -Dquarkus.container-image.build=true -Dquarkus.native.container-build=true -Dquarkus.jib.platforms=linux/arm64/v8
$ docker run --rm valentin_day/jobrunr-jsonb-issue:1.0.0-SNAPSHOT
```