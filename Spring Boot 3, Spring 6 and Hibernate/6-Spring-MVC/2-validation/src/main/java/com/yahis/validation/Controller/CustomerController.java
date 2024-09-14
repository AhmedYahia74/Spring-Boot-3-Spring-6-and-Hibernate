package com.yahis.validation.Controller;

import com.yahis.validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @InitBinder
    void builder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/customerForm")
    public String customerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @GetMapping("/ConfirmCustomer")
    public String confirm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "GG";
    }

}
