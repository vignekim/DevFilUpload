package com.folder.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.folder.boot.components.FileComponeent;

@Controller
public class FileController {

  @Autowired FileComponeent fc;

  @PostMapping("/fileUpload")
  public String fileUpload(@RequestParam("file") MultipartFile file) {
    if(!file.isEmpty()){
      //System.out.println(fc.setFile(file));
      System.out.println(fc.upload(file));
    }
    return "redirect:/";
  }

}
