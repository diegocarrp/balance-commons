package cl.diego.balance.commons.testing;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UtilForTesting {
    static final DateFormat   df            = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss'Z'" );
    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper( )
            .disable( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES )
            .registerModule( new JavaTimeModule( ) )
            .setDateFormat( df );

    public static <T> T getMappedObjectFromFile( String path,
                                                 Class<T> tClass ) throws IOException {
        return OBJECT_MAPPER.readValue( new ClassPathResource( path ).getFile( ), tClass );
    }

    public static String asJsonString(final Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
