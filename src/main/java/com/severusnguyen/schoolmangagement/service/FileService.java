package com.severusnguyen.schoolmangagement.service;

import com.severusnguyen.schoolmangagement.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {

    @Value("${fileUpload.rootPath}")
    private String rootPath;
    private Path root;

    public void init(){
        try {
            root = Paths.get(rootPath);
            if (Files.notExists(root)){
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            System.out.println("Error create folder root: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try {
            init();
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error save file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Resource loadFile(String fileName) {
        try {
            init();
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }
        }catch (Exception e){
            System.out.println("Error load file: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
