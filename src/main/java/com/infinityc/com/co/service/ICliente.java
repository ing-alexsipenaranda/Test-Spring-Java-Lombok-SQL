package com.infinityc.com.co.service;

import com.infinityc.com.co.model.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICliente {
    Cliente save(Cliente cliente);

    Cliente findById(Integer id);

    void delete(Cliente  cliente);
    List<Cliente> getAllClientes(); // Agregamos este método





}
