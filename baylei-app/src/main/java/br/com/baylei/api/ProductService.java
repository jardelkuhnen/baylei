package br.com.baylei.api;

import br.com.baylei.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    List<ProductDTO> getAll();

    ProductDTO getById(String id);

    void deleteById(String id);

    List<ProductDTO> findByIds(List<String> productsIds);

}
