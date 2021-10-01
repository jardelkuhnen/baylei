package br.com.baylei.adapter;

import br.com.baylei.api.SellerService;
import br.com.baylei.dto.SellerDTO;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.model.Seller;
import br.com.baylei.ports.SellerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SellerServiceAdapter implements SellerService {

    private final SellerPersistencePort sellerPersistencePort;

    @Autowired
    public SellerServiceAdapter(SellerPersistencePort sellerPersistencePort) {
        this.sellerPersistencePort = sellerPersistencePort;
    }

    @Override
    public SellerDTO save(SellerDTO sellerDTO) {
        Seller seller = SellerDTO.ofDto(sellerDTO);
        seller.setDateCreated(LocalDateTime.now());

        return SellerDTO.of(sellerPersistencePort.save(seller));
    }

    @Override
    public SellerDTO update(SellerDTO sellerDTO) {
        var seller = sellerPersistencePort.getById(sellerDTO.getId());

        if (Objects.isNull(seller)) {
            throw new NotFoundException("Não localizado vendedor com id -> " + sellerDTO.getId());
        }

        seller.setName(sellerDTO.getName());
        seller.setLastName(sellerDTO.getLastName());
        seller.setAge(sellerDTO.getAge());
        seller.setPhone(sellerDTO.getPhone());
        seller.setDateUpdated(LocalDateTime.now());

        return SellerDTO.of(sellerPersistencePort.save(seller));
    }

    @Override
    public List<SellerDTO> getAll() {
        List<Seller> sellers = sellerPersistencePort.getAll();

        return sellers.stream().map(SellerDTO::of).collect(Collectors.toList());
    }

    @Override
    public SellerDTO getById(String id) {
        var seller = sellerPersistencePort.getById(id);

        if (Objects.isNull(seller)) {
            throw new NotFoundException("Não localizado vendedor com id -> " + id);
        }

        return SellerDTO.of(seller);
    }

    @Override
    public void deleteById(String id) {
        sellerPersistencePort.deleteById(id);
    }

}
