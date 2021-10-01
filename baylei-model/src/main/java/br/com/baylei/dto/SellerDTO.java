package br.com.baylei.dto;

import br.com.baylei.model.Seller;

import java.time.LocalDateTime;

public class SellerDTO {

    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String phone;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static SellerDTO of(Seller seller) {
        SellerDTO dto = new SellerDTO();
        dto.setId(seller.getId());
        dto.setName(seller.getName());
        dto.setLastName(seller.getLastName());
        dto.setPhone(seller.getPhone());
        dto.setAge(seller.getAge());
        dto.setDateCreated(seller.getDateCreated());
        dto.setDateUpdated(seller.getDateUpdated());

        return dto;
    }

    public static Seller ofDto(SellerDTO sellerDTO) {
        Seller seller = new Seller();
        seller.setId(sellerDTO.getId());
        seller.setName(sellerDTO.getName());
        seller.setLastName(sellerDTO.getLastName());
        seller.setAge(sellerDTO.getAge());
        seller.setPhone(sellerDTO.getPhone());

        return seller;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
