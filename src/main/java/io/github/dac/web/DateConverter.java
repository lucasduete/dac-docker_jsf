package io.github.dac.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author alexalins
 */
@FacesConverter(value = "converter.Date", forClass = LocalDate.class)
public class DateConverter implements Converter {

    private final DateTimeFormatter formmater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        return LocalDate.parse(value, formmater);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        return formmater.format((LocalDate) value);
    }

}
