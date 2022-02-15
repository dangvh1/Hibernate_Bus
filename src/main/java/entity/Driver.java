package entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "driver")
public class Driver implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "level", nullable = false)
    String level;

    private static String LEVEL_A = "Loại A";
    private static String LEVEL_B = "Loại B";
    private static String LEVEL_C = "Loại C";
    private static String LEVEL_D = "Loại D";
    private static String LEVEL_E = "Loại E";
    private static String LEVEL_F = "Loại F";

    public void inputInfo() {
        System.out.println("Nhập tên lái xe: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ lái xe: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại lái xe: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Nhập trình độ lái xe: ");
        System.out.println("1.Loại A");
        System.out.println("2.Loại B");
        System.out.println("3.Loại C");
        System.out.println("4.Loại D");
        System.out.println("5.Loại E");
        System.out.println("6.Loại F");
        System.out.println("Nhập sự lựa chọn của bạn: ");
        boolean check = true;
        do {
            int choice;
            try {
                choice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("Không được nhập ký tự khác ngoài số! Vui lòng thử lại: ");
                check = false;
                continue;
            }
            if (choice <= 0 || choice > 6) {
                System.out.print("Nhập số trong khoảng từ 1 đến 6! Vui lòng thử lại: ");
                check = false;
            }
            switch (choice) {
                case 1:
                    this.setLevel(Driver.LEVEL_A);
                    check = true;
                    break;
                case 2:
                    this.setLevel(Driver.LEVEL_B);
                    check = true;
                    break;
                case 3:
                    this.setLevel(Driver.LEVEL_C);
                    check = true;
                    break;
                case 4:
                    this.setLevel(Driver.LEVEL_D);
                    check = true;
                    break;
                case 5:
                    this.setLevel(Driver.LEVEL_E);
                    check = true;
                    break;
                case 6:
                    this.setLevel(Driver.LEVEL_F);
                    check = true;
                    break;
                default:
                    System.out.print("Trình độ vừa chọn không hợp lệ, vui lòng chọn lại: ");
                    check = false;
                    break;
            }
        } while (!check);
    }

}
