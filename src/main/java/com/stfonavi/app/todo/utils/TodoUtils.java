package com.stfonavi.app.todo.utils;

import com.google.common.base.Strings;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@NoArgsConstructor
public class TodoUtils {

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<>("{\"message\":\""+responseMessage+"\"}",httpStatus);
    }

    public static String getUUID(){
        Date date = new Date();
        long time = date.getTime();
        return "TRA-"+time;
    }

    public static JSONArray getJsonArrayFormString(String data) throws JSONException{
        JSONArray jsonArray = new JSONArray(data);
        return jsonArray;
    }

    public static Map<String,Object> getMapFromJson(String data){
        if(!Strings.isNullOrEmpty(data))
            return new Gson().fromJson(data,new TypeToken<Map<String,Object>>(){
            }.getType());
        return new HashMap<>();

    }

    public static Boolean isFileExists(String path){
        log.info("Inside isFileExists {}", path);
        try{
            File file = new File(path);
            return (file != null && file.exists()) ? Boolean.TRUE: Boolean.FALSE;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

}
