package com.yang.framework.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.codehaus.jackson.map.ser.StdSerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 默认@ResponseBody返回long类型日期，此处进行处理,返回null数据处理
 * @author tan_wang
 *
 */
public class CustomObjectMapper extends ObjectMapper {

	private String dateFormat ="yyyy-MM-dd HH:mm:ss";
	 public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public CustomObjectMapper(){  
	        CustomSerializerFactory factory = new CustomSerializerFactory();  
	        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
	            @Override  
	            public void serialize(Date value,   
	                    JsonGenerator jsonGenerator,   
	                    SerializerProvider provider)  
	                    throws IOException, JsonProcessingException {  
	                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);  
	                jsonGenerator.writeString(sdf.format(value));  
	            }  
	        });  
	        this.setSerializerFactory(factory); 
	        //解决返回json数据为null问题
	        StdSerializerProvider sp = new StdSerializerProvider();
	        sp.setNullValueSerializer(new NullSerializer());
	        this.setSerializerProvider(sp);
	    }  
	
	class NullSerializer extends JsonSerializer<Object> {

	    @Override
	    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
	         if(value == null){
	 	    	jgen.writeString("");
	         }
	    }
	}
}
