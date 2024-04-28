package com.dm.springbootjpapostgresql.model.montaji.enumeration;

public enum IdType {

EMIRATESID("Emirates Id", "EID"),
PASSPORT("Passport", "PP"),
VISA("Visa", "V"),
OTHER("Other", "O");

private final String name;
private final String symbol;

IdType(String name,String symbol)
{
this.name=name;
this.symbol=symbol;
};

public static IdType fromSymbol(String symbol) {
    for (IdType idType : IdType.values()) {
        if (idType.getSymbol().equalsIgnoreCase(symbol)) {
            return idType;
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
