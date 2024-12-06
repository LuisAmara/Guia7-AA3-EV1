package com.springboot.appCl.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.appCl.models.entity.Clientes;

public interface Cliente_Repository extends CrudRepository<Clientes, Long> {

}
