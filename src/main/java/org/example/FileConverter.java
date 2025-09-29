package org.example;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * First we extract the headers and then iterate through the JSON objects to construct rows.
 * ----------------------------------------------------------------------------
 * Load the JSON data from a file into a string and then into a data structure.
 * ----------------------------------------------------------------------------
 * Compare all the registers and form an array of headers.
 * For nested JSON, we create special keys with compound header names.
 * ----------------------------------------------------------------------------
 * Iterate through each JSON object and extract the values based on the headers.
 * Replace missing keys with empty or default values.
 * Remove commas from values like strings.
 * ----------------------------------------------------------------------------
 * Join the extracted values with a delimiter.
 * Print the headers first and then the values in order separated with the delimiter.
 */
public class FileConverter
{
    /**
     *
     * @param _file path of file to be opened
     * @return the content of the file as a string
     */
    private String read_json(String _file)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(_file)))
        {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.lineSeparator();

            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        }
        catch (IOException ioe)
        {
            System.out.println("File not read:" + ioe.getMessage());
            return "";
        }
    }

    /**
     *
     * @param _json_path the path to the JSON file
     * @param _output_path the path where the output will be saved
     * @throws IOException if JSON is empty, not read or not converted
     */
    public void write_csv(String _json_path, String _output_path, String _separator) throws IOException
    {
        String str = read_json(_json_path);

        if (str.isEmpty())
        {
            System.out.println("JSON file is empty");
            return;
        }

        JSONArray ja = new JSONArray(str);

        String csv = CDL.toString(ja).replace(",", (_separator.isEmpty()) ? "," : _separator);

        try (FileWriter fileWriter = new FileWriter(_output_path))
        {
            fileWriter.write(csv);
            System.out.println("JSON successfully converted to CSV");
        }
        catch (JSONException | IOException je)
        {
            System.out.println("File not written:" + je.getMessage());
        }
    }
}
