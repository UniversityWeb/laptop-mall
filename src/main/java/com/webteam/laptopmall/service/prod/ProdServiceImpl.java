package com.webteam.laptopmall.service.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.exception.ProductNotFoundException;
import com.webteam.laptopmall.mapper.ProductMapper;
import com.webteam.laptopmall.repository.prod.ProdRepos;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;

import java.util.List;
import java.util.Random;
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

    @Override
    public Long createNewProdID() {
        Long prodID=  generateRandomId();
        while(getById(prodID) != null)
            prodID=  generateRandomId();
        return prodID;
    }

    public static long generateRandomId() {
        Random random = new Random();
        long randomId = random.nextLong();

        return randomId;
    }

}
