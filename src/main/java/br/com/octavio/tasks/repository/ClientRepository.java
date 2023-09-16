package br.com.octavio.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.octavio.tasks.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	//adds other dynamic methods
}

