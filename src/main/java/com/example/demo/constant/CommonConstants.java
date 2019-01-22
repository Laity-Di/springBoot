package com.example.demo.constant;

import com.google.gson.Gson;

/**
 * @author: Ryan
 * @since: 2018/11/13 11:33
 * @description:
 * @modifyTime:
 * @modifier:
 */
public interface CommonConstants {

    Gson GSON = new Gson();

    public final static String PASSWORD_SALT = "_dx";

    public final static String ZERO_FILL_TEMPLATE = "%04d";

    public final static String FLOAT_MONEY_ZERO_FILL = "%.2f";

    public final static int SURE = 1;

    public final static int NEGATIVE = 0;
}
