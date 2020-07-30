package app.controller;

import app.service.UploadService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@AllArgsConstructor
@Controller
public class UploadController {

    private final UploadService uploadService;

    @GetMapping("upload")
    ModelAndView handleUpload(){
        return new ModelAndView("index");
    }

    @PostMapping("upload")
    RedirectView handleUpload(@RequestParam MultipartFile image){
        String url = uploadService.uploadFile(image);
        log.info(url);
        return new RedirectView("/upload");
    }
}
