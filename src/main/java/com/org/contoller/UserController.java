package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.Client;
import com.org.entities.Role;
import com.org.metierInter.IMetierClient;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class UserController {
	
	@Autowired
	private IMetierClient metierClient;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	// profile of the Fahrlehrer
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String editProfile(Model model,Long idUser, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
	    model.addAttribute("user", client);
		return "user/user";
	}
	
	
	//new User
	@RequestMapping(value = "editUser", method = RequestMethod.GET)
	public String editUser(Model model,Long idUser, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
	    model.addAttribute("user", metierClient.getClient(idUser));
		return "user/user";
	}
	
	//new domain
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String newUser(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
	    model.addAttribute("user",new Client());
		return "user/user";
	}
	
	//save a User
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(Model model,Client user,Principal principal,RedirectAttributes redirecAtrributes) {
		Message message=null;
		Client client = metierClient.getClientByUserName(principal.getName());
		if(user.getIdClient()==null){				
			//add a new User
			user.setEnabled(true);
			metierClient.addClient(user);
			
			//add client Roles
			Role role = new Role("ROLE_ADMIN_DOMAIN");
			metierClient.addRole(user, role);
		
			message = new Message("The User has been successfuly saved","success");
		}
		else{
			
			//update the user
			client.setName(user.getName());
			client.setPrenom(user.getPrenom());
			client.setEmail(user.getEmail());
			client.setPhone(user.getPhone());
			client.setPassword(user.getPassword());
			client.setUsername(user.getUsername());
			
			metierClient.updateClient(client);
			
			message = new Message("The User has been successfuly saved","success");
		}
		
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:profile");
	}
			

}
