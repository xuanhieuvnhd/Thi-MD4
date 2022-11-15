package hieu.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;
    private String address;
    private String phone;
    private String email;
    private String image;

    @ManyToOne
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(String name, Date date, String address, String phone, String email, String image, ClassRoom classRoom) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.classRoom = classRoom;
    }

    public Student(Long id, String name, Date date, String address, String phone, String email, String image, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
