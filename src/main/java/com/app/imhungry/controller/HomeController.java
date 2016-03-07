package com.app.imhungry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.imhungry.model.Cook;
import com.app.imhungry.service.CookService;
import com.app.imhungry.util.DataTablesJsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class HomeController {
  	
    private CookService cookService;
    
    @Autowired(required=true)
  //  @Qualifier(value="cookServiceImpl")
    public void setCookService(CookService cookService){
        this.cookService = cookService;
    }
	             
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(@ModelAttribute("cook") Cook cook, 
        		                   BindingResult result,
        		                   ModelMap model, 
        		                   HttpServletRequest request, 
        		                   HttpServletResponse response) {
      	return "home";
    }
    
    @RequestMapping(value = "/cooksList", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String paginationDataTables(HttpServletRequest  request) throws IOException {
		
    	//Fetch Page display length
    	Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
    	    	
    	//Fetch the page number from client
    	Integer pageNumber = 0;
    	if (null != request.getParameter("iDisplayStart"))
    		pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/5)+1;		
    	
    	//Fetch search parameter
    	String searchParameter = request.getParameter("sSearch");
    	    	
    	//Create page list data
    	Page<Cook> page = cookService.list(pageNumber, pageDisplayLength, cookService.orderBy());
    	List<Cook> cooksList = page.getContent();
    			
        //Here is server side pagination logic. Based on the page number you could make call 
		//to the data base create new list and send back to the client. For demo I am shuffling 
		//the same list to show data randomly
		
    	/*
    	if (pageNumber == 1) {
			Collections.shuffle(cooksList);
		}else if (pageNumber == 2) {
			Collections.shuffle(cooksList);
		}else {
			Collections.shuffle(cooksList);
		}
		*/
    	
		//Search functionality: Returns filtered list based on search parameter
		//personsList = getListBasedOnSearchParameter(searchParameter,personsList);
				
		DataTablesJsonObject cooksJsonObject = new DataTablesJsonObject();
		//Set Total display record
		cooksJsonObject.setiTotalDisplayRecords(cooksList.size());
		//Set Total record
		//cooksJsonObject.setiTotalRecords(cooksList.size());
		
		cooksJsonObject.setAaData(cooksList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(cooksJsonObject);
	
		return json2;
    } 
       
}
