package com.example.demo;

class ClienteNotFoundException extends RuntimeException {

    ClienteNotFoundException(Long id) {
        super("Cliente con id: " + id + " no existe");
    }
}
