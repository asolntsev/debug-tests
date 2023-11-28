# Enable logging

### The problem
When running `./gradlew test`, you will see some red errors from SLF4J, like
> SLF4J: No SLF4J providers were found.

1. Resolve this problem.
2. (advanced) setup logging so that every log contains current time 
3. (advanced) enable DEBUG logs for "com.codeborne.selenide" package (for example) 

### Expected result:
1. You don't see any SLF4J errors in logs (e.g. "SLF4J: No SLF4J providers were found.")
2. You see Selenide logs instead (e.g. "Selenide v. 7.0.1")
3. (advanced) You see current time in each log message
4. (advanced) You see Selenide DEBUG logs