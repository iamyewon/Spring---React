package com.example.customer.entity;

// 클래스 위에 @Entity 설정
// 클래스 위에 Table 이름 명시
// JPA : 필드명과 디비의 컬럼명을 매칭 (같게)
import jakarta.persistence.*;
// import jakarta.persistence.*;  하면 전부

@Entity
@Table(name="customer")
public class Customer { // 대문자니까 객체 + 저장용도 + 메모리 초기화 용도(생성자) = 하나씩 처리 대신 한번에
    // 멤버변수 = 필드
    // 보통 db 컬럼 이름과 같게 쓰면 알아서 찾아가지만, 만약 다를때는 @Column.. 같아도 명확하게 하려고 써줌

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key 표시
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="passwd")
    private String passwd;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="contact")
    private String contact;


    // 생성자 : 생성자가 디폴트 생성자 하나만 있으면 생략해도 됨
    public Customer(){} // Default Constructor


    // getter, setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        //멤버변수 = 매개변수;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    // toString(); : debugging
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
