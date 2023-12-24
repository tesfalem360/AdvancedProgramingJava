package com.Tesfalem.libraryManagementSystem.controller;

import com.Tesfalem.libraryManagementSystem.model.book;
import com.Tesfalem.libraryManagementSystem.repository.Irepositorybook;
import com.Tesfalem.libraryManagementSystem.repository.Irepositoryreadingbook;
import com.Tesfalem.libraryManagementSystem.model.readingbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class readingbookController {
    @Autowired
    Irepositoryreadingbook irepositoryreadingbook;

    @Autowired
    Irepositorybook irepositorybook;
    @RequestMapping(value = "/readingbook/new", method = RequestMethod.GET)
    public String newreadingbookForm(Model model){
        readingbook readingbook=new readingbook();
        model.addAttribute("readingbook", readingbook);
        List<book> book= irepositorybook.findAll();
        model.addAttribute("books",book);
        return "readingbook/new";
    }
    @RequestMapping(value = "/readingbook/new", method = RequestMethod.POST)
    public String savereadingbook(Model model, readingbook readingbook){
        //orders= ordersRepository.save(orders);
        irepositoryreadingbook.save(readingbook);

        model.addAttribute("readingbook", readingbook);
        return "redirect:/readingbook/list";

    }
    @RequestMapping(value = "/readingbook/list", method = RequestMethod.GET)
    public String findAllreadingbook(Model model){

        List<readingbook> readingbook= irepositoryreadingbook.findAll();

        model.addAttribute("readingbook", readingbook);

        return "readingbook/list";
    }
    @RequestMapping(value = "/readingbook/edit/{id}", method = RequestMethod.GET)
    public String editreadingbook(Model model,@PathVariable Long id){
        readingbook readingbook= irepositoryreadingbook.findById(id).orElse(null);
        model.addAttribute("readingbook", readingbook);
        List<book>book= irepositorybook.findAll();
        model.addAttribute("books",book);
        return "readingbook/edit";
    }


    @RequestMapping(value = "/readingbook/edit", method = RequestMethod.POST)
    public String updatereadingbook(Model model,readingbook readingbook){
        irepositoryreadingbook.save(readingbook);
        model.addAttribute("readingbook", readingbook);
        return "redirect:/readingbook/list";
    }

    @RequestMapping(value = "/readingbook/delete/{id}", method = RequestMethod.GET)
    public String deletereadingbook(@PathVariable Long id){
        irepositoryreadingbook.deleteById(id);
        return "redirect:/readingbook/list";
    }
}
