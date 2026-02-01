package com.medicinealert;

import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MedicineService service = new MedicineService();

        while(true) {

            System.out.println("\n1.Add");
            System.out.println("2.View All");
            System.out.println("3.Expiring (7 days)");
            System.out.println("4.Expired");
            System.out.println("5.Delete");
            System.out.println("6.Exit");

            int ch = sc.nextInt();

            try {

                if(ch == 1) {

                    MedicineDTO dto = new MedicineDTO();

                    System.out.print("Name: ");
                    dto.setName(sc.next());

                    System.out.print("Batch: ");
                    dto.setBatchNo(sc.next());

                    System.out.print("Qty: ");
                    dto.setQuantity(sc.nextInt());

                    System.out.print("Expiry (yyyy-mm-dd): ");
                    dto.setExpiryDate(
                            java.sql.Date.valueOf(sc.next())
                    );

                    System.out.print("Supplier: ");
                    dto.setSupplier(sc.next());

                    service.addMedicine(dto);
                    System.out.println("Medicine added.");

                }

                else if(ch == 2) {

                    ResultSet rs = service.getAllMedicines();

                    while(rs.next()) {
                        System.out.println(
                                rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getDate("expiry_date")
                        );
                    }
                }

                else if(ch == 3) {

                    ResultSet rs = service.getExpiringMedicines(7);

                    while(rs.next()) {
                        System.out.println(
                                rs.getString("name") + " " +
                                rs.getDate("expiry_date")
                        );
                    }
                }

                else if(ch == 4) {

                    ResultSet rs = service.getExpiredMedicines();

                    while(rs.next()) {
                        System.out.println(
                                rs.getString("name") + " " +
                                rs.getDate("expiry_date")
                        );
                    }
                }

                else if(ch == 5) {

                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    service.deleteMedicine(id);
                    System.out.println("Deleted.");
                }

                else {
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
