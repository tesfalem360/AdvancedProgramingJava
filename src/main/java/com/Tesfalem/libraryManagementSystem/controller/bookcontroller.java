package com.Tesfalem.libraryManagementSystem.controller;

import com.Tesfalem.libraryManagementSystem.model.book;
import com.Tesfalem.libraryManagementSystem.repository.Irepositorybook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class bookcontroller {
    @Autowired
    Irepositorybook bookItemRepository;


    @RequestMapping(value = "/book/new", method = RequestMethod.GET)
    public String newbookForm(Model model){
        model.addAttribute("book", new book());
        return "book/new";
    }
    @RequestMapping(value = "/book/new", method = RequestMethod.POST)
    public String saveFoodItem(Model model, book book){
        bookItemRepository.save(book);
        model.addAttribute("book", book);
        return "redirect:/book/list";

    }
    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public String findAllbook(Model model){
        //List<Bench> bench= benchService.findAll();
        List<book> book= bookItemRepository.findAll();
        model.addAttribute("book", book);
        return "book/list";
    }
    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String editBook(Model model,@PathVariable Long id){
        book book= bookItemRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "book/edit";
    }


    @RequestMapping(value = "/book/edit", method = RequestMethod.POST)
    public String updatebook(Model model, book book){
        bookItemRepository.save(book);
        model.addAttribute("book", book);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
    public String deleteFoodItem(@PathVariable Long id){
        bookItemRepository.deleteById(id);
        return "redirect:/book/list";
    }
}

