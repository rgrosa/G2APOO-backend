package br.com.src.util.date;

import br.com.src.exception.RFC3339DateFormatConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class RFC3339DateFormatConverter {

    private Logger logger = LoggerFactory.getLogger(RFC3339DateFormat.class);
    public Date createFromString(String DateTimeString) throws RFC3339DateFormatConverterException {
        final RFC3339DateFormat dateFormatter = new RFC3339DateFormat();
        try {
            return dateFormatter.parse(DateTimeString);
        } catch (ParseException ex) {
           logger.error("Error on convert string timestamp on RFC3339DateFormat", ex);
           throw new RFC3339DateFormatConverterException("Error. String Date parameter invalid format. RFC3339DateFormat is required.");
        }
    }

    public Date createFromStringNoError(String DateTimeString){
        final RFC3339DateFormat dateFormatter = new RFC3339DateFormat();
        try {
            return DateTimeString != null && !DateTimeString.isEmpty() ?dateFormatter.parse(DateTimeString):null;
        } catch (ParseException ex) {
            logger.error("Error on convert string timestamp on RFC3339DateFormat", ex);
            return null;
        }
    }
}
