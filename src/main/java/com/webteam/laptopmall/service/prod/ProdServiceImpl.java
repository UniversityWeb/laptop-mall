package com.webteam.laptopmall.service.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.exception.ProductNotFoundException;
import com.webteam.laptopmall.mapper.ProductMapper;
import com.webteam.laptopmall.repository.prod.ProdRepos;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdServiceImpl implements ProdService {

    private ProdRepos prodRepos;

    public ProdServiceImpl() {
        prodRepos = new ProdReposImpl();
    }

    @Override
    public ProductDTO save(ProductDTO prodDTO) {
        Product prod = ProductMapper.toEntity(prodDTO);
        Product saved = prodRepos.save(prod);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public ProductDTO update(ProductDTO prodDTO) {
        Product prod = ProductMapper.toEntity(prodDTO);
        Product updated = prodRepos.update(prod);
        return ProductMapper.toDTO(updated);
    }

    @Override
    public ProductDTO deleteById(Long id) {
        Product deleted = prodRepos.deleteById(id);
        return ProductMapper.toDTO(deleted);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product prod = prodRepos.getById(id)
                .orElseThrow(() -> new ProductNotFoundException("Could not find any products with id=" + id));
        return ProductMapper.toDTO(prod);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> prods = prodRepos.getAll();
        return prods.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
