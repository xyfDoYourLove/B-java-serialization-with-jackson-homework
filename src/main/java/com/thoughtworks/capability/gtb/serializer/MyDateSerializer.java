package com.thoughtworks.capability.gtb.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

public class MyDateSerializer extends StdSerializer<Date> {
  protected MyDateSerializer() {
    super(Date.class);
  }

  @Override
  public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
    long ts = date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
    jsonGenerator.writeNumber(ts);
  }
}
