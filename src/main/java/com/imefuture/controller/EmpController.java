package com.imefuture.controller;

import com.imefuture.entity.Employee;
import com.imefuture.entity.Person;
import com.imefuture.exportBean.TTmoasCoNorecordInfo;
import com.imefuture.mapper.EmployeeDao;
import com.imefuture.mapper.PersonDao;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/18  22:22
 */
@Controller
@RequestMapping(value = "emp")
public class EmpController {

    @Autowired
    private EmployeeDao empDao;
    @Autowired
    private PersonDao personDao;
    @RequestMapping("person")
    @ResponseBody
    public Person personList(){

        return personDao.selectPerson(1L);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Employee> list(){
        List<Employee> empList = empDao.getEmpList(1, 10);
//        List<Employee> list = new ArrayList<>();
//        list.add(empAndDept);
        return empList;
    }
    @RequestMapping("table")
    public String table(){

        return "table";
    }
    @RequestMapping(value = "downloadExcel")
    public void downloadExcel(HttpServletResponse response/*, @RequestBody List<TTmoasCoNorecordInfo> list*/) {


        /*测试代码start*/
        TTmoasCoNorecordInfo tTmoasCoNorecordInfo = new TTmoasCoNorecordInfo();
        tTmoasCoNorecordInfo.setAppCertificateNum("1");
        tTmoasCoNorecordInfo.setAppDate(new Date());
        tTmoasCoNorecordInfo.setEntname("adsf");
        tTmoasCoNorecordInfo.setUserName("asdf");
        ArrayList<TTmoasCoNorecordInfo> list = new ArrayList<>();
        list.add(tTmoasCoNorecordInfo);
        /*测试代码end*/
        // 创建工作表
        WritableWorkbook book = null;
        response.reset();

        response.setCharacterEncoding("UTF-8");// 设置字符集

        // 创建工作流
        OutputStream os = null;
        try {

            // 设置弹出对话框
            response.setContentType("application/octet-stream");
//            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");

            // 设置工作表的标题
            response.setHeader("Content-Disposition", "attachment; filename="+new String("你好我是中文名".getBytes(),"ISO8859-1")+".xls");// 设置生成的文件名字
            os = response.getOutputStream();

            // 初始化工作表
            book = Workbook.createWorkbook(os);

        } catch (IOException e1) {

            e1.printStackTrace();
        }
        try {

            // 以下为excel表格内容
            // int nCount = list.size();
            WritableSheet sheet = book.createSheet("社信代无关联及名称不一致保存结果", 0);

            // 生成名工作表，参数0表示这是第一页
            // int nI = 1;

            // 表字段名
            sheet.addCell(new jxl.write.Label(0, 0, "序号"));
            sheet.addCell(new jxl.write.Label(1, 0, "名称(查询)"));
            sheet.addCell(new jxl.write.Label(2, 0, "经营状态"));
            sheet.addCell(new jxl.write.Label(3, 0, "名称(所填企业名)"));
            sheet.addCell(new jxl.write.Label(4, 0, "统一社会信用代码"));
            sheet.addCell(new jxl.write.Label(5, 0, "申请日期"));

            // 将数据追加
            for (int i = 1; i < list.size() + 1; i++) {

                sheet.addCell(new jxl.write.Label(0, i, String.valueOf(i)));// 序号从1开始
                sheet.addCell(new jxl.write.Label(1, i, list.get(i - 1).getEntname()));
                sheet.addCell(new jxl.write.Label(2, i, list.get(i - 1).getEntstatus()));
                sheet.addCell(new jxl.write.Label(3, i, list.get(i - 1).getUserName()));
                sheet.addCell(new jxl.write.Label(4, i, list.get(i - 1).getAppCertificateNum()));

                // 设置日期格式
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date appDate = list.get(i - 1).getAppDate();
                String appDateStr = sf.format(appDate);
                sheet.addCell(new jxl.write.Label(5, i, appDateStr));// 申请日期
            }
            book.write();
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
