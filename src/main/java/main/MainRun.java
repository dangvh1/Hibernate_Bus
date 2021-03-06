package main;

import drivingManagement.DriverAssignment;
import entity.Busline;
import entity.Driver;
import repository.DriverDAO;
import repository.DrivingDAO;
import repository.BuslineDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static List<Driver> drivers = new ArrayList<>();
    public static List<Busline> busLines = new ArrayList<>();
    public static List<DriverAssignment> drivings = new ArrayList<>();
    public static List<Integer> checkDriverID = new ArrayList<>();
    public static List<Integer> checkBusLineID = new ArrayList<>();

    public static final DriverDAO driverDAO = new DriverDAO();
    public static final BuslineDAO buslineDAO = new BuslineDAO();
    public static final DrivingDAO drivingDAO = new DrivingDAO();

    private static final DriverService driverService = new DriverService();
    private static final BusLineService busLineService = new BusLineService();
    private static final DriveAssignmentService driveAssignmentService = new DriveAssignmentService();
    private static final SorterAndCalculator sortandDistance = new SorterAndCalculator();

    public static void main(String[] args) {
        System.out.println("Program is ready!");
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    driverService.createNewDriver();
                    printDriver();
                    break;
                case 2:
                    busLineService.createNewBusLine();
                    printRoute();
                    break;
                case 3:
                    driveAssignmentService.createDrivingTable();
                    printDriving();
                    break;
                case 4:
                    sortandDistance.sortDrivingTable();
                    break;
                case 5:
                    sortandDistance.distanceDriving();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }


    public static int functionChoice() {
        System.out.println("-----QU???N L?? PH??N C??NG L??I XE BUS-------");
        System.out.println("1. Nh???p danh s??ch l??i xe");
        System.out.println("2. Nh???p danh s??ch tuy???n");
        System.out.println("3. Nh???p danh s??ch ph??n c??ng l??i xe");
        System.out.println("4. S???p x???p danh s??ch ph??n c??ng ");
        System.out.println("5. L???p b???ng th???ng k?? t???ng kho???ng c??ch");
        System.out.println("6. Tho??t");
        System.out.print("Nh???p s??? l???a ch???n c???a b???n: ");
        int functionChoice = 0;
        boolean checkFunction = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                checkFunction = true;
            } catch (Exception e) {
                System.out.println("Kh??ng ???????c nh???p k?? t??? kh??c ngo??i s???! Nh???p l???i: ");
                continue;
            }
            if (functionChoice <= 0 || functionChoice > 6) {
                System.out.print("Nh???p s??? trong kho???ng t??? 1 ?????n 6! Nh???p l???i: ");
                checkFunction = false;
            } else break;
        } while (!checkFunction);
        return functionChoice;
    }

    public static void printDriver() {
        drivers.forEach(System.out::println);
    }
    public static void printRoute() {
        busLines.forEach(System.out::println);
    }
    public static void printDriving() {
        drivings.forEach(System.out::println);
    }
}
