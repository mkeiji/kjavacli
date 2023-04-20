# Spring Shell Demo
Simple CLI app built using [Spring Shell](https://spring.io/projects/spring-shell)

## Requirements
* java 17 
* GraalVM 22.3.0^
* Spring framework 3.0.5^

> suggestion: use `asdf install java graalvm-22.3.1+java17`

## Build
### Compile the app to `jar`
```
./gradlew bootJar
```
the file will be placed at `build/libs/demo-0.0.1-SNAPSHOT.jar`

## Run 
### Use java -jar and point to the compiled file 
```
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

## Compile Binary
### Needs GraalVM
```
./gradlew nativeCompile
```
the binary should be created under `build/native/nativeCompile/demo`

to run use:
```
./demo
```

## Commands for this demo app
### hello-world $1
where `$1` is an argument

Return `Hello world spring`
or
Return `Hello world ${argument}`

### getos
Return the HOST OS

### cmd
Execute a shell command.
eg:
```
cmd ls
```

> use quotes for commands with multiple words
eg:
```
cmd 'touch test.txt'
```
