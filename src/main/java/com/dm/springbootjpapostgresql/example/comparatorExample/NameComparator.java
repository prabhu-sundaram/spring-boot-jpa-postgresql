package com.dm.springbootjpapostgresql.example.comparatorExample;
import com.dm.springbootjpapostgresql.example.beans.Student33;
import java.util.Comparator;

class NameComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Student33 s1=(Student33)o1;  
Student33 s2=(Student33)o2;  
  
return s1.getName().compareTo(s2.getName());  
}  
}  