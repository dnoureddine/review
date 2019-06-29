package com.org.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Client implements UserDetails,Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	
	@NotEmpty(message="Please Enter Your Name")
	private String name;
	
	private String prenom;
	
	private String phone;
	private String email;
	
	@NotEmpty(message="Please Enter Your Adresse Email")
	private String username;
	
	@NotEmpty(message="Please Enter Your PassWord")
	private String password;

	
	private boolean enabled = true;
	

	@OneToMany(mappedBy="client")
	private List<Role> roles;
	

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(Long idClient, String name, String prenom, String username,
			String password, Date dateNaissance, String phone, String email) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	
	public Client(String name, String prenom, String username, String password,
			Date dateNaissance, boolean enabled, String phone, String email) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.phone = phone;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
