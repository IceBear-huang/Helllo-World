package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //这是自己写的，有更加简单的方法，就是使用框架的工具类
        /*
        WebApplicationContext context = null;
        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object obj = getServletContext().getAttribute(key);
        if(obj != null){
            context = (WebApplicationContext) obj;
        }
        */

        //使用框架的方法
        WebApplicationContext context = null;
        ServletContext sc = getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);


        Student student = (Student)context.getBean("student");
        student.setAge(Integer.valueOf(age));
        student.setName(name);
        student.setEmail(email);
        student.setId(Integer.valueOf(id));
        StudentService service = (StudentService) context.getBean("studentService");
        int result = service.addStudent(student);
        if(result == 1){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }
    }
}
