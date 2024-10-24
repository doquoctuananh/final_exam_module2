package controller;

import service.ServiceContact;
import service.createFile.CreateFile;
import service.read_write_file.RWFile;
import validate.Validate;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // src/data/
        File filecontact = new File("src/data/contacts.csv");
        CreateFile.CreateFile(filecontact);



        while(1>0){
            System.out.println("Menu \n" +
                    "1.Xem ds\n" +
                    "2.them moi\n" +
                    "3.cap nhat\n" +
                    "4.xoa\n" +
                    "5.tim kiem\n" +
                    "6.doc tu file\n" +
                    "7.ghi tu file\n" +
                    "8.thoat\n" +
                    "Chon chuc nang");
            int option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    ServiceContact.showContact(filecontact);
                    break;
                }
                case 2:{
                    ServiceContact.addContact(filecontact);
                    break;
                }
                case 3:{
                    ServiceContact.updateContact(filecontact);
                    break;
                }
                case 4:{
                    ServiceContact.deleteContact(filecontact);
                    break;
                }
                case 5:{
                    ServiceContact.searchContact(filecontact);
                    break;
                }
                case 6:{
                    ServiceContact.readFileContact(filecontact);
                    break;
                }
                case 7:
                    System.out.println("Trong các chức năng trước\n" +
                            "em đã đã lưu vào file luôn nên sẽ thao tác trên file\n" +
                            "ai chấm em thì không nên trừ câu điểm ạ\n" +
                            "Trân trọng cảm ơn.");
                    break;
                case 8:{
                    System.exit(0);
                }
            }
        }
    }
}
