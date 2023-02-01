package java8;


import java8.config.HibernateConfig;
import java8.entity.Bank;
import java8.entity.Client;
import java8.entity.Passport;
import java8.entity.Region;
import java8.service.*;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HibernateConfig.getManagerFactory();

        BankService bankService = new BankServiceImpl();
        ClientService clientService = new ClientServiceImpl();
        PassportService passportService = new PassportServiceImpl();
        RegionService regionService = new RegionServiceImpl();

        Client client = new Client("Ilim Shabdanov","501394235");
        Passport passport = new Passport(1212413);
        Bank bank = new Bank("OptimaBank","Bishkek");
        Region region1 = new Region("Talas");
        Region region = new Region("Bishkek");

        while (true){
            System.out.println("" +
                    "\n1.SAVE CLIENT " +
                    "\n2.DELETE CLIENT BY ID" +
                    "\n3.FIND CLIENT BY ID" +
                    "\n=====PASSPORT METHODS=====" +
                    "\n4.SAVE PASSPORT" +
                    "\n5.DELETE ALL PASSPORT BY ID" +
                    "\n6.ASSIGN PASSPORT TO CLIENT" +
                    "\n=====BANK METHODS=====" +
                    "\n7.SAVE BANK " +
                    "\n8.DELETE BANK BY ID" +
                    "\n9.GET BANKS BY REGION NAME" +
                    "\n10.ASSIGN BANK TO REGION"+
                    "\n=====REGION METHODS=====" +
                    "\n11.SAVE REGION" +
                    "\n12.GET ALL REGIONS" +
                    "\n13.UPDATE REGION");
            System.out.println("Enter by command :");
            int num = new Scanner(System.in).nextInt();
            switch (num){
                case 1-> System.out.println(clientService.saveClient(client));
                case 2->{
                    System.out.println("Enter by id :");
                    Long id  = new Scanner(System.in).nextLong();
                    System.out.println(clientService.deleteByClientId(id));
                }
                case 3->{
                    System.out.println("Enter by id :");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(clientService.findByClientId(id));
                }
                case 4-> System.out.println(passportService.savePassport(passport));
                case 5-> {
                    System.out.println("Enter by id :");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(passportService.deleteAllPassportsById(id));
                }
                case 6->{
                    System.out.println("Enter by passport id");
                    Long idPas = new Scanner(System.in).nextLong();
                    System.out.println("Enter by client id :");
                    Long idCli = new Scanner(System.in).nextLong();
                    System.out.println(passportService.assignPassportToClient(idPas, idCli));
                }
                case 7-> System.out.println(bankService.saveBanks(bank));
                case 8->{
                    System.out.println("Enter by bank id :");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(bankService.deleteBanksById(id));
                }
                case 9->{
                    System.out.println("Enter by region name :");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(bankService.getBanksByRegionName(name));
                }
                case 10->{
                    System.out.println("Enter by bank id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Enter by region id :");
                    Long rid = new Scanner(System.in).nextLong();
                    System.out.println(bankService.assignBankToRegion(id, rid));
                }
                case 11-> System.out.println(regionService.saveRegion(region));
                case 12-> System.out.println(regionService.getAllRegion());
                case 13->{
                    System.out.println("Enter by region id :");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(regionService.updateRegion(id,region1));
                }
            }
        }
    }
}
