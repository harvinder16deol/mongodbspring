package com.example.mongodbspring.services;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class SplitService {

    public void split(MultipartFile file) throws IOException {

//        File inputFile = new File(String.valueOf(file.getInputStream()));
//        InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));

        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

        String line = reader.readLine();

//        String fileName = inputFile.getName();
//        String outfileName = "C:\\d drive\\springboot-mongodb\\mongodbspring\\src\\main\\java\\com\\example\\mongodbspring\\test" + "\\" + fileName;
        String outfileName = "C:\\d drive\\springboot-mongodb\\mongodbspring\\src\\main\\java\\com\\example\\mongodbspring\\test" + "\\" + "docs_300k";

        int linesWritten = 0;
        int count = 1;
        while (line != null) {
            File outFile = new File(outfileName + "_" + count + ".txt");
            Writer writer = new OutputStreamWriter(new FileOutputStream(outFile));


            while (line != null && linesWritten < 300000) {
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
