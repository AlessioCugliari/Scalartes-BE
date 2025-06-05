package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.service.ImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@Slf4j
public class ImportController {

    private ImportService importService;

    @Autowired
    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @PostMapping("/fungo/excel")
    public ResponseEntity<String> uploadExcelFungo(@RequestParam("file") MultipartFile file){
        log.info("Request POST uploadExcelFungo");
        try {
            importService.importFromExcel(file);
            return ResponseEntity.ok("File importato con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Errore durante l'importazione: " + e.getMessage());
        }
    }

}
