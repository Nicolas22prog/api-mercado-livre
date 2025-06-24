package br.com.mercadoturbo.mercadolivre.dto;



import jakarta.ws.rs.FormParam;
import java.io.File;


public class ImagemUploadForm {
    
    @FormParam("file")
    public File file;
}
