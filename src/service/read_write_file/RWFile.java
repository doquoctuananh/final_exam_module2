package service.read_write_file;

import java.io.*;
import java.util.ArrayList;

public class RWFile {
    // read file
    public static ArrayList readFile(File nameFile){
        ArrayList<String> list = null;
        if(nameFile.length()>0){
            list = new ArrayList<>();
            try{
                FileReader fileReader = new FileReader(nameFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while((line = bufferedReader.readLine())!= null){
                    list.add(line);
                }
                bufferedReader.close();
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return list;
    }

    // write list in file
    public static void writeListFile(ArrayList<String> list,File nameFile){
        try{
            FileWriter fileWriter = new FileWriter(nameFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i));
                if(i<=list.size()-2){
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.flush();
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // write line with String in File
    public static void writeLineFile(String line , File nameFile){
        if(nameFile.length()>0){
            try{
                FileWriter fileWriter = new FileWriter(nameFile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n");
                bufferedWriter.write(line);
                bufferedWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try{
               FileWriter fileWriter = new FileWriter(nameFile);
               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
               bufferedWriter.write(line);
               bufferedWriter.flush();
               fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
