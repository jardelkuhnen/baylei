package br.com.baylei.api;

import br.com.baylei.dto.SellerDTO;

import java.util.List;

public interface SellerService {

    SellerDTO save(SellerDTO sellerDTO);

    SellerDTO update(SellerDTO sellerDTO);

    List<SellerDTO> getAll();

    SellerDTO getById(String id);

    void deleteById(String id);

}
