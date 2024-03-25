package com.infinityc.com.co.controller;


import com.infinityc.com.co.model.entity.Cliente;
import com.infinityc.com.co.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente  create(@RequestBody Cliente cliente){
       return   clienteService.save(cliente);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("cliente")
    public Cliente  update(@RequestBody Cliente cliente){
        return   clienteService.save(cliente);
    }
    //    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
       try{
           Cliente clienteDelete = clienteService.findById(id);
           clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete,HttpStatus.NO_CONTENT);
        }catch(DataAccessException exDt){
           response.put("mensaje",exDt.getMessage());
           response.put("cliente",null);
           return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("cliente/{id}")
    public  Cliente  showById(@PathVariable Integer id){
     return clienteService.findById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("cliente")
    public List<Cliente> showAll() {
        return clienteService.getAllClientes();
    }




}
