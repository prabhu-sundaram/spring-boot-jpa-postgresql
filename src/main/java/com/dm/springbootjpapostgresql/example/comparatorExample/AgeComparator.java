package com.dm.springbootjpapostgresql.example.comparatorExample;

import java.util.Comparator;
import com.dm.springbootjpapostgresql.example.beans.Student33;

class AgeComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Student33 s1=(Student33)o1;  
Student33 s2=(Student33)o2;  
  
if(s1.getAge()==s2.getAge())  
return 0;  
else if(s1.getAge()>s2.getAge())  
return 1;  
else  
return -1;  
}  
}
