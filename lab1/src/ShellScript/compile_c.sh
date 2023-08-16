#!/bin/bash

# Function to compile a C source code file and generate an executable
compile_c_file() {
  if [ -e "$1" ]; then
    # Extract the filename without the extension
    filename=$(basename "$1")
    filename_without_extension="${filename%.*}"

    # Compile the C source code using gcc and generate an executable
    gcc -o "$filename_without_extension" "$1"

    if [ $? -eq 0 ]; then
      echo "Compilation successful. Executable '$filename_without_extension' generated."
    else
      echo "Compilation failed."
    fi
  else
    echo "File '$1' does not exist."
  fi
}

# Main script starts here
read -p "Enter the C source code filename: " c_file

compile_c_file "$c_file"
