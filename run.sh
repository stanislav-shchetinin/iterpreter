#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Usage: ./run.sh <program_file>"
    echo "Examples:"
    echo "  ./run.sh programs/fibonacci.lang"
    echo "  ./run.sh programs/gcd.lang"
    echo "  ./run.sh programs/types.lang"
    echo "  ./run.sh programs/test_simple.lang"
    exit 1
fi

PROGRAM_FILE=$1

if [ ! -f "$PROGRAM_FILE" ]; then
    echo "Error: File '$PROGRAM_FILE' not found!"
    exit 1
fi

echo "Compiling Lango interpreter..."
mvn clean compile
mvn package

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

echo "Running program: $PROGRAM_FILE"
echo "----------------------------------------"
java -jar target/lango-interpreter-1.0-SNAPSHOT.jar "$PROGRAM_FILE"
echo "----------------------------------------"
echo "Program finished." 
