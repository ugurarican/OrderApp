
package org.orderApp;

import java.util.ArrayList;
import java.util.List;

public class Business implements IBusiness {
    private List<Integer> invoice;
    private String name;
    private String date;
    private int bill;
    private String sector;

    public Business(String name, String date, int bill, String sector) {
        this.name = name;
        this.date = date;
        this.bill=bill;
        this.invoice = new ArrayList<>();
        this.sector = sector;
    }

    public void addInvoice(int bill) {
        this.invoice.add(bill);
    }

    /*public double getAverageInvoiceAmountForMonth(String date) {
        int invoiceSum = 0;
        int invoiceCount = 0;
        for (int invoices : invoice) {
            if (this.date.contains(date)) {
                invoiceSum += invoices;
                invoiceCount++;
            }
        }
        return invoiceCount == 0 ? 0 : (double) invoiceSum / invoiceCount;
    }*/

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int getBill() {
        return bill;
    }

    @Override
    public void setBill(int bill) {
        this.bill = bill;
    }

    @Override
    public String getSector() {
        return sector;
    }

    @Override
    public void setSector(String sector) {
        this.sector = sector;
    }
    public List<Integer> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Integer> invoice) {
        this.invoice = invoice;
    }
}

