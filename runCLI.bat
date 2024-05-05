@echo off
javac -d bin -cp src;src/lib src/wordladder/*.java src/lib/*.java src/CLI/*.java
java -cp bin CLI.Main