package com.ensi.PCD.Services;

import com.ensi.PCD.model.TemplateContent;
import org.springframework.web.multipart.MultipartFile;

public interface TempalteInterfaceServices {
    void createTemplate(TemplateContent templateContent);
    TemplateContent getTemplateByVendeur(Integer id);
    void deleteTemplate(TemplateContent templateContent);
    String UploadPhoto(MultipartFile mf);

    byte[] getImage(Integer id);
}
