package com.berkay22demirel.buybetuserboard.service;

public interface UserFileService {

    String saveProfileImage(String image, String oldProfileImageName);

    void deleteProfileImage(String profileImageName);
}
