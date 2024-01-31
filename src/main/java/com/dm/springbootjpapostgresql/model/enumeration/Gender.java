package com.dm.springbootjpapostgresql.model.enumeration;

public enum Gender {

    MALE("Male", "M"),
    FEMALE("Female", "F"),
    OTHER("Other", "O");

        private final String name;
        private final String symbol;

        Gender(String name,String symbol)
        {
        this.name=name;
        this.symbol=symbol;
        };

        public static Gender fromSymbol(String symbol) {
            for (Gender gender : Gender.values()) {
                if (gender.getSymbol().equalsIgnoreCase(symbol)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException("No enum constant with symbol " + symbol);
        }

        public String getName() {
            return this.name;
        }
    
        public String getSymbol() {
            return this.symbol;
        }        

}
