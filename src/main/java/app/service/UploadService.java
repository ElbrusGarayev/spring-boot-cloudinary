package app.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@AllArgsConstructor
@Service
public class UploadService {

    private final Cloudinary cloudinaryConfig;

    public String uploadFile(MultipartFile file) {
        try {
            Map uploadResult = cloudinaryConfig.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return  uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
