package com.mercadolibre.challenge.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DecimalJsonSerializer extends JsonSerializer<Double> {
	  @Override
	  public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) 
	    throws IOException, JsonProcessingException {
	      jgen.writeString( String.format("%.2f", value));
	  }
}
