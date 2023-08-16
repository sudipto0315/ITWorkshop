#!/bin/bash

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
read -p "Enter a filename: " filename

find_word_frequency "$filename"
