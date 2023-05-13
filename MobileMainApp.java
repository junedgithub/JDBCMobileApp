package MobileApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileMainApp {
    static Scanner sc = new Scanner(System.in);
    static boolean status = true;
    static List<MobileDTO> mobiles = new ArrayList<>();

    static MobileDAO d1 = new MobileDAO();
    public static void main(String[] args) {
        do {
            System.out.println("1. Add mobile!!");
            System.out.println("2. Search mobile!!");
            System.out.println("3. Delete Mobile!!");
            System.out.println("4. Exit!!");
            int ch1 = sc.nextInt();
            switch (ch1)
            {
                case 1: addMobile();
                break;
                case 2:
                    do {
                        System.out.println("1. Search Mobile by Company!!");
                        System.out.println("2. Search Mobile by Price!!");
                        System.out.println("3. Search Mobile By Ram!!");
                        System.out.println("4. Search Mobile By Camera!!");
                        System.out.println("5. Exit!!");
                        int ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1:
                                searchMobileByCompany();
                                break;
                            case 2:
                                searchMobileByPrice();
                                break;
                            case 3:
                                searchMobileByRam();
                                break;
                            case 4:
                                searchMobileByCamera();
                            case 5: status = false;
                            default:
                                System.out.println("Invalid Choice!!");
                        }
                    }while (status);
                case 3: deleteMobile();
                break;
                case 4: status = false;
                default:
                    System.out.println("Invalid Choice!!");
            }
        }while (status);

    }

    private static void deleteMobile() {
        System.out.println("Enter Model No to Be deleted");
        int modelNo = sc.nextInt();
        d1.deleteMobile(modelNo);
        System.out.println("Deleted Successfully!!");

    }

    private static void searchMobileByCamera() {
        System.out.println("Enter Lower Megapixels");
        String LmegaPixel = sc.next();
        System.out.println("Enter Highest Megapixels");
        String HmegaPixel = sc.next();
        d1.searchByCamera(LmegaPixel,HmegaPixel);
        mobiles = MobileDAO.mobiles;
        System.out.println("ModelNo\t\tModelName\t\tCompany\t\tRAM\t\tCamera\t\tPrice");
        for (MobileDTO d : mobiles)
        {
            System.out.println(d.getModelNo()+"\t\t"+d.getModelName()+"\t\t"+d.getCompany()+"\t\t"+d.getRam()+"\t\t"+d.getCamera()+"\t\t"+d.getPrice());

        }
    }

    private static void searchMobileByRam() {
        System.out.println("Enter Ram Required!!");
        int ram = sc.nextInt();
        d1.searchByRam(ram);
        mobiles = MobileDAO.mobiles;
        System.out.println("ModelNo\t\tModelName\t\tCompany\t\tRAM\t\tCamera\t\tPrice");
        for (MobileDTO d : mobiles)
        {
            System.out.println(d.getModelNo()+"\t\t"+d.getModelName()+"\t\t"+d.getCompany()+"\t\t"+d.getRam()+"\t\t"+d.getCamera()+"\t\t"+d.getPrice());

        }
    }

    private static void searchMobileByPrice() {
        System.out.println("Enter Highest Price!!");
        double hPrice = sc.nextDouble();
        System.out.println("Enter Lowest Price!!");
        double lPrice = sc.nextDouble();
        d1.searchByPrice(hPrice,lPrice);
        mobiles = MobileDAO.mobiles;
        System.out.println("ModelNo\t\tModelName\t\tCompany\t\tRAM\t\tCamera\t\tPrice");
        for (MobileDTO d : mobiles)
        {
            System.out.println(d.getModelNo()+"\t\t"+d.getModelName()+"\t\t"+d.getCompany()+"\t\t"+d.getRam()+"\t\t"+d.getCamera()+"\t\t"+d.getPrice());

        }
    }

    private static void searchMobileByCompany() {
        System.out.println("Enter Company name!!");
        String company = sc.next();
        d1.searchMobileByCompany(company);
        mobiles = MobileDAO.mobiles;
        System.out.println("ModelNo\t\tModelName\t\tCompany\t\tRAM\t\tCamera\t\tPrice");
        for (MobileDTO d : mobiles)
        {
            System.out.println(d.getModelNo()+"\t\t"+d.getModelName()+"\t\t"+d.getCompany()+"\t\t"+d.getRam()+"\t\t"+d.getCamera()+"\t\t"+d.getPrice());

        }
    }

    private static void addMobile() {
        System.out.println("Enter Model No!!");
        int modelNo = sc.nextInt();
        System.out.println("Enter Model Name!!");
        String modelName = sc.next();
        System.out.println("Enter Company!!");
        String company = sc.next();
        System.out.println("Enter Ram!!");
        int ram = sc.nextInt();
        System.out.println("Enter Camera!!");
        String camera = sc.next();
        System.out.println("Enter Price!!");
        double price = sc.nextDouble();
        d1.addMobile(modelNo,modelName,company,ram,camera,price);
    }
}
