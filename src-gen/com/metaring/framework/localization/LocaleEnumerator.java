package com.metaring.framework.localization;

import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class LocaleEnumerator implements GeneratedCoreType {

    public static final LocaleEnumerator IT_IT = new LocaleEnumerator("IT_IT", 0l, "it_IT");
    public static final LocaleEnumerator EN_US = new LocaleEnumerator("EN_US", 1l, "en_US");
    public static final LocaleEnumerator EN_GB = new LocaleEnumerator("EN_GB", 2l, "en_GB");

    private String name;
    private Long numericValue;
    private String textualValue;

    private LocaleEnumerator(String name, Long numericValue, String textualValue) {
        this.name = name;
        this.numericValue = numericValue;
        this.textualValue = textualValue;
    }

    public String getName() {
        return this.name;
    }

    public Long getNumericValue() {
        return this.numericValue;
    }

    public String getTextualValue() {
        return this.textualValue;
    }

    public static final LocaleEnumeratorSeries listAll() {
        return LocaleEnumeratorSeries.create(IT_IT, EN_US, EN_GB);
    }

    public static LocaleEnumerator getByNumericValue(Long numericValue) {
        if(numericValue == null) {
            return null;
        }
        switch(numericValue.intValue()) {

            case 0 : return IT_IT;

            case 1 : return EN_US;

            case 2 : return EN_GB;

            default: return null;
        }
    }

    public static LocaleEnumerator getByTextualValue(String textualValue) {
        if(textualValue == null) {
            return null;
        }
        switch(textualValue) {

            case "it_IT" : return IT_IT;

            case "en_US" : return EN_US;

            case "en_GB" : return EN_GB;

            default: return null;
        }
    }

    public static LocaleEnumerator getByName(String localeEnumeratorName) {
        if(localeEnumeratorName == null) {
            return null;
        }
        switch(localeEnumeratorName) {

            case "IT_IT" : return IT_IT;

            case "EN_US" : return EN_US;

            case "EN_GB" : return EN_GB;

            default: return null;
        }
    }

    public static LocaleEnumerator fromJson(String json) {
        if(json == null) {
            return null;
        }
        if(json.startsWith("\"")) {
            json = json.substring(1);
        }
        if(json.endsWith("\"")) {
            json = json.substring(0, json.length() - 1);
        }
        try {
            return getByNumericValue(Long.parseLong(json));
        } catch(Exception e) {
        }
        LocaleEnumerator result = getByTextualValue(json);
        return result != null ? result : getByName(json);
    }

    @Override
    public String toJson() {
        return "\"" + this.name + "\"";
    }

    public DataRepresentation toDataRepresentation() {
        return Tools.FACTORY_DATA_REPRESENTATION.fromJson(toJson());
    }

    @Override
    public String toString() {
        return toJson();
    }
}