package com.uniyaz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowShapesApp extends HttpServlet implements Serializable {
    private static FileService fileService=new FileService();
    private static File file=new File("Shapes.txt");
    private static List<Object> objectList=new ArrayList<Object>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        objectList.clear();
        if(file.exists()&& file.length()!=0){
            Object object=fileService.objectFileRead(file);
            if(object!=null){
                if(object instanceof List){
                    objectList= (List) object;
                    resp.getWriter().write("<body><h2> Created Shapes </h2></body><br>");
                    for(Object tempObject: objectList){
                        resp.getWriter().write(tempObject.toString()+"<br>");
                    }
                }
            }
        }
    }
}
