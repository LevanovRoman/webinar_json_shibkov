package com.myapp;

import com.google.gson.GsonBuilder;
import com.myapp.adapter_gson.ZonedDateTimeAdapter;
import com.myapp.client.JsonHttpClient;
import com.myapp.currency.gson.CurrencyGson;

import java.time.ZonedDateTime;

public class MainGson
{
    public static void main( String[] args )
    {
        //получаем по ссылке JSON
        var client = new JsonHttpClient("https://www.cbr-xml-daily.ru/daily_json.js");
        var json = client.getCurrencies();

        //настраиваем GSON
        var gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
                .create();

        //преобразовываем JSON в объект CurrencyGson
        var currencies = gson.fromJson(json, CurrencyGson.class);
        System.out.println(currencies);

        //получаем JSON из объекта
        var jsonFromCurrencies = gson.toJson(currencies);
        System.out.println(jsonFromCurrencies);
    }
}
