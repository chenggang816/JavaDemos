@echo on
javac -cp ../lib/junit.jar *.java
if not errorlevel 1 java -cp .;../lib/junit.jar junitawtui.TestRunner StudentTest