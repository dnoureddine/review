package com.org.contoller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.Role;
import com.org.metierInter.IMetierClient;

@Controller
public class ClientController {

	@Autowired
	private IMetierClient metierClient;
		
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/**
	 * redirection to inscription page
	 */
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscription(Model model) {
		model.addAttribute("client", new Client());
		return "inscription";
	}
	
	/**
	 * redirection to inscription faild page
	 */
	@RequestMapping(value = "/inscriptionFailed", method = RequestMethod.GET)
	public String inscriptionFailed(Model model) {
		return "inscription";
	}
	
	
	/**
	 * accout activation
	 */
	@RequestMapping(value = "/accountActivation", method = RequestMethod.GET)
	public String accountActivation(Model model) {
		return "accountActivation";
	}
	
	/**
	 * save Client
	 */
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public ModelAndView saveClient(@Valid Client client,BindingResult bindingResult,RedirectAttributes redir) {
		if(bindingResult.hasErrors()){
			redir.addFlashAttribute("client",client);
			return new ModelAndView("redirect:../inscriptionFailed");
		}else{
			
			//Steps for creating a account
			/*
			 * 1- create a account
			 * 2- create a domain and a associate to this account
			 * 3- create a configuration and add it to this domain
			 * 4- create a user and associate it to this domain and to the account
			 * 5- add the admin roles to this user
			 * 6- send a message for account activation
			 */
			
			
			// 4- create user and associate it this account and to the domain
			if(client!=null){
				
				//make sure that the Username is Unique
				if(metierClient.getClientByUserName(client.getUsername())==null){
					client.setEnabled(true);
					metierClient.addClient(client);
				
									
					//add client Roles
					Role role = new Role("ROLE_ADMIN_DOMAIN");
					metierClient.addRole(client, role);
					
		
                    
                    //send a message to activate the count !!!
					
                    //
					return new ModelAndView("redirect:/accountActivation");
				}else{
					redir.addFlashAttribute("username_exist","Sorry the Username ist already registried");
					redir.addFlashAttribute("client",client);
					return new ModelAndView("redirect:/inscriptionFailed");
				}
				
			}else{
				return new ModelAndView("redirect:/inscriptionFailed");
			}
		}
	}
	
	
}
