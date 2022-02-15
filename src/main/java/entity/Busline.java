package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_line")
public class Busline implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "distance", nullable = false)
    float distance;

    @Column(name = "stopNumber", nullable = false)
    float stopNumber;

    public void inputInfo() {
        boolean check = true;
        System.out.println("Nhập khoảng cách: ");
        do {
            try {
                this.distance = new Scanner(System.in).nextFloat();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được có chữ! Nhập lại");
                check = false;
                continue;
            }
            if (this.distance <= 0) {
                System.out.println("Khoảng cách không được nhỏ hơn hoặc bằng 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
        System.out.println("Nhập số điểm dừng: ");
        do {
            try {
                this.stopNumber = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được có chữ! Nhập lại");
                check = false;
                continue;
            }
            if (this.stopNumber <= 0) {
                System.out.println("Số điểm dừng không được nhỏ hơn hoặc bằng 0! Nhập lại: ");
                check = false;
            }
        } while (!check);
    }

}
