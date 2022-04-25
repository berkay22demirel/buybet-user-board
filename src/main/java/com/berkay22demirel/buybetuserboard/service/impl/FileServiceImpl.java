package com.berkay22demirel.buybetuserboard.service.impl;

import com.berkay22demirel.buybetuserboard.config.FileConfiguration;
import com.berkay22demirel.buybetuserboard.exception.BuybetUnexpectedException;
import com.berkay22demirel.buybetuserboard.service.UserFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements UserFileService {

    private final FileConfiguration fileConfiguration;

    @Override
    public String saveProfileImage(String image, String oldProfileImageName) {
        // TODO - must resize image and change format
        String profileImageName = UUID.randomUUID().toString();
        String filePath = fileConfiguration.getUserProfileImagePath() + "/" + profileImageName + ".jpg";
        writeBase64EncodedStringToFile(filePath, image);
        deleteProfileImage(oldProfileImageName);
        return profileImageName;
    }

    @Override
    public void deleteProfileImage(String profileImageName) {
        deleteFile(Paths.get(fileConfiguration.getUserProfileImagePath(), profileImageName + ".jpg"));
    }

    private void writeBase64EncodedStringToFile(String filePath, String file) {
        try {
            File target = new File(filePath);
            OutputStream outputStream = new FileOutputStream(target);

            byte[] base64encoded = Base64.getDecoder().decode(file);

            outputStream.write(base64encoded);
            outputStream.close();
        } catch (Exception e) {
            throw new BuybetUnexpectedException("buybet.unexpected.error");
        }
    }

    public void deleteFile(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (Exception e) {
            throw new BuybetUnexpectedException("buybet.unexpected.error");
        }
    }


}
