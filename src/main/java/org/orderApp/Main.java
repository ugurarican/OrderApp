package org.orderApp;

import java.util.Scanner;

class Main {
    static Scanner input = new Scanner(System.in);
    static Service service = new Service();

    public static void main(String[] args) {
        service.addBusiness("Market de Janerio", "haziran", 2000, "Gıda");
        service.addBusiness("Market de Papel 2", "haziran", 1200, "Gıda");
        service.addBusiness("Faruk Eczanesi", "haziran", 3000, "Sağlık");
        service.addBusiness("Marketinyo", "haziran", 700, "Gıda");
        service.addBusiness("VIP CAR", "haziran", 1000, "Teknoloji");

        service.addCustomer("Ceren Pekdemir", "haziran", 2000);
        service.addCustomer("Ayşe Önder", "haziran", 1000);
        service.addCustomer("Ezgi Yılmaz", "haziran", 800);
        service.addCustomer("Mahmut Aras", "haziran", 550);
        service.addCustomer("Cansu Özkan", "haziran", 500);
        int choice;
        do {
            System.out.println("1. Tüm müşterileri listeleme");
            System.out.println("2. Yeni Müşteri oluşturma");
            System.out.println("3. İçerisinde ‘C’ harfi olan müşterileri listeleme");
            System.out.println("4. Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleme");
            System.out.println("5. Sistemdeki tüm faturaları listeleme");
            System.out.println("6. Sistemdeki 1500TL üstündeki faturaları listeleme");
            System.out.println("7. Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplama");
            System.out.println("8. Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleme");
            System.out.println("9. Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleme");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    service.displayAllCustomers();
                    break;
                case 2:
                    service.createNewCustomer();
                    break;
                case 3:
                    service.displayCustomersWithNameContainsC();
                    break;
                case 4:
                    service.displayTotalBillAmountOfCustomersRegisteredInJune();
                    break;
                case 5:
                    service.displayAllBills();
                    break;
                case 6:
                    service.displayBillsOver1500();
                    break;
                case 7:
                    service.displayAverageBills();
                    break;
                case 8:
                    service.displayCustomersWithBillsLessThan500();
                    break;
                case 9:
                    service.displayBusinessesUnderAverageOf750InJune();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        } while (choice != 0);
    }
}