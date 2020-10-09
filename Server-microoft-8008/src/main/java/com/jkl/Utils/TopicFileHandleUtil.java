package com.jkl.Utils;

import com.google.gson.Gson;
import com.jkl.bean.DTO.TopicDataDTO;
import com.jkl.bean.DTO.TopicDataOptionDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author zhongxin
 * @date 2020/10/9/009 17:15
 */
public class TopicFileHandleUtil {

    public static String getMBTI93(){
        ArrayList<String> arrayList = TopicFileHandleUtil.getFile("MBTI93.txt");
        List<TopicDataDTO> topicDataDTOList = new ArrayList<>();
        List<TopicDataOptionDTO> topicDataOptionDTOlist = null;

        for (int i = 0; i < arrayList.size(); i++) {
            String row = arrayList.get(i).trim();
            if(row.replace(" ","").equals(""))
                continue;
            if(row.equals(""))
                continue;
            int len = (topicDataDTOList.size()+"").length();
            if(row.length()<=len)
                continue;
            String strNum = row.substring(0,len);

            int num;
            try {
                num = Integer.valueOf(strNum);
                //如果是数字就创建一个集合
                topicDataOptionDTOlist = new ArrayList<>();
                topicDataDTOList.add(new TopicDataDTO(num,row.substring(len+1).trim(),topicDataOptionDTOlist));
            } catch (NumberFormatException e) {
                topicDataOptionDTOlist.add(new TopicDataOptionDTO(row.substring(0, 2).trim(), row.substring(2).trim()));
            }
        }
        return new Gson().toJson(topicDataDTOList);
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
