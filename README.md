This project allows to convert a JSON file to an object and then convert that to a CSV object and write into a .csv file
Download the folder and open it with Intellij IDEA, then run

First we extract the headers and then iterate through the JSON objects to construct rows.

Load the JSON data from a file into a string and then into a data structure.

Compare all the registers and form an array of headers.
For nested JSON, we create special keys with compound header names.

Iterate through each JSON object and extract the values based on the headers.
Replace missing keys with empty or default values.
Remove commas from values like strings.

Join the extracted values with a delimiter.
Print the headers first and then the values in order separated with the delimiter.
