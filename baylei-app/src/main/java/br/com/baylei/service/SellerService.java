//package br.com.baylei.service;
//
//import br.com.baylei.dto.SellerDTO;
//import br.com.baylei.entity.Seller;
//import br.com.baylei.exception.NotFoundException;
//import br.com.baylei.repository.SellerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class SellerService {
//
//    private final SellerRepository sellerRepository;
//
//    @Autowired
//    public SellerService(SellerRepository sellerRepository) {
//        this.sellerRepository = sellerRepository;
//    }
//
//    public SellerDTO save(SellerDTO sellerDTO) {
//        var seller = SellerDTO.ofDto(sellerDTO);
//        seller.setDateCreated(LocalDateTime.now());
//
//        return SellerDTO.of(sellerRepository.save(seller));
//    }
//
//    public SellerDTO update(SellerDTO sellerDTO) {
//        var sellerOptional = sellerRepository.findById(sellerDTO.getId());
//
//        if (sellerOptional.isEmpty()) {
//            throw new NotFoundException("Não localizado vendedor com id -> " + sellerDTO.getId());
//        }
//
//        var seller = sellerOptional.get();
//        seller.setName(sellerDTO.getName());
//        seller.setLastName(sellerDTO.getLastName());
//        seller.setAge(sellerDTO.getAge());
//        seller.setPhone(sellerDTO.getPhone());
//        seller.setDateUpdated(LocalDateTime.now());
//
//        return SellerDTO.of(sellerRepository.save(seller));
//    }
//
//    public List<SellerDTO> getAll() {
//        List<Seller> sellers = sellerRepository.findAll();
//
//        return sellers.stream().map(SellerDTO::of).collect(Collectors.toList());
//    }
//
//    public SellerDTO getById(String id) {
//        Optional<Seller> sellerOptional = sellerRepository.findById(id);
//
//        if (sellerOptional.isEmpty()) {
//            throw new NotFoundException("Não localizado vendedor com id -> " + id);
//        }
//
//        return SellerDTO.of(sellerOptional.get());
//    }
//
//    public void deleteById(String id) {
//        sellerRepository.deleteById(id);
//    }
//}
