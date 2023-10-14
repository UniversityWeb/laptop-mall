package com.webteam.laptopmall.service.prod;

import com.webteam.laptopmall.dto.ProductDTO;
import com.webteam.laptopmall.entity.Product;
import com.webteam.laptopmall.exception.ProductNotFoundException;
import com.webteam.laptopmall.mapper.ProductMapper;
import com.webteam.laptopmall.mapper.UserMapper;
import com.webteam.laptopmall.repository.prod.ProductRepos;
import com.webteam.laptopmall.repository.prod.ProductReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdServiceImpl implements ProdService {

    private ProductRepos prodRepos;
    private ProductMapper mapper;

    public ProdServiceImpl() {
        prodRepos = new ProductReposImpl();
        mapper = ProductMapper.INSTANCE;
    }

    @Override
    public ProductDTO save(ProductDTO prodDTO) {
        Product prod = mapper.toEntity(prodDTO);
        Product saved = prodRepos.save(prod);
        return mapper.toDTO(saved);
    }

    @Override
    public ProductDTO update(ProductDTO prodDTO) {
        Product prod = mapper.toEntity(prodDTO);
        Product updated = prodRepos.update(prod);
        return mapper.toDTO(updated);
    }

    @Override
    public ProductDTO deleteById(Long id) {
        Product deleted = prodRepos.deleteById(id);
        return mapper.toDTO(deleted);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product prod = prodRepos.getById(id)
                .orElseThrow(() -> new ProductNotFoundException("Could not find any products with id=" + id));
        return mapper.toDTO(prod);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> prods = prodRepos.getAll();
        return prods.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
