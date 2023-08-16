#!/bin/bash

# Function to check if the file exists, display its content in reverse
display_file_in_reverse() {
  if [ -e "$1" ]; then
    echo "File '$1' exists. Here is its content in reverse:"
    tac "$1"
  else
    echo "File '$1' does not exist."
  fi
}

# Main script starts here
read -p "Enter a filename: " filename

display_file_in_reverse "$filename"
