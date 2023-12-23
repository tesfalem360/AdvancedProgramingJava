package com.fre.hotelmanagement.controller;

import com.fre.hotelmanagement.model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(value = "")
    public String home(){
        return "redirect:/Home/index";
    }
    @RequestMapping(value = "/Home/index")
    public String homedisplay(){
        return "Home/index";
    }

}
