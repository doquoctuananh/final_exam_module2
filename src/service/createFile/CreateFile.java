package service.createFile;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    //tao mot thu muc
    public static void CreateFolder(File namefoler){

        if(!namefoler.exists()){
            namefoler.mkdir();
            System.out.println("Create folder "+ namefoler +" succesfully ");
        }
    }

    //tao mot file
    public static void CreateFile(File namefile){

        boolean check = namefile.exists();
        if(!check){
            try{
                boolean created = namefile.createNewFile();
                if(created){
                    System.out.println("Created file "+namefile+" succesfully");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
