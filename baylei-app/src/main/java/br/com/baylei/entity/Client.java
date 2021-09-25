//package br.com.baylei.entity;
//
//
//import lombok.Data;
//import org.springframework.data.mongodb.core.index.CompoundIndex;
//import org.springframework.data.mongodb.core.index.CompoundIndexes;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Data
//@Document
//@CompoundIndexes({
//        @CompoundIndex(name = "_name", def = "{'name' : 1}"),
//        @CompoundIndex(name = "_lastName", def = "{'lastName' : 1}"),
//        @CompoundIndex(name = "_email", def = "{'email' : 1}")
//})
//public class Client extends BaseEntity {
//
//    private String name;
//    private String lastName;
//    private Integer age;
//    private String phone;
//    private String email;
//
//}
