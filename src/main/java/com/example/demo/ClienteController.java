package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    private final ClienteRepository repository;

    ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/clientes")
    List<Cliente> all() {
        return repository.findAll();
    }

    @PostMapping("/clientes")
    Cliente newCliente(@RequestBody Cliente newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/cliente/{id}")
    Cliente one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @PutMapping("/cliente/{id}")
    Cliente replaceCliente(@RequestBody Cliente newCliente, @PathVariable Long id) {

        return repository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(newCliente.getNombre());
                    cliente.setApellido(newCliente.getApellido());
                    return repository.save(cliente);
                })
                .orElseGet(() -> {
                    newCliente.setId(id);
                    return repository.save(newCliente);
                });
    }

    @DeleteMapping("/cliente/{id}")
    void deleteCliente(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
