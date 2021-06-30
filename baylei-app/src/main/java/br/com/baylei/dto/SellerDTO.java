package br.com.baylei.dto;

import br.com.baylei.entity.Client;
import br.com.baylei.entity.Seller;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SellerDTO {

    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String phone;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static SellerDTO of(Seller seller) {
        return SellerDTO.builder()
                .id(seller.getId())
                .name(seller.getName())
                .lastName(seller.getLastName())
                .age(seller.getAge())
                .phone(seller.getPhone())
                .dateCreated(seller.getDateCreated())
                .dateUpdated(seller.getDateUpdated())
                .build();
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
}
