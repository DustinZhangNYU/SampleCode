package com.example.demo.Store;
import com.example.demo.Users.Users;
import jakarta.persistence.*;

@Entity
@Table
public class Store {
    @Id
    @SequenceGenerator(
            name = "store_sequence",
            sequenceName = "store_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "store_sequence"
    )
    private Long id;
    private String name;
    private String add_country;
    private String add_city;
    private String add_state;
    private String add_street;
    private String add_street2;
    private String add_zip_code;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Users manager;

    public Store() {

    }

    public Store(String name,
                 String add_country,
                 String add_city,
                 String add_state,
                 String add_street,
                 String add_street2,
                 String add_zip_code) {
        this.name = name;
        this.add_country = add_country;
        this.add_city = add_city;
        this.add_state = add_state;
        this.add_street = add_street;
        this.add_street2 = add_street2;
        this.add_zip_code = add_zip_code;
    }

    public Store(Long id,
                 String name,
                 String add_country,
                 String add_city,
                 String add_state,
                 String add_street,
                 String add_street2,
                 String add_zip_code) {
        this.id = id;
        this.name = name;
        this.add_country = add_country;
        this.add_city = add_city;
        this.add_state = add_state;
        this.add_street = add_street;
        this.add_street2 = add_street2;
        this.add_zip_code = add_zip_code;
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

    public String getAdd_country() {
        return add_country;
    }

    public void setAdd_country(String add_country) {
        this.add_country = add_country;
    }

    public String getAdd_city() {
        return add_city;
    }

    public void setAdd_city(String add_city) {
        this.add_city = add_city;
    }

    public String getAdd_state() {
        return add_state;
    }

    public void setAdd_state(String add_state) {
        this.add_state = add_state;
    }

    public String getAdd_street() {
        return add_street;
    }

    public void setAdd_street(String add_street) {
        this.add_street = add_street;
    }

    public String getAdd_street2() {
        return add_street2;
    }

    public void setAdd_street2(String add_street2) {
        this.add_street2 = add_street2;
    }

    public String getAdd_zip_code() {
        return add_zip_code;
    }

    public void setAdd_zip_code(String add_zip_code) {
        this.add_zip_code = add_zip_code;
    }

    public Users getManager() {
        return manager;
    }

    public void setManager(Users manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", add_country='" + add_country + '\'' +
                ", add_city='" + add_city + '\'' +
                ", add_state='" + add_state + '\'' +
                ", add_street='" + add_street + '\'' +
                ", add_street2='" + add_street2 + '\'' +
                ", add_zip_code='" + add_zip_code + '\'' +
                ", manager=" + manager +
                '}';
    }
}
