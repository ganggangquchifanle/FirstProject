package com.test.fastjson;
import java.util.ArrayList;
import java.util.List;


public class DepartmentUtils {
	/** 
     * 生成一个简单的Department对象 
     * @return 
     */  
    public static Department getSimpleDepartment() {  
        List<Staff> staffs = new ArrayList<Staff>();  
          
        Staff stf1 = new Staff();  
        stf1.setName("周杰伦");
        stf1.setAge(30);  
        stf1.setSmoker(false);  
        staffs.add(stf1);  
        
        Staff stf2 = new Staff();
        stf2.setName("周笔畅");  
        stf2.setAge(28);  
        stf2.setSmoker(false);  
        staffs.add(stf2);  
        
        Staff stf3 = new Staff();
        stf3.setName("周星驰");  
        stf3.setAge(40);  
        stf3.setSmoker(true);  
        staffs.add(stf3);  
          
        Department dept = new Department();  
        dept.setName("娱乐圈");  
        dept.setStaffs(staffs);  
        //System.out.println(JSON.toJSONString(dept));
        return dept;  
    }
}
