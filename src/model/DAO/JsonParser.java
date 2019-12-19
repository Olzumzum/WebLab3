package model.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.entities.ItemProduct;

import java.util.List;

public class JsonParser {
    ObjectMapper objectMapper;

    public void createJsonObject(ItemProduct itemProduct) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(itemProduct);
        System.out.println(result);
    }
}
