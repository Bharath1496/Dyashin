package com.ProductManagementSystem.Management;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalTime> {
	
	
	    @Override
	    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
	        String timeString = p.getText();
	        // Assuming the input format is "2000-01-01 01:50:00"
	        String timePart = timeString.split(" ")[1]; // Extracts "01:50:00"
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	        return LocalTime.parse(timePart, formatter);
	    }
	

}
