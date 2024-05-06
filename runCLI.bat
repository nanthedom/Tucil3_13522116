@echo "compiling.."
javac -d bin -cp src;src/lib src/wordladder/*.java src/lib/*.java src/CLI/*.java
@echo "running.."
java -cp bin CLI.Main