package com.metaring.framework.localization;

import com.metaring.framework.localization.LocaleEnumerator;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class LocaleInfo implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.localization.localeInfo";

    private LocaleEnumerator locale;
    private String currency;

    private LocaleInfo(LocaleEnumerator locale, String currency) {
        this.locale = locale;
        this.currency = currency;
    }

    public LocaleEnumerator getLocale() {
        return this.locale;
    }

    public String getCurrency() {
        return this.currency;
    }

    public static LocaleInfo create(LocaleEnumerator locale, String currency) {
        return new LocaleInfo(locale, currency);
    }

    public static LocaleInfo fromJson(String jsonString) {

        if(jsonString == null) {
            return null;
        }

        jsonString = jsonString.trim();
        if(jsonString.isEmpty()) {
            return null;
        }

        if(jsonString.equalsIgnoreCase("null")) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromJson(jsonString);

        LocaleEnumerator locale = null;
        if(dataRepresentation.hasProperty("locale")) {
            try {
                locale = dataRepresentation.get("locale", LocaleEnumerator.class);
            } catch (Exception e) {
            }
        }

        String currency = null;
        if(dataRepresentation.hasProperty("currency")) {
            try {
                currency = dataRepresentation.getText("currency");
            } catch (Exception e) {
            }
        }

        LocaleInfo localeInfo = create(locale, currency);
        return localeInfo;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (locale != null) {
            dataRepresentation.add("locale", locale);
        }

        if (currency != null) {
            dataRepresentation.add("currency", currency);
        }

        return dataRepresentation;
    }

    @Override
    public String toJson() {
        return toDataRepresentation().toJson();
    }

    @Override
    public String toString() {
        return this.toJson();
    }
}