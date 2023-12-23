package com.fre.hotelmanagement.controller;

import com.fre.hotelmanagement.model.FoodItem;
import com.fre.hotelmanagement.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class FoodItemController {

    @Autowired
    FoodItemRepository foodItemRepository;


    @RequestMapping(value = "/foodItem/new", method = RequestMethod.GET)
    public String newFoodItemForm(Model model){
        model.addAttribute("foodItem", new FoodItem());
        return "foodItem/new";
    }
    @RequestMapping(value = "/foodItem/new", method = RequestMethod.POST)
    public String saveFoodItem(Model model, FoodItem foodItem){
        //foodItem= foodItemRepository.save(foodItem);
        foodItemRepository.save(foodItem);
        model.addAttribute("foodItem", foodItem);
        return "redirect:/foodItem/list";

    }
    @RequestMapping(value = "/foodItem/list", method = RequestMethod.GET)
    public String findAllBench(Model model){
        //List<Bench> bench= benchService.findAll();
        List<FoodItem> foodItem= foodItemRepository.findAll();
        model.addAttribute("foodItem", foodItem);
        return "foodItem/list";
    }
    @RequestMapping(value = "/foodItem/edit/{id}", method = RequestMethod.GET)
    public String editFoodItem(Model model,@PathVariable Long id){
        FoodItem foodItem= foodItemRepository.findById(id).orElse(null);
        model.addAttribute("foodItem", foodItem);
        return "foodItem/edit";
    }


    @RequestMapping(value = "/foodItem/edit", method = RequestMethod.POST)
    public String updateFoodItem(Model model,FoodItem foodItem){
        foodItemRepository.save(foodItem);
        model.addAttribute("foodItem", foodItem);
        return "redirect:/foodItem/list";
    }

    @RequestMapping(value = "/foodItem/delete/{id}", method = RequestMethod.GET)
    public String deleteFoodItem(@PathVariable Long id){
        foodItemRepository.deleteById(id);
        return "redirect:/foodItem/list";
    }
}
