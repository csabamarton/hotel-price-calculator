import com.csmarton.model.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class IOTest {
    @Test
    public void whenReadUsingFiles_thenRead() throws IOException {
        String expectedValue = "Hello world";
        URL url = Resources.getResource("test.txt");
        String result = Resources.toString(url, Charsets.UTF_8);

        assertEquals(expectedValue, result);
    }

    @Test
    public void whenReadHotelson_thenItCanBeConvertedToObject() throws IOException {
        String testHotelJson = "{\"hotelId\":\"hotel1\",\"name\":\"Sunhill\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        Hotel hotel = objectMapper.readValue(testHotelJson, Hotel.class);

        assertEquals("hotel1", hotel.getHotelId());

    }
}
