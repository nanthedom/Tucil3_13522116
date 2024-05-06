@echo "compiling.."
javac -d bin -cp src src/wordladder/*.java src/lib/*.java src/interfaces/*.java 
@echo "running.."
java -cp bin interfaces.Main  