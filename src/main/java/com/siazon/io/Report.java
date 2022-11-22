package com.siazon.io;

public @interface Report {
    int type() default 0;

    String level() default "info";

    String value() default "";
}
