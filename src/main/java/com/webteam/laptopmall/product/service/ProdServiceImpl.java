package com.webteam.laptopmall.product.service;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.entity.Product;
import com.webteam.laptopmall.product.ProductNotFoundException;
import com.webteam.laptopmall.product.ProductMapper;
import com.webteam.laptopmall.product.repos.ProdRepos;
import com.webteam.laptopmall.product.repos.ProdReposImpl;

import java.util.ArrayList;
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

    @Override
    public List<ProductDTO> getProdsByModel(String model) {
        List<Product> prods = prodRepos.getProdsByModel(model);
        return prods.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProdsByCategory(ECategory eCategory) {
        List<Product> prods = prodRepos.getProdsByCategory(eCategory);
        return prods.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String [] getNameFromList(List<ProductDTO> topBestSellProducts) {
        List<String> listProductNames = new ArrayList<>();
        topBestSellProducts.forEach(productDTO -> listProductNames.add(productDTO.getModel()));
        return listProductNames.toArray(new String[0]);
    }

    @Override
    public int markProductAsDeleted(Long prodId) {
        return prodRepos.markProductAsDeleted(prodId);
    }

    @Override
    public List<ProductDTO> getProdsIsAvailable() {
        List<Product> prods = prodRepos.getProdsIsAvailable();
        return prods.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
