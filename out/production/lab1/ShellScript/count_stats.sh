#!/bin/bash

# Function to check if the file exists, read its content, and count characters, words, and lines
count_characters_words_lines() {
  if [ -e "$1" ]; then
    echo "File '$1' exists. Here is its content:"
    cat "$1"
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
read -p "Enter a filename: " filename

count_characters_words_lines "$filename"
