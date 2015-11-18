package com.test.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@interface Cars {
    public enum CarName {
        BMW("Bmw"), FERRARI("Ferrari"), LAMBORGHINI("Lamborghini"), FORD("Ford");
        String name;

        private CarName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    String color() default "White";

    CarName[] carName() default { CarName.FERRARI };
}
