package com.example.springboot.controller;

import com.example.springboot.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class FileController {

    @Value("${file.location}")
    private String fileLocation;

    @PostMapping("/admin/uploadArticleImg")
    public Result<List<String>> uploadArticleImg(@RequestParam("_img") MultipartFile[] formdata){
        List<String> list = new ArrayList<>();
        if(formdata.length>0){
            for (MultipartFile uploadFile : formdata) {
                String fileName = uploadFile.getOriginalFilename();
                if (fileName == null) {
                    Random r = new Random();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
                    String format = sdf.format(new Date());
                    fileName = r.nextInt(100) + format;
                }
                try {
                    uploadFile.transferTo(new File(fileLocation+"url?", uploadFile.getOriginalFilename()));
//                    String filePath = request.getScheme() + "://" + request.getServerName() + "/" + fileName;
//                    list.add(filePath);
                    list.add("localhost:8080/img/"+fileName);
                } catch (IOException e) {
                    Result.fail();
                }
            }
        }
        return Result.ok(list);
    }

    @GetMapping(value = "/img/{url}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable String url) throws IOException{
        File file = new File(fileLocation+url);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
