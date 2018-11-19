import com.imefuture.entity.Department;
import com.imefuture.entity.Employee;
import com.imefuture.entity.Person;
import com.imefuture.enumeration.Age;
import com.imefuture.enumeration.EmpType;
import com.imefuture.mapper.DepartmentDao;
import com.imefuture.mapper.EmployeeDao;
import com.imefuture.mapper.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangpingyang
 * @Date: 2018/10/31  23:16
 */
//@ContextConfiguration{location = "classpath:spring/spring-config.xml"}
@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Demo {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Test
    public void fun1(){
        Person person = personDao.selectPerson(1L);
        System.out.println(person);
    }

    @Test
    public void fun2(){
        Employee empById = employeeDao.getEmpById(1);
        System.out.print(empById);
    }
    @Test
    public void fun3(){
        Employee empById = employeeDao.getEmpAndDept(3268);
        System.out.print(empById);
    }
    /*dept*/
    @Test
    public void fun4(){
        Department byId = departmentDao.findById(1);
        syso(byId);
    }
    @Test
    public void test1(){
        Department department = departmentDao.findDeptAndEmpByDeptId(1);
        syso(department);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void test2(){
        Employee employee = new Employee();
        Department department = new Department();
        department.setDeptId(1);

        employee.setDept(department);
        employee.setEmail("12345@sina.com");
        employee.setGender("男");
        employee.setLastName("xxxyyy");
        employee.setEmpType(EmpType.VIP);
        employee.setEmployeeType(EmpType.Tourist);
        employee.setAge(Age.Old);
        Integer id = employeeDao.insertEmployee(employee);
        syso(id);

    }
    @Transactional
    @Test
    @Rollback(false)
    public void test3(){

        Department department = new Department();
        department.setDeptId(1);
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Employee employee = new Employee();
//            employee.setEmpId(3000 + i);
            employee.setDept(department);
            employee.setEmail("zhangpingyang"+ (i + 1) +"@sina.com");
            employee.setGender("男");
            employee.setLastName("zhangpingyang" + (i + 1));
            employee.setAge(Age.Young);
            employee.setEmployeeType(EmpType.VIP);
            employee.setEmpType(EmpType.Tourist);
            list.add(employee);
        }
        Integer count = employeeDao.insertEmployees(list);
//        syso(list);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void testDel(){
        Integer zhangpingyang = employeeDao.delEmp("zhangpingyang");
        syso(zhangpingyang);
    }
    @Test
    public void testEnum(){
//        syso();
    }


    private void syso(Object obj){
        System.out.println(obj);
    }
}
