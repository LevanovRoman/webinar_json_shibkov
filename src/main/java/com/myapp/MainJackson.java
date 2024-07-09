package com.myapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.GsonBuilder;
import com.myapp.adapter_gson.ZonedDateTimeAdapter;
import com.myapp.client.JsonHttpClient;
import com.myapp.currency.gson.CurrencyGson;
import com.myapp.currency.jackson.CurrencyJackson;

import java.time.ZonedDateTime;

public class MainJackson
{
    public static void main( String[] args )
    {
        //получаем по ссылке JSON
        var client = new JsonHttpClient("https://www.cbr-xml-daily.ru/daily_json.js");
        var json = client.getCurrencies();

        var jacksonMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        CurrencyJackson currencies;
        try {
            currencies = jacksonMapper.readValue(json, CurrencyJackson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(currencies);

        String stringJson;
        try {
            stringJson = jacksonMapper.writeValueAsString(currencies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringJson);
        //настраиваем Jackson
//        var jacksonMapper = new ObjectMapper()
//                .registerModule(new JavaTimeModule());

//        //преобразовываем JSON в объект CurrencyJackson
//        var currencies = getCurrencyJackson(jacksonMapper, json);
//        System.out.println(currencies);
//
//        //получаем JSON из объекта
//        var stringJson = getStringJson(jacksonMapper, currencies);
//        System.out.println(stringJson);
//    }
//
//    private static String getStringJson(ObjectMapper jacksonMapper, CurrencyJackson currencies) {
//        try {
//            return jacksonMapper.writeValueAsString(currencies);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static CurrencyJackson getCurrencyJackson(ObjectMapper jacksonMapper, String json) {
//        try {
//            return jacksonMapper.readValue(json, CurrencyJackson.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
  }
}
