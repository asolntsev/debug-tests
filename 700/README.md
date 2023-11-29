# Slow startup of tests

### The problem
You need to generate PDF in tests.
When you run `./gradlew test`, you see that the first run takes ~4 seconds. Why so slow?

You need to 
1. find out why it happens
