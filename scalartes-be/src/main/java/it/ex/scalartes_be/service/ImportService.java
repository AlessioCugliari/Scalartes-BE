package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.enums.Grado;
import it.ex.scalartes_be.repository.BloccoRepository;
import it.ex.scalartes_be.repository.MuroRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Slf4j
public class ImportService {

    private BloccoRepository bloccoRepository;
    private MuroRepository muroRepository;

    @Autowired
    public ImportService(BloccoRepository bloccoRepository, MuroRepository muroRepository) {
        this.bloccoRepository = bloccoRepository;
        this.muroRepository = muroRepository;
    }

    public void importFromExcel(MultipartFile file) throws IOException {
        log.info("Inizio importazione del file: {}", file.getOriginalFilename());

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                try {
                    Blocco blocco = new Blocco();
                    Long muroId = Long.valueOf(row.getCell(0).getStringCellValue());
                    Optional<Muro> muro = muroRepository.findById(muroId);
                    blocco.setMuro(muro.get());
                    blocco.setColore(row.getCell(1).getStringCellValue());
                    blocco.setGrado(Grado.fromString(row.getCell(2).getStringCellValue()));
                    blocco.setDataTracciatura(dateConverter(row.getCell(7).getStringCellValue()));
                    //TODO Resto delle cose

                    bloccoRepository.save(blocco);
                    rowCount++;
                } catch (Exception e) {
                    log.warn("Errore nella riga {}: {}", row.getRowNum(), e.getMessage());
                }
            }

            log.info("Importazione completata. Totale righe importate: {}", rowCount);
        } catch (IOException e) {
            log.error("Errore durante la lettura del file Excel: {}", e.getMessage(), e);
            throw e;
        }
    }

    private LocalDate dateConverter(String dateToConvert){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(dateToConvert,formatter);

        return localDate;
    }
}
