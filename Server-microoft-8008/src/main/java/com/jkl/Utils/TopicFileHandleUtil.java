package com.jkl.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongxin
 * @date 2020/10/9/009 17:15
 */
public class TopicFileHandleUtil {

    public static ArrayList<Map> getMBTI93(){
        ArrayList<String> arrayList = TopicFileHandleUtil.getFile("MBTI93.txt");
        ArrayList<Map> questionList = new ArrayList<>();
        Map<String, Object> questionGroupMap = null;
        for (int i = 0; i < arrayList.size(); i++) {
            String row = arrayList.get(i).trim();
            if(row.replace(" ","").equals(""))
                continue;
            if(row.equals(""))
                continue;
            int len = (questionList.size()+"").length();
            if(row.length()<=len)
                continue;
            String strNum = row.substring(0,len);

            int num;
            try {
                num = Integer.valueOf(strNum);
                //如果是数字就创建一个集合
                questionGroupMap= new HashMap<>();
                questionGroupMap.put("quetion",row.substring(len+1));
                questionList.add(questionGroupMap);
            } catch (NumberFormatException e) {
                String ind = row.substring(0, 2);
                String text = row.substring(2).trim();
                Map<String,String> options;
                if (questionGroupMap.containsKey("options"))
                    options = (Map<String, String>) questionGroupMap.get("options");
                else
                    options = new HashMap<>();
                options.put(ind.trim(),text.trim());
                questionGroupMap.put("options",options);
            }
        }
        return questionList;
    }


    private static ArrayList<String> getFile(String name){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            URL resource = TopicFileHandleUtil.class.getClassLoader().getResource(name);
            System.out.println(resource);
            File file = new File(resource.getPath());
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
