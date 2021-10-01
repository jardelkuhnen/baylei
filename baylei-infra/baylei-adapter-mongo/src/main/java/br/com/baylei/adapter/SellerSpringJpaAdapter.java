package br.com.baylei.adapter;

import br.com.baylei.entity.ClientEntity;
import br.com.baylei.entity.SellerEntity;
import br.com.baylei.model.Client;
import br.com.baylei.model.Seller;
import br.com.baylei.ports.SellerPersistencePort;
import br.com.baylei.repository.ClientRepository;
import br.com.baylei.repository.SellerRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SellerSpringJpaAdapter implements SellerPersistencePort {

    private final SellerRepository sellerRepository;

    public SellerSpringJpaAdapter(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }


    @Override
    public Seller save(Seller seller) {
        var sellerEntity = new SellerEntity();
        BeanUtils.copyProperties(seller, sellerEntity);
        BeanUtils.copyProperties(sellerRepository.save(sellerEntity), seller);
        return seller;
    }

    @Override
    public List<Seller> getAll() {
        List<Seller> sellers = new ArrayList<>();
        List<SellerEntity> sellerEntities = sellerRepository.findAll();

        for (SellerEntity entity: sellerEntities) {
            var seller = new Seller();
            BeanUtils.copyProperties(entity, seller);
            sellers.add(seller);
        }

        return sellers;
    }

    @Override
    public Seller getById(String id) {
        Optional<SellerEntity> sellerEntityOptional = sellerRepository.findById(id);

        if(!sellerEntityOptional.isPresent()) {
            return null;
        }

        var seller = new Seller();

        BeanUtils.copyProperties(sellerEntityOptional.get(), seller);
        return seller;
    }

    @Override
    public Seller update(Seller seller) {
        Optional<SellerEntity> sellerEntityOptional = sellerRepository.findById(seller.getId());

        if(!sellerEntityOptional.isPresent()) {
            return null;
        }

        var sellerEntity = sellerEntityOptional.get();
        BeanUtils.copyProperties(seller, sellerEntity);
        BeanUtils.copyProperties(sellerRepository.save(sellerEntity), seller);

        return seller;
    }

    @Override
    public void deleteById(String id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public List<Seller> getAllById(List<String> sellersId) {
        List<Seller> sellers = new ArrayList<>();
        sellerRepository.findAllById(sellersId).forEach(entity -> {
            var seller = new Seller();
            BeanUtils.copyProperties(entity, seller);
            sellers.add(seller);
        });

        return sellers;
    }
}
