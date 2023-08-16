#!/bin/bash

# Function to compile a C source code file and move the executable to the bin directory
compile_c_file() {
  if [ -e "$1" ]; then
    # Extract the filename without the extension
    filename=$(basename "$1")
    filename_without_extension="${filename%.*}"

    # Compile the C source code using gcc and generate an executable
    gcc -o "$filename_without_extension" "$1"

    if [ $? -eq 0 ]; then
      echo "Compilation successful. Executable '$filename_without_extension' generated."

      # Move the executable to the bin directory
      mv "$filename_without_extension" "bin/"
    else
      echo "Compilation failed for '$1'."
    fi
  else
    echo "File '$1' does not exist."
  fi
}

# Main script starts here
read -p "Enter the directory name: " directory

# Create a 'bin' directory if it doesn't exist
mkdir -p "bin"

# Find all C files in the specified directory and its subdirectories
c_files=$(find "$directory" -type f -name "*.c")

# Compile each C file and move the executable to the 'bin' directory
for file in $c_files; do
  compile_c_file "$file"
done
