package com.ys.demo.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ys.demo.po.PerSon;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangshe on 2016/9/8.
 */
@Controller
public class testmvc {
    @RequestMapping("/mySpringmvcTest")
    public String test(Model model, HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("name");
        System.out.println("我收到了客服端传人的值：" + str);
        model.addAttribute("mysession", "这里是model中存放的值");
        return "./WEB-INF/test.jsp";

    }

    @RequestMapping(value = "/mySpringmvcreultJSON", produces = "application/json;charset=utf-8")
    @ResponseBody
    public PerSon testJSON(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String str = null;
        try {
            ServletInputStream inputStream = request.getInputStream();
            str = IOUtils.toString(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("我收到了客服端传人的值：" + str);
        model.addAttribute("mysession", "这里是model中存放的值");
        PerSon perSon = new PerSon();
        perSon.setAddre("观山湖区长岭南路");
        perSon.setAge(23);
        perSon.setName("杨胜");
        ObjectMapper mapper = new ObjectMapper();
        String personStr = mapper.writeValueAsString(perSon);
        System.out.print(personStr);
        return perSon;
    }

    /**
     * 接收单个的pojo对象,返回单个pojo对象
     * @param perSon
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/mySpringmvcreultToJSON", produces = "application/json;charset=utf-8")
    @ResponseBody
    public PerSon testJSONAndreultJSON(@RequestBody PerSon perSon) throws IOException {

        String str = null;
        /*try {
            ServletInputStream inputStream = request.getInputStream();
            str= IOUtils.toString(inputStream);
            System.out.println("我收到了客服端传人的值："+str);
        }catch ( Exception e){
            System.out.println(e.getMessage());
        }*/


        PerSon resPerSon = new PerSon();
        resPerSon.setAddre("观山湖区长岭南路");
        resPerSon.setAge(23);
        resPerSon.setName("杨胜");

        PerSon resPerSon2 = new PerSon();
        resPerSon2.setAddre("观山湖区长岭南路");
        resPerSon2.setAge(23);
        resPerSon2.setName("杨胜");

        PerSon resPerSon3 = new PerSon();
        resPerSon3.setAddre("观山湖区长岭南路");
        resPerSon3.setAge(23);
        resPerSon3.setName("杨胜");

        PerSon resPerSon4 = new PerSon();
        resPerSon4.setAddre("观山湖区长岭南路");
        resPerSon4.setAge(23);
        resPerSon4.setName("杨胜");

        List<PerSon> perSons = new ArrayList<PerSon>();
        perSons.add(resPerSon);
        perSons.add(resPerSon2);
        perSons.add(resPerSon3);
        perSons.add(resPerSon4);

        //返回单个Java对象的json字符串
        ObjectMapper mapper = new ObjectMapper();
        String resPerSonStr = mapper.writeValueAsString(resPerSon);
        System.out.println("将要返回的String：" + resPerSonStr);

        //返回list的对象的json字符串
        String listresPerSonStr = mapper.writeValueAsString(perSons);
        System.out.println(listresPerSonStr);
        //str转为一个java对象
        String strperson = "{\"id\":0,\"name\":\"杨胜\",\"addre\":\"观山湖区长岭南路\",\"age\":23}";
        PerSon per = mapper.readValue(strperson, PerSon.class);
        System.out.println("per = " + per);
        //personList对象转为java对象 要制定是要转为list
        /*
        mapper.getTypeFactory().constructParametricType(List.class,PerSon.class)
        参数1是要以什么类型返回
        参数2是返回类型中具体放入的java对象
         */
        String personslsit =
                "[{\"id\":0,\"name\":\"杨胜1\",\"addre\":\"观山湖区长岭南路\",\"age\":23}," +
                "{\"id\":0,\"name\":\"杨胜2\",\"addre\":\"观山湖区长岭南路\",\"age\":23}," +
                "{\"id\":0,\"name\":\"杨胜3\",\"addre\":\"观山湖区长岭南路\",\"age\":23}," +
                "{\"id\":0,\"name\":\"杨胜4\",\"addre\":\"观山湖区长岭南路\",\"age\":23}]";
        List<PerSon> pers = (List<PerSon>) mapper.readValue(personslsit, mapper.getTypeFactory().constructParametricType(List.class,PerSon.class));
        for (PerSon son : pers) {
            System.out.println("************转化的person对象："+son);
        }
        System.out.println("接收到并转为java对象的String：" + perSon);
        return resPerSon;
    }

    /**
     * 接收单个类型pojo，返回list类型pojo对象
     * @param perSon
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/mySpringmvcListJSON", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<PerSon> testlistJSON(@RequestBody PerSon perSon) throws IOException {

        String str = null;

        PerSon resPerSon = new PerSon();
        resPerSon.setAddre("观山湖区长岭南路1");
        resPerSon.setAge(23);
        resPerSon.setName("杨胜1");

        PerSon resPerSon2 = new PerSon();
        resPerSon2.setAddre("观山湖区长岭南路2");
        resPerSon2.setAge(23);
        resPerSon2.setName("杨胜2");

        PerSon resPerSon3 = new PerSon();
        resPerSon3.setAddre("观山湖区长岭南路3");
        resPerSon3.setAge(23);
        resPerSon3.setName("杨胜3");

        PerSon resPerSon4 = new PerSon();
        resPerSon4.setAddre("观山湖区长岭南路4");
        resPerSon4.setAge(23);
        resPerSon4.setName("杨胜4");

        List<PerSon> perSons = new ArrayList<PerSon>();
        perSons.add(resPerSon);
        perSons.add(resPerSon2);
        perSons.add(resPerSon3);
        perSons.add(resPerSon4);

        ObjectMapper mapper = new ObjectMapper();

        //返回list的对象的json字符串
        String listresPerSonStr = mapper.writeValueAsString(perSons);
        System.out.println(listresPerSonStr);

        System.out.println("接收到并转为java对象的String：" + perSon);
        return perSons;
    }
    /**
     * 接收list类型pojo，返回list类型pojo对象
     * @param perSon
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/mySpringmvcListToListJSON", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<PerSon> testlisttolsitJSON(@RequestBody List<PerSon> perSon) throws IOException {

        String str = null;

        PerSon resPerSon = new PerSon();
        resPerSon.setAddre("观山湖区长岭南路1");
        resPerSon.setAge(23);
        resPerSon.setName("杨胜1");

        PerSon resPerSon2 = new PerSon();
        resPerSon2.setAddre("观山湖区长岭南路2");
        resPerSon2.setAge(23);
        resPerSon2.setName("杨胜2");

        PerSon resPerSon3 = new PerSon();
        resPerSon3.setAddre("观山湖区长岭南路3");
        resPerSon3.setAge(23);
        resPerSon3.setName("杨胜3");

        PerSon resPerSon4 = new PerSon();
        resPerSon4.setAddre("观山湖区长岭南路4");
        resPerSon4.setAge(23);
        resPerSon4.setName("杨胜4");

        List<PerSon> perSons = new ArrayList<PerSon>();
        perSons.add(resPerSon);
        perSons.add(resPerSon2);
        perSons.add(resPerSon3);
        perSons.add(resPerSon4);

        ObjectMapper mapper = new ObjectMapper();

        //返回list的对象的json字符串
        String listresPerSonStr = mapper.writeValueAsString(perSons);
        System.out.println(listresPerSonStr);

        System.out.println("接收到并转为java对象的String：" + perSon);
        return perSons;
    }
}
