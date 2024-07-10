package com.example.servicebolsa.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

@GetMapping("/test")
    public String testEndpoint()
{
    return"Test end point is working";
}
}