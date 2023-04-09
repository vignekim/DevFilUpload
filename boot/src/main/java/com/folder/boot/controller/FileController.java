package com.folder.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folder.boot.components.FileComponent;

@Controller
public class FileController {

  @Autowired FileComponent fc;

  @PostMapping("/fileUpload")
  public String fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes ra) {
    if(!file.isEmpty()){
      //System.out.println(fc.setFile(file));
      //System.out.println(fc.upload(file));
      ra.addAttribute("url", fc.upload2(file));
    }
    //return "redirect:/";
    return "redirect:/view";
  }

  @GetMapping("/view")
  public ResponseEntity<?> view(@RequestParam("url") String url) {
    return fc.getFile(url);
  }

}
