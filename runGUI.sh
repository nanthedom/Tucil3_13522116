if [ -z "$DISPLAY" ]; then
    echo "Setting DISPLAY to :0.0"
    export DISPLAY=:0.0
fi
echo "compiling.."
javac -d bin -cp src:src/lib src/wordladder/*.java src/lib/*.java src/interfaces/*.java
echo "running.."
java -cp bin interfaces.Main
