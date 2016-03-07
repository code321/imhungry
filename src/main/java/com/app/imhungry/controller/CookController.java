package com.app.imhungry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.imhungry.model.Cook;
import com.app.imhungry.service.CookService;

@Controller
public class CookController {
	
   private CookService cookService;
    
    @Autowired(required=true)
    @Qualifier(value="cookServiceImpl")
    public void setCookService(CookService cookService){
        this.cookService = cookService;
    }
  
    @RequestMapping(value = "/cooks", method = RequestMethod.GET)
    public String listCooks(Model model) {
        model.addAttribute("cook", new Cook());
      //  model.addAttribute("listCooks", this.cookService.list(cookService.orderBy()));
        return "cook";
    }
    
    
    //For add and update person both
    @RequestMapping(value= "/cook/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("cook") Cook cook){
         
        if(cook.getId() == 0){
            //new person, add it
            this.cookService.add(cook);
        }else{
            //existing person, call update
            this.cookService.update(cook);
        }
         
        return "redirect:/";         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") long id){
         
        this.cookService.remove(id);
        return "redirect:/";
    }
  
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") long id, Model model){
        model.addAttribute("cook", this.cookService.getById(id));
        model.addAttribute("listCooks", this.cookService.list(cookService.orderBy()));
        return "cook";
    }
    

}
