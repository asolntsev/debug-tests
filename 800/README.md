# Dependency conflict

### The problem

When you run `mvn test`, the test fails.

The error looks like this:
> java.lang.NoClassDefFoundError: org/openqa/selenium/HasDownloads

You need to 
1. find out why it happens
2. fix the test