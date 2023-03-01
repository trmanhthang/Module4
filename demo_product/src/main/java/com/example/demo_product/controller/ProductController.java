package com.example.demo_product.controller;

import com.example.demo_product.model.Product;
import com.example.demo_product.service.ICoreService;
import com.example.demo_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("productList")
public class ProductController {
    @Value("${upload}")
    String value;

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        MultipartFile multipartFile = product.getImg();
        product.setImgPath(multipartFile.getOriginalFilename());
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),new File(value + product.getImgPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        iProductService.create(product);
        return "redirect:/productList";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        iProductService.delete(id);
        return "redirect:/productList";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("product", iProductService.findById(id));
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("product", iProductService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Product product) {
        iProductService.update(product);
        return "redirect:/productList";
    }
}

