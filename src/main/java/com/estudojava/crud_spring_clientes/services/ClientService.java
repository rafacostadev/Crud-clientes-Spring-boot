package com.estudojava.crud_spring_clientes.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudojava.crud_spring_clientes.dto.ClientDTO;
import com.estudojava.crud_spring_clientes.entities.Client;
import com.estudojava.crud_spring_clientes.repository.ClientRepository;
import com.estudojava.crud_spring_clientes.services.exceptions.DbException;
import com.estudojava.crud_spring_clientes.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable).map(x -> modelMapper.map(x, ClientDTO.class));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		try {
			Optional<Client> result = clientRepository.findById(id);
			return modelMapper.map(result.get(), ClientDTO.class);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		return modelMapper.map(clientRepository.save(modelMapper.map(dto, Client.class)), ClientDTO.class);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		if (!clientRepository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		} else {
			Client client = clientRepository.getReferenceById(id);
			client.setBirthDate(dto.getBirthDate());
			client.setChildren(dto.getChildren());
			client.setCpf(dto.getCpf());
			client.setIncome(dto.getIncome());
			client.setName(dto.getName());
			return modelMapper.map(clientRepository.save(client), ClientDTO.class);
		}
	}

	@Transactional
	public void delete(Long id) {
		if (!clientRepository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}
		try {
			clientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DbException("Falha na integridade referencial!");
		}
	}
}
