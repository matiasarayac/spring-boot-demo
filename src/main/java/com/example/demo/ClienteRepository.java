package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
