# Book Class Documentation

## Overview
The `Book` class is a subclass of `Text` that models a Book object. It extends the `Text` class with additional properties specific to books, such as ISBN and author.

## Class Details
- **Author**: Alec Jang
- **Version**: 0.1
- **Creation Date**: February 17, 2022
- **Last Modified**: February 20, 2022

## Properties
- `ISBN`: long - The International Standard Book Number
- `author`: String - The name of the book's author

## Constructors

### Default Constructor
- Calls the super default constructor
- Initializes `ISBN` to -1 and `author` to null

### Parameterized Constructor
- Parameters:
  - `callNum`: String - Call number
  - `title`: String - Title of the book
  - `publisher`: String - Publisher of the book
  - `pubYear`: int - Publishing year
  - `copies`: int - Number of copies
  - `author`: String - Author of the book
  - `ISBN`: long - ISBN number
- Calls the super constructor with `callNum`, `title`, `publisher`, `pubYear`, and `copies`
- Initializes `ISBN` and `author` with the provided arguments

## Methods

### setISBN(long isbn)
- Sets the ISBN number of the book
- Parameters:
  - `isbn`: long - The ISBN to set

### setAuthor(String author)
- Sets the author name
- Parameters:
  - `author`: String - The author name to set

### getISBN()
- Returns the ISBN number
- Return type: long

### getAuthor()
- Returns the author name
- Return type: String

### fileString()
- Overrides the superclass method
- Returns a simplified String representation of the Book's information
- Return type: String
- Format: "{superclass fileString}\n{author}\n{ISBN}"

## Inheritance
This class extends the `Text` class, inheriting its properties and methods.