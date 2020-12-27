package HotelManagement;

import java.util.Date;

public class Hotel {
    private person person;
    private Date startDate;
    private Date endDate;
    private float price;

    public Hotel() {
    }

    public Hotel(HotelManagement.person person,
                 Date startDate, Date endDate, float price) {
        this.person = person;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public HotelManagement.person getPerson() {
        return person;
    }


    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }


    public float getPrice() {
        return price;
    }


    public void Payroom() {
        if (getStartDate() == null && getEndDate() == null) {
            System.out.println("Khong Co Ngay Nao");
        } else {
            var total = daysBetween(getStartDate(), getEndDate());
            System.out.println("Tong So Tien " + total * price + "VND");
        }
    }

    public int daysBetween(Date d1, Date d2) {
        return (int) (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
    }
}
