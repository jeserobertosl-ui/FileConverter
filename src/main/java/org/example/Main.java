package org.example;

import java.io.*;
import java.util.Scanner;

public class Main
{
    static String get_input(String _msg)
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println(_msg);
        return scnr.nextLine();
    }

    public static void main(String[] args)
    {
        try
        {
            new FileConverter().write_csv
            (
                get_input("Enter the path of the JSON file (including file extension)"),
                get_input("Enter the path of the output (including file extension)"),
                get_input("Enter the delimiter (e.g.  \",\", \"/\", \".\", \":\")")
            );
        }
        catch (IOException ioe)
        {
            System.out.println("Program failed: " + ioe.getMessage());
        }
    }
}