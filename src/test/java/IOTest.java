import com.csmarton.model.Hotel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IOTest {

    String testHotelJson;
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        URL url = Resources.getResource("hotel.json");
        testHotelJson = Resources.toString(url, Charsets.UTF_8);

        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Test
    public void whenReadUsingFiles_thenRead() throws IOException {
        String expectedValue = "Hello world";
        URL url = Resources.getResource("test.txt");
        String result = Resources.toString(url, Charsets.UTF_8);

        assertEquals(expectedValue, result);
    }

    @Test
    public void whenReadHotelson_thenItCanBeConvertedToObject() throws IOException {
        List<Hotel> hotels = objectMapper.readValue(testHotelJson, new TypeReference<List<Hotel>>(){});

        Hotel hotel = hotels.get(0);
        assertEquals(1, hotels.size());
    }
}
