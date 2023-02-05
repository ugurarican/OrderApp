package org.orderApp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private List<Customer> customers = new ArrayList<>();
    private List<Business> businesses = new ArrayList<>();

    public void addBusiness(String name, String date, int bill, String sector) {
        Business b = new Business(name, date, bill, sector);
        businesses.add(b);
    }
    public void addCustomer(String name, String date, int bill) {
        Customer c = new Customer(name, date, bill);
        customers.add(c);
    }


    // Konsoldan 1 seçildiğinde çalışan kod.
    public void displayAllCustomers() {
        System.out.println("Tüm Müşteriler:");
        for (Customer c : customers) {
            System.out.println(c.getName());
        }
    }

    // Konsoldan 2 seçildiğinde çalışan kod.
    public void createNewCustomer() {
        System.out.print("Müşteri adı: ");
        String name = Main.input.next();
        System.out.print("Kayıt tarihi (ay): ");
        String date = Main.input.next();
        System.out.print("Fatura tutarı (TL): ");
        int bill = Integer.parseInt(Main.input.next());
        customers.add(new Customer(name, date, bill));
        System.out.println("Müşteri başarıyla oluşturuldu!");
    }

    // Konsoldan 3 seçildiğinde çalışan kod.
    public void displayCustomersWithNameContainsC() {
        System.out.println("İçerisinde ‘C’ harfi olan müşteriler:");
        customers.stream()
                .filter(c -> c.getName().toLowerCase().contains("c"))
                .forEach(c -> System.out.println(c.getName()));
    }

    // Konsoldan 4 seçildiğinde çalışan kod.
    public void displayTotalBillAmountOfCustomersRegisteredInJune() {
        /*System.out.println("Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı:");
        double totalBillAmount = customers.stream()
                .filter(c -> c.getDate().contains("haziran"))
                .map(Customer::getBill)
                .reduce(0, (a, b) -> a + b);*/
        System.out.println("Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı:");
        double totalBillAmount = customers.stream()
                .filter(c -> c.getDate().contains("haziran"))
                .mapToDouble(Customer::getBill)
                .sum();
        System.out.println(totalBillAmount + " TL");
    }

    //Konsoldan 5 seçildiğinde çalışan kod.
    public void displayAllBills() {
        System.out.println("Tüm müşteri ve işletme faturaları:");
        customers.stream()
                .forEach(c -> System.out.println(c.getName() + " - "  + c.getBill()));
        businesses.stream()
                .forEach(b -> System.out.println(b.getName() + " - "  + b.getBill() + " - " + b.getSector()));
    }

    //Konsoldan 6 seçildiğinde çalışan kod.
    public void displayBillsOver1500() {
        System.out.println("1500 TL üstündeki faturalar: ");
        customers.stream()
                .filter(c -> c.getBill() > 1500)
                .forEach(c -> System.out.println(c.getName() + " adlı müşterinin faturası: " + c.getBill() + " TL"));

        businesses.stream()
                .filter(b -> b.getBill() > 1500)
                .forEach(b -> System.out.println(b.getName() + " adlı işletmenin faturası: " + b.getBill() + " TL"));
    }

    //Konsoldan 7 seçildiğinde çalışan kod.
    public void displayAverageBills() {
        System.out.println("Müşterilerin faturalarının ortalaması:");
        double customerAverageBill = customers.stream()
                .mapToDouble(Customer::getBill)
                .average()
                .orElse(0.0);
        System.out.println(customerAverageBill + " TL");

        System.out.println("İşletmelerin faturalarının ortalaması:");
        double businessAverageBill = businesses.stream()
                .mapToDouble(Business::getBill)
                .average()
                .orElse(0.0);
        System.out.println(businessAverageBill + " TL");
    }

    //Konsoldan 8 seçildiğinde çalışan kod.
    public void displayCustomersWithBillsLessThan500() {
        System.out.println("500 TL altındaki faturalara sahip müşteriler:");
        customers.stream()
                .filter(c -> c.getBill() < 500)
                .map(Customer::getName)
                .forEach(System.out::println);
    }

    //Konsoldan 9 seçildiğinde çalışan kod.
    public void displayBusinessesUnderAverageOf750InJune() {
        System.out.println("Haziran ayı faturalarının ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleme:");

        List<Business> businessesUnderAverage = businesses.stream()
                .filter(b -> b.getBill() < 750)
                .collect(Collectors.toList());

        for (Business b : businessesUnderAverage) {
            System.out.println("Firma adı: " + b.getName());
            System.out.println("Firma sektörü: " + b.getSector());
            System.out.println("Ortalama fatura tutarı: " + b.getBill());
            System.out.println("-------------");
        }
    }


}