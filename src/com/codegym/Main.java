package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (count < 4){
            try {
                System.out.println("Nhập thông tin sản phẩm thứ " + (count + 1));
                Product product = new Product();
                System.out.println("ID sản phẩm: ");
                product.setId(sc.nextInt());
                sc.nextLine();
                System.out.println("Tên sản phẩm : ");
                product.setName(sc.nextLine());
                System.out.println("Hãng sản xuất : ");
                product.setManufacturer(sc.nextLine());
                System.out.println("Giá sản phẩm :");
                product.setPrice(sc.nextDouble());
                sc.nextLine();
                count++;
            }catch (InputMismatchException e){
                System.out.println("Lỗi nhập");
            }
            writeToFile("product.txt", productList);
            List<Product> products = readDataFromFile("product.txt");
            for (Product p: products){
                System.out.println(p);
            }
        }
    }

    public static void writeToFile(String path, List<Product> list){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path){
        List<Product> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
