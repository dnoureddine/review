package com.org.metierInter;

import java.util.List;

import com.org.entities.Client;
import com.org.entities.Role;

public interface IMetierClient {
 
	public Client addClient(Client client);
	public Client getClient(Long id);
	public void deleteClient(Long id);
	public Client updateClient(Client client);
	public List<Client> listAllClients();
	public Client getClientByUserName(String userName) ;
	public Role addRole(Client client, Role role);

}
