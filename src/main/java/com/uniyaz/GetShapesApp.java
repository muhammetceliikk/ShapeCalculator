package com.uniyaz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetShapesApp extends HttpServlet{
    private static FileService fileService=new FileService();
    private static File file=new File("Shapes.txt");
    private static List<Object> objectList=new ArrayList<Object>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shape=req.getParameter("shape");
        objectList.clear();
        if(file.exists()&& file.length()!=0){
            Object object=fileService.objectFileRead(file);
            if(object!=null){
                if(object instanceof List){
                    objectList= (List) object;
                }
            }
        }

        if("rectangle".equals(shape)){
            String stringLength=req.getParameter("length");
            String stringWidth=req.getParameter("width");

            int length=Integer.parseInt(stringLength);
            int width=Integer.parseInt(stringWidth);
            createRectangle(length,width);
        }
        else if("square".equals(shape)){
            String stringLength=req.getParameter("length");
            int length=Integer.parseInt(stringLength);
            createSquare(length,length);
        }
        else if("sphere".equals(shape)){
            String stringRadius=req.getParameter("radius");
            double radius=Double.parseDouble(stringRadius);
            createSphere(radius);
        }
        resp.sendRedirect("/");
    }

    public void createRectangle(int length,int width){
        Rectangle rectangle=new Rectangle(length,width);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        objectList.add(rectangle);
        fileService.objectFileWrite(file,objectList);
    }
    public void createSquare(int length,int width){
        Square square=new Square(length,width);
        square.calculateArea();
        square.calculatePerimeter();
        objectList.add(square);
        fileService.objectFileWrite(file,objectList);
    }
    public void createSphere(double r){
        Sphere sphere=new Sphere(r);
        sphere.calculateArea();
        sphere.calculatePerimeter();
        objectList.add(sphere);
        fileService.objectFileWrite(file,objectList);
    }

}
