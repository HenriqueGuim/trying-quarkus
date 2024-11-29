## How to run locally?
```bash
  mvn quarkus:dev
  # or if quarkus cli is installed
  quarkus dev
```
in intellij you can run throw the Maven side bar on  Plugins->quarkus->quarkus:dev

## How to compile a native image?
Before compiling a native image, you need to have GraalVM installed and configured. You can install it using SDKMAN.
```bash
  quarkus build --native --no-tests -Dquarkus.native.container-build=true
  # The --no-tests flag is required only on Windows and macOS.
  #or
  mvn install -Dnative -DskipTests -Dquarkus.native.container-build=true
```

## How to run a native image locally?

Before running a native image, you need to verify that the file target/sam.native.yaml is properly configured to run the native image.
The file generated has the Runtime property outdated, you need to change it to "provided.al2" at the moment of writing this already exist another one "provided.al2023" but doesn't perform so well on cold starts.

If you are compiling on an arm64 chip you must change the architecture to arm64 in the sam.native.yaml file by adding the following property under Properties:
```yaml
    Architectures:
      - arm64
```

```bash
  sam local start-api --template target/sam.native.yaml
```

## How to deploy to AWS?

```bash
  sam deploy -t target/sam.native.yaml -g
```


### Sources:
- https://quarkus.io/guides/aws-lambda-http
- https://aosolorzano.medium.com/integration-testing-using-quarkus-junit-5-and-testcontainers-d72ac275a2f6 Integration Tests Info
