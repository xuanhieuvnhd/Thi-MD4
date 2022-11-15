package hieu.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class StudentForm {
    private Long id;
    private String name;
    private Date date;
    private String address;
    private String phone;
    private String email;
    private MultipartFile image;
    private ClassRoom classRoom;

    public StudentForm() {
    }

    public StudentForm(String name, Date date, String address, String phone, String email, MultipartFile image, ClassRoom classRoom) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.classRoom = classRoom;
    }

    public StudentForm(Long id, String name, Date date, String address, String phone, String email, MultipartFile image, ClassRoom classRoom) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
