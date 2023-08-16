#!/bin/bash

# Function to rename a file
rename_file() {
  if [ -e "$1" ]; then
    read -p "Enter the new name for the file: " new_name

    # Use mv to rename the file
    mv "$1" "$new_name"

    echo "File '$1' has been renamed to '$new_name'."
  else
    echo "File '$1' does not exist."
  fi
}

# Main script starts here
read -p "Enter the current filename: " filename

rename_file "$filename"
