@echo off
javac -d bin -cp src src/wordladder/*.java src/lib/*.java src/interfaces/*.java 
java -cp bin interfaces.Main  