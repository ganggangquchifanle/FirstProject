package com.test.fastjson;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Main {  
  
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {  
          
        JAXBContext context = JAXBContext.newInstance(Department.class,Staff.class);    // 获取上下文对象  
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象  
        Unmarshaller unmarshaller = context.createUnmarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进  
        
        //marshaller.marshal(getSimpleDepartment(),System.out);   // 打印到控制台  
        System.out.print(""); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        marshaller.marshal(DepartmentUtils.getSimpleDepartment(), baos);  
        String xmlObj = new String(baos.toByteArray());         // 生成XML字符串  
        System.out.println(xmlObj);
        
        //String teststaffs = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <department name=\"娱乐圈\">  <staff smoker=\"false\">  <age>30</age>       <name>周杰伦</name>     </staff>     <staff smoker=\"false\">         <age>28</age>         <name>周笔畅</name>     </staff>     <staff smoker=\"true\">         <age>40</age>         <name>周星驰</name>     </staff> </department>";
        String teststaffs = " <department name=\"娱乐圈\">  <staff smoker=\"false\">  <age>30</age>       <name>周杰伦</name>     </staff>     <staff smoker=\"false\">         <age>28</age>         <name>周笔畅</name>     </staff>     <staff smoker=\"true\">         <age>40</age>         <name>周星驰</name>     </staff> </department>";
        Department dept = (Department)unmarshaller.unmarshal(new ByteArrayInputStream(teststaffs.getBytes()));
        String jsonstr = JSON.toJSONString(dept, SerializerFeature.WriteClassName);
        System.out.println(jsonstr);
        Department newdept = JSON.parseObject(jsonstr, Department.class);
        System.out.println(JSON.toJSONString(newdept));
        
        Collection<Staff> values = null;
        values = JSON.parseObject(JSON.toJSONString((Collection<Staff>)dept.getStaffs()), Collection.class);
        System.out.println(JSON.toJSONString(values));
        
        String aaaa = "ffdgfgfdgfd|ghggmhgh";
        String ID_DELIMITER = "\\|";
        for(String each:aaaa.split(ID_DELIMITER))
        {
        	System.out.println(each);
        }
        System.out.println(aaaa.indexOf("|"));
        
        
        String str = "fdgfkgfksaasd";
        System.out.println(new String(str.getBytes(Charset.defaultCharset()), Charset.defaultCharset()));
        
        
        Map<String, String> desc = new HashMap<String, String>();
        
        Map<String, String> src = new HashMap<String, String>();
        
        src.put("aaa", null);
        
        desc.putAll(src);
        
        System.out.println(desc);
        
    }  
      
    /** 
     * 生成一个简单的Department对象 
     * @return 
     */  
    private static Department getSimpleDepartment() {  
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
