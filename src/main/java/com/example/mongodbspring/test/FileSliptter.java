package com.example.mongodbspring.test;

import java.io.*;

public class FileSliptter {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\d drive\\springboot-mongodb\\mongodbspring\\src\\main\\java\\com\\example\\mongodbspring\\test\\testfilebig.txt");
        InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileStream));

        String line = reader.readLine();

        String fileName = inputFile.getName();
        String outfileName = "C:\\d drive\\springboot-mongodb\\mongodbspring\\src\\main\\java\\com\\example\\mongodbspring\\test" + "\\" + fileName;

       // this is for webhoot testing
        int val = 85;

        int test2 =85;

        int linesWritten=0;
        int count=0;
        while (line != null) {
            File outFile = new File(outfileName + "_" + count + ".split");
            Writer writer = new OutputStreamWriter(new FileOutputStream(outFile));


            while (line != null && linesWritten < 50000) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
                line = reader.readLine();
                linesWritten++;
            }

            writer.close();
            linesWritten = 0;
            count++;
        }

        reader.close();
    }
}
