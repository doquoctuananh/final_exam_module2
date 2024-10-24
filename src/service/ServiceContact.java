package service;

import model.Contact;
import service.read_write_file.RWFile;
import validate.Validate;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceContact {

    // Them moi
    public static void addContact(File nameFile){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap nhom danh ba");
        String groupContact = sc.nextLine();
        System.out.println("Nhap so dien thoai");
        String phone = null;
        do{
            phone = sc.nextLine();
        }while(!Validate.validatePhone(phone));

        System.out.println("Nhap ten");
        String name = sc.nextLine();
        System.out.println("nhap gioi tinh");
        String sex = sc.nextLine();
        System.out.println("nhap dia chi");
        String address = sc.nextLine();
        System.out.println("nhap ngay sinh");
        LocalDate brithday = LocalDate.parse(sc.nextLine());
        System.out.println("nhap email");
        String email = null;
        do{
            email = sc.nextLine();
        }while (!Validate.validateEmail(email));
        Contact contact = new Contact(groupContact,phone,
                name,sex,address,brithday,email);
        String contactString = contact.toString();
        RWFile.writeLineFile(contactString,nameFile);

    }

    // xem danh sach
    public static void showContact(File nameFile){
        ArrayList<String> list = RWFile.readFile(nameFile);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // sua thong tin danh ba
    public static void updateContact(File nameFile){
        Scanner sc = new Scanner(System.in);
        boolean findContact = false;
        ArrayList<String> list = RWFile.readFile(nameFile);
        System.out.println("nhap so dien thoai danh ba can sua");
        String phone = null;
        do{
            phone = sc.nextLine();
        }while(!Validate.validatePhone(phone));

        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            if(split[2].equals(phone)){
                System.out.println("nhap nhom danh ba");
                split[1] = sc.nextLine();
                System.out.println("Nhap ten");
                split[0] = sc.nextLine();
                System.out.println("nhap gioi tinh");
                split[3] = sc.nextLine();
                System.out.println("nhap dia chi");
                split[4] = sc.nextLine();
                System.out.println("nhap ngay sinh");
                split[5] = LocalDate.parse(sc.nextLine()).toString();
                System.out.println("nhap email");
                String email = null;
                do{
                    email = sc.nextLine();
                }while (!Validate.validateEmail(email));
                split[6] = email;

                String update = split[0] +"," + split[1]+"," + phone+"," + split[3]+
                        "," +split[4]+"," +split[5]+"," +split[6];
                list.set(i,update);
                findContact = true;
                break;
            }
        }
        if(findContact == true){
            System.out.println("update successfully");
            RWFile.writeListFile(list,nameFile);
        }
        else{
            System.out.println("Not find phone in Contact");
        }

    }

    // Xoa danh ba
    public static void deleteContact(File nameFile){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so dien thoai muon xoa");
        String phone = null;
        do{
            phone = sc.nextLine();
        }while(!Validate.validatePhone(phone));
        boolean findContact = false;
        ArrayList<String> list = RWFile.readFile(nameFile);
        for (int i = 0; i <list.size() ; i++) {
            String[] split = list.get(i).split(",");
            if(split[2].equals(phone)){
                System.out.println("Xac nhan xoa nhap Y ");
                String confirm = sc.nextLine().toLowerCase();
                if(confirm.equals("y")){
                    list.remove(i);
                    findContact = true;
                    break;
                }
            }
        }
        if(findContact == true){
            System.out.println("Delete succesfully");
            RWFile.writeListFile(list,nameFile);
        }
        else{
            System.out.println("Delete not succesfully");
        }

    }

    // tim kiem danh ba
    public static void searchContact(File nameFile){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = RWFile.readFile(nameFile);
        System.out.println("tim kiem theo ten hoac so dien thoai\n" +
                "1. so dien thoai\n" +
                "2. theo ten");
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:{
                System.out.println("Nhap so dien thoai");
                String phone = sc.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    String[] split = list.get(i).split(",");
                    if(split[2].contains(phone)){
                        System.out.println(list.get(i));
                    }
                }
                break;
            }
            case 2:{
                System.out.println("Nhap so dien thoai");
                String name = sc.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    String[] split = list.get(i).split(",");
                    if(split[0].contains(name)){
                        System.out.println(list.get(i));
                    }
                }
                break;
            }
        }
    }

    // doc du lieu tu file
    public static void readFileContact(File nameFile){
        ArrayList<String> list = RWFile.readFile(nameFile);
        if(list == null){
            System.out.println("File " + nameFile.getName() +"empty");
        }
        else{
            System.out.println("Data in file: " + nameFile.getName());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
