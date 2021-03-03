package com.uniyaz;

import java.io.*;
import java.sql.SQLOutput;

public class FileService {

    public void fileWrite(File file, String content){
        try {
            File inFile=file;
            OutputStream outputStream=new FileOutputStream(inFile);
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
            outputStreamWriter.write(content);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileAppend(File file, String content){
        try {
            File inFile=file;
            OutputStream outputStream=new FileOutputStream(inFile,true);
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
            outputStreamWriter.append(content);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWriteByString(String filename, String content){
        fileWrite(new File(filename),content);
    }

    public void fileAppendByString(String filename, String content){
        fileAppend(new File(filename),content);
    }

    public void fileRead(String filename){
        fileRead(new File(filename));
    }

    public void fileRead(File filename){
        File inFile=filename;
        try {
            InputStream inputStream=new FileInputStream(inFile);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            int data=inputStreamReader.read();
            while(data != -1){
                char charData=(char)data;
                System.out.print(charData);
                data=inputStreamReader.read();
            }
            System.out.println("\n");
            inputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void objectFileWrite(File file,Object object){
        File inFile=file;
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object objectFileRead(File file){
        Object object=new Object();
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            object=objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
