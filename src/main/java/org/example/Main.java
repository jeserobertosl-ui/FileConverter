package org.example;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            new FileConverter().write_csv(
                    "src/main/resources/test.json",
                    "src/main/resources/output.csv"
            );
        }
        catch (IOException ioe)
        {
            System.out.println("Program failed: " + ioe.getMessage());
        }
    }
}