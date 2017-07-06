package com.yang.shop.util;


import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;

/**
 * Created by zen on 2015/1/4.
 */
public class WebConfig {

    private Locale defaultLocale = Locale.SIMPLIFIED_CHINESE;
    @Value("${resource.url}")
    private String resources;

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

}
