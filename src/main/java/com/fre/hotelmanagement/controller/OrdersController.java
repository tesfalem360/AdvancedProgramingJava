package com.fre.hotelmanagement.controller;

import com.fre.hotelmanagement.model.FoodItem;
import com.fre.hotelmanagement.model.Orders;
import com.fre.hotelmanagement.repository.FoodItemRepository;
import com.fre.hotelmanagement.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrdersController {

        @Autowired
        OrdersRepository ordersRepository;

@Autowired
    FoodItemRepository foodItemRepository;
        @RequestMapping(value = "/orders/new", method = RequestMethod.GET)
        public String newOrdersForm(Model model){
            Orders orders=new Orders();
            model.addAttribute("orders", orders);
           List< FoodItem >foodItem= foodItemRepository.findAll();
            model.addAttribute("foodItems",foodItem);
            return "orders/new";
        }
        @RequestMapping(value = "/orders/new", method = RequestMethod.POST)
        public String saveOrders(Model model, Orders orders){
            //orders= ordersRepository.save(orders);
            ordersRepository.save(orders);

            model.addAttribute("orders", orders);
            return "redirect:/orders/list";

        }
        @RequestMapping(value = "/orders/list", method = RequestMethod.GET)
        public String findAllBench(Model model){

            List<Orders> orders= ordersRepository.findAll();

            model.addAttribute("orders", orders);
            //model.addAttribute("foodItem",foodItemRepository.findAll());
            return "orders/list";
        }
        @RequestMapping(value = "/orders/edit/{id}", method = RequestMethod.GET)
        public String editOrders(Model model,@PathVariable Long id){
            Orders orders= ordersRepository.findById(id).orElse(null);
            model.addAttribute("orders", orders);
            List< FoodItem >foodItem= foodItemRepository.findAll();
            model.addAttribute("foodItems",foodItem);
            return "orders/edit";
        }


        @RequestMapping(value = "/orders/edit", method = RequestMethod.POST)
        public String updateOrders(Model model,Orders orders){
            ordersRepository.save(orders);
            model.addAttribute("orders", orders);
            return "redirect:/orders/list";
        }

        @RequestMapping(value = "/orders/delete/{id}", method = RequestMethod.GET)
        public String deleteOrders(@PathVariable Long id){
            ordersRepository.deleteById(id);
            return "redirect:/orders/list";
        }
    }


