package com.pocotech.conduit.controller;

public record RegistrationForm(
        String username,
        String email,
        String password
) {
}
