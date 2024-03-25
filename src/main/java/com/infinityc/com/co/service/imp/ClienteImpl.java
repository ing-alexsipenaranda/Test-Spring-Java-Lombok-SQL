package com.infinityc.com.co.service.imp;

import com.infinityc.com.co.model.dao.ClienteDao;
import com.infinityc.com.co.model.entity.Cliente;
import com.infinityc.com.co.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteImpl implements  ICliente{

    @Autowired
    private ClienteDao clienteDao;
@Bui
    @Override
    public List<Cliente> getAllClientes() {
        Iterable<Cliente> clientesIterable = clienteDao.findAll();
        List<Cliente> clientesList = new ArrayList<>();
        clientesIterable.forEach(clientesList::add);
        return clientesList;
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);

    }
    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }



}
