package HotelManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var choice = 0;
        ArrayList<Hotel> list = new ArrayList<>();
        do {
            System.out.println("1: Them Khac Hang");
            System.out.println("2: Hien Thi Thong Tin Khach Hang");
            System.out.println("3: Xoa Thong Thin Khach Hang");
            System.out.println("4: Tinh Tien Phong");
            System.out.println("0: Thoat");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    var addCustomer = ceartRoom(input);
                    list.add(addCustomer);
                    break;
                case 2:
                    showCustomer(list);
                    break;
                case 3:
                    if (list.size() > 0) {
                        System.out.println("Nhap So CMT");
                        var cmt = input.nextLine();
                        var result = deleteCutomer(list, cmt);
                        if (result) {
                            System.out.println("Xoa Thanh Cong");
                        } else {
                            System.out.println("Khong Co Ai co CMT" + cmt);
                        }
                    } else {
                        System.out.println("Danh sach Rong");
                    }
                    break;
                case 4:
                    if (list.size() > 0) {
                        System.out.println("Nhap So CMT");
                        var cmt = input.nextLine();
                        payRoom(list, cmt);
                    }
            }
        } while (true);
    }

    private static void payRoom(ArrayList<Hotel> list, String cmt) {
        for (Hotel hotel : list) {
            if (hotel.getPerson().getCMTND().equals(cmt)) {
                hotel.Payroom();
            }
        }
    }

    private static Boolean deleteCutomer(ArrayList<Hotel> list, String cmt) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPerson().getCMTND().compareTo(cmt) == 0) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    private static void showCustomer(ArrayList<Hotel> list) {
        if (list.size() > 0) {
            var format = "dd/MM/yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    "Ho Ten", "Ngay Sinh", "CMTND", "Start Date", "End Date", "Gia Tien");
            for (var index : list) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                        index.getPerson().getFullName(), index.getPerson().getDateOfBirth(),
                        index.getPerson().getCMTND(), dateFormat.format(index.getStartDate()),
                        dateFormat.format(index.getEndDate()), index.getPrice());
            }
        } else {
            System.out.println("Danh Sach Rong");
        }
    }

    private static Hotel ceartRoom(Scanner input) {
        System.out.println("Nhap Ten");
        var name = input.nextLine();
        System.out.println("Nhap Ngay Thang Nam Sinh");
        var dateOfbirth = input.nextLine();
        System.out.println("Nhap CMTND");
        var CMTND = input.nextLine();
        System.out.println("Ngay Bat Dau / Ví Dụ 20/20/2020");
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date sartDate;
        try {
            sartDate = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            sartDate = new Date();
        }
        System.out.println("Ngay Ket Thuc Ví Dụ 20/20/2020");
        Date endDate;
        try {
            endDate = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            endDate = new Date();
        }
        System.out.println("Nhap Gia Tien");
        var prices = Float.parseFloat(input.nextLine());
        person person = new person(name, dateOfbirth, CMTND);
        return new Hotel(person, sartDate, endDate, prices);
    }
}
