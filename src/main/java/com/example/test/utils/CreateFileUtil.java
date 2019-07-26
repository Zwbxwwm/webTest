package com.example.test.utils;

import com.example.test.entity.didiOrder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileUtil {
    public static void createFile(String Path, String fileName, StringBuffer stringBuffer) throws IOException {
        File filePath = new File(Path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        File checkFile = new File(filePath+"/"+fileName);
        FileWriter fileWriter = null;
        try {
            if (!checkFile.exists()) {
                checkFile.createNewFile();
            }
            fileWriter = new FileWriter(checkFile,true);
            fileWriter.append(stringBuffer);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != fileWriter) {
                fileWriter.close();
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String entity = didiOrder.class.getName();
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("package com.drools.demo.point \n");
        stringBuffer.append("import "+entity+"; \n");
        stringBuffer.append("rule rule1 \n");
        stringBuffer.append("agenda-group \"test-group3\"");
        stringBuffer.append("when \n");
        stringBuffer.append("   $order : didiOrder(orderAmount < 100);    \n");
        stringBuffer.append("then \n");
        stringBuffer.append("   $order.setOrderId(\"金额小于100元\");  \n");
        stringBuffer.append("end \n");
        createFile("D:\\MyData\\zhuwb12\\IdeaProjects\\webTest\\src\\main\\resources\\com.drools.demo.point","test.drl",stringBuffer);

    }
}
