package it.ex.scalartes_be.converter;

import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GradoConverter implements AttributeConverter<Grado, String> {

    @Override
    public String convertToDatabaseColumn(Grado grado) {

        if(grado != null){
            return grado.getLivello();
        }else{
            return null;
        }
    }

    @Override
    public Grado convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        return Grado.fromString(dbData);
    }


}
