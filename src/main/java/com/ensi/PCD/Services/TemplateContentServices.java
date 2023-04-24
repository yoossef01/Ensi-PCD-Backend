package com.ensi.PCD.Services;

import com.ensi.PCD.Dao.TemplateContentRepository;
import com.ensi.PCD.model.TemplateContent;
import com.ensi.PCD.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class TemplateContentServices {
    @Autowired
    private TemplateContentRepository templateContentRepository;

    public TemplateContent getTemplateByVendeur(Integer idVend){
        return this.templateContentRepository.getTemplateByVendeur( idVend );

    }
    public void createTemplate(TemplateContent templateContent){

        this.templateContentRepository.save( templateContent );
    }
    public void deleteTemplate(TemplateContent templateContent){
        this.templateContentRepository.delete(templateContent);
    }
    public String UploadPhoto(MultipartFile mf) {
        String nom = mf.getOriginalFilename();
        String[] tab = nom.split("\\.");
        String nouveau = tab[0] + System.currentTimeMillis() + "." + tab[1];
        Path p = Paths.get(System.getProperty("user.home") + "/imagesarsii2022/", nouveau);

        try {
            Files.write(p, mf.getBytes(), new OpenOption[0]);
        } catch (IOException var7) {
        }

        return nouveau;
    }

    public byte[] getImage(Integer id) {
        String nomPhoto = ((TemplateContent)this.templateContentRepository.findById(id).get()).getPhoto();
        String chemin = System.getProperty("user.home") + "/imagesarsii2022/";
        Path p = Paths.get(chemin, nomPhoto);

        try {
            return Files.readAllBytes(p);
        } catch (IOException var6) {
            var6.printStackTrace();
            return null;
        }
    }
    public void ajoutTemplate(TemplateContent templateContent,MultipartFile mf){
        if (mf != null) {
            String nomPhoto = this.UploadPhoto(mf);
            templateContent.setPhoto(nomPhoto);
        }
        this.templateContentRepository.save( templateContent );
    }
    public TemplateContentServices(final TemplateContentRepository templateContentRepository){this.templateContentRepository=templateContentRepository;}
}
