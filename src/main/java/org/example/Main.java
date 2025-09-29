package org.example;

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter the path of the JSON file (including file extension)");
        String json_path = scnr.nextLine();

        System.out.println("Enter the path of the output (including file extension)");
        String csv_output = scnr.nextLine();

        System.out.println("Enter the delimiter (e.g.  \",\", \"/\", \".\", \":\")");
        String separator = scnr.nextLine();

        try
        {
            new FileConverter().write_csv
            (
                json_path,
                csv_output,
                separator
            );
        }
        catch (IOException ioe)
        {
            System.out.println("Program failed: " + ioe.getMessage());
        }
    }
}