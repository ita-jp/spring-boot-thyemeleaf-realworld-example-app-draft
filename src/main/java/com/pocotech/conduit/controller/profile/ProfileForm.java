package com.pocotech.conduit.controller.profile;

public record ProfileForm(
        String imageURL,
        String username,
        String bio,
        String email,
        String password
) {
}
