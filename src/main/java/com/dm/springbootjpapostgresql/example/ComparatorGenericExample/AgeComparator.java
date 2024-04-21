package com.dm.springbootjpapostgresql.example.ComparatorGenericExample;

import java.util.*;

import com.dm.springbootjpapostgresql.example.beans.Student33;  
class AgeComparator implements Comparator<Student33>{  
public int compare(Student33 s1,Student33 s2){  
if(s1.getAge()==s2.getAge())  
return 0;  
else if(s1.getAge()>s2.getAge())  
return 1;  
else  
return -1;  
}  
}  