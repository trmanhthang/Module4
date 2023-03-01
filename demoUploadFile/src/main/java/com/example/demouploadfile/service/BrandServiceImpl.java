package com.example.demouploadfile.service;

import com.example.demouploadfile.model.Brand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements ICrudService<Brand> {

    private final List<Brand> brandList;

    public BrandServiceImpl() {
        brandList = new ArrayList<>();
        brandList.add(new Brand("C10"));
        brandList.add(new Brand("C08"));
    }
    @Override
    public List<Brand> findAll() {
        return brandList;
    }

    @Override
    public Brand findById(Integer id) {
        for (Brand brand : brandList) {
            if (brand.getId().equals(id)) {
                return brand;
            }
        }
        return null;
    }

    @Override
    public void save(Brand brand) {
        brandList.add(brand);
    }

    @Override
    public void delete(Brand brand) {

    }
}
