package com.dm.springbootjpapostgresql.dto.montaji;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DataObjDTO{
    private ArrayList<Object> dataItems;
}
