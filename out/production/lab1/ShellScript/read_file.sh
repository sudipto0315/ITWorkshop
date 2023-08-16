#!/bin/bash

# Function to check if the file exists and read its content line by line
read_file_line_by_line() {
  if [ -e "$1" ]; then
    echo "File '$1' exists. Here is its content:"
    while IFS= read -r line; do
      echo "$line"
    done < "$1"
  else
    echo "File '$1' does not exist."
    read -p "Do you want to create a new file with this name? (y/n): " choice
    if [ "$choice" = "y" ] || [ "$choice" = "Y" ]; then
      touch "$1"
      echo "New file '$1' created."
    else
      echo "Exiting the script without creating a new file."
    fi
  fi
}

# Main script starts here
read -p "Enter a filename: " filename

read_file_line_by_line "$filename"
