package com.folder.boot.components;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponeent {

  private Map<String, Object> resultMap;
  private String lastPath = "/upload";
  private String middlePath = "/src/main/resources/static";
  private String getRootPath() {return new File("").getAbsolutePath();}
  private String getCurrnetDatePath() {return "/".concat(new SimpleDateFormat("yyyyMMdd").format(new Date()));}
  private String getName(MultipartFile file) {return file.getOriginalFilename();}
  private String setName() {return Long.toString(System.nanoTime());}
  private String getExtension(MultipartFile file) {
    String contentType = file.getContentType();
    String name = getName(file);
    String originalFileExtension = "";
    if (!ObjectUtils.isEmpty(contentType)){
        if(contentType.contains("image/jpeg")){originalFileExtension = ".jpg";}
        else if(contentType.contains("image/png")){originalFileExtension = ".png";}
        else if(contentType.contains("image/gif")){originalFileExtension = ".gif";}
        else if(name.lastIndexOf(".") > 0){originalFileExtension = name.substring(name.lastIndexOf("."), name.length());}
    }
    return originalFileExtension;
  }

  public Map<String, Object> setFile(MultipartFile multipartFile) {
    resultMap = new HashMap<>();
    resultMap.put("Root", getRootPath());
    resultMap.put("Middle", middlePath);
    resultMap.put("LastPath", lastPath);
    resultMap.put("CurrnetDate", getCurrnetDatePath());
    resultMap.put("Name", getName(multipartFile));
    resultMap.put("NewName", setName());
    resultMap.put("Extension", getExtension(multipartFile));
    return resultMap;
  }

}
