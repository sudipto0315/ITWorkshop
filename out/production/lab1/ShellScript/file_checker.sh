#!/bin/bash

# Function to check if the file exists and display its content
check_file() {
  if [ -e "$1" ]; then
    echo "File '$1' exists. Here is its content:"
    cat "$1"
  else
    echo "File '$1' does not exist."
    echo "Creating a new file named '$1'."
    touch "$1"
  fi
}

# Main script starts here
read -p "Enter a filename: " filename

check_file "$filename"
