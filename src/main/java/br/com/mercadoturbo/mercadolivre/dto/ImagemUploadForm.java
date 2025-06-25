package br.com.mercadoturbo.mercadolivre.dto;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;


public class ImagemUploadForm {
    
    
    @RestForm("file")
    public FileUpload file;
}
