package com.dm.springbootjpapostgresql.example.ComparatorGenericExample;

import java.util.*;
import com.dm.springbootjpapostgresql.example.beans.Student33;  

class NameComparator implements Comparator<Student33>{  
public int compare(Student33 s1,Student33 s2){  
return s1.getName().compareTo(s2.getName());  
}  
} 