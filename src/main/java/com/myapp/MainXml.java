package com.myapp;

import com.myapp.client.JsonHttpClient;
import com.myapp.parser.CurrencyXmlParser;

public class MainXml {
    public static void main(String[] args) {
        //получаем по ссылке XML
        var client = new JsonHttpClient("https://www.cbr-xml-daily.ru/daily_utf8.xml");
        var xml = client.getCurrencies();
//        var client = new GetStringHttpClient("https://www.cbr-xml-daily.ru/daily_utf8.xml");
//        var xml = client.getCurrencies();

        //создаем свой парсер XML
        var parser = new CurrencyXmlParser();

        //преобразовываем XML в объект Currency
        var currencies = parser.toObject(xml);
        System.out.println(currencies);

        //получаем XML из объекта
        var cXml = parser.toXml(currencies);
        System.out.println(cXml);
    }
}
