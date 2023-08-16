#!/bin/bash

# Function to check if the file exists and display its content
check_file() {
  if [ -e "$1" ]; then
    echo "File '$1' exists."
  else
    echo "File '$1' does not exist."
    echo "Creating a new file named '$1'."
    touch "$1"
  fi
}

# Main script starts here
echo "1.a ->"
read -p "Enter a filename to check its exists or not: " filename

check_file "$filename"

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
echo "1.b ->"
read -p "Enter a filename to it line by line: " filename

read_file_line_by_line "$filename"


# Function to check if the file exists, read its content, and count characters, words, and lines
count_characters_words_lines() {
  if [ -e "$1" ]; then
    echo "File '$1' exists."
    characters=$(wc -m < "$1")
    words=$(wc -w < "$1")
    lines=$(wc -l < "$1")
    echo "Total characters: $characters"
    echo "Total words: $words"
    echo "Total lines: $lines"
  else
    echo "File '$1' does not exist."
  fi
}

# Main script starts here
echo "1.c ->"
read -p "Enter a filename to count the total number of characters, words and line in file: " filename

count_characters_words_lines "$filename"


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
echo "1.d ->"
read -p "Enter a filename to display the content of the file in reverse: " filename

display_file_in_reverse "$filename"


# Function to find the frequency of a particular word in a file
find_word_frequency() {
  if [ -e "$1" ]; then
    echo "File '$1' exists."

    read -p "Enter the word to find its frequency: " word

    # Use grep to find the lines containing the word and then use wc to count the occurrences
    frequency=$(grep -o -w "$word" "$1" | wc -l)

    echo "The word '$word' appears $frequency times in the file."
  else
    echo "File '$1' does not exist."
  fi
}

# Main script starts here
echo "1.e ->"
read -p "Enter a filename to find the frequency of a particular word in a file: " filename

find_word_frequency "$filename"


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
echo "1.f ->"
echo "Renaming a file"
read -p "Enter the current filename: " filename

rename_file "$filename"


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
echo "1.g ->"
read -p "Enter the C source code filename: " c_file

compile_c_file "$c_file"


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
echo "1.h ->"
read -p "Enter the directory name: " directory

# Create a 'bin' directory if it doesn't exist
mkdir -p "bin"

# Find all C files in the specified directory and its subdirectories
c_files=$(find "$directory" -type f -name "*.c")

# Compile each C file and move the executable to the 'bin' directory
for file in $c_files; do
  compile_c_file "$file"
done
