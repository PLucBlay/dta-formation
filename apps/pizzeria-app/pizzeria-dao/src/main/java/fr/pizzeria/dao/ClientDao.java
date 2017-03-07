package fr.pizzeria.dao;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Client;

public class ClientDao implements IDao<Client, Integer> {
	private List<Client> listeClients;
	private Scanner scan;

	public ClientDao(List<Client> listeClients, Scanner scan) {
		this.scan = scan;
		this.listeClients = listeClients;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNew(Client cli) throws SaveException {
		try {
			listeClients.add(cli);
		} catch (Exception e) {
			throw new SaveException(e);
		}

	}

	@Override
	public void update(Integer id, Client cli) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws DeleteException {
		if (exist(id)) {
			listeClients.remove(get(id));
		} else {
			throw new DeleteException();
		}
	}

	public Scanner getScanner() {
		return scan;
	}

	@Override
	public boolean exist(Integer id) {
		for (Client cli : listeClients) {
			if (cli.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public Client get(Integer id) {
		for (Client cli : listeClients) {
			if (cli.getId().equals(id)) {
				return cli;
			}
		}
		return null;
	}
}
