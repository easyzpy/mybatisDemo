import com.imefuture.entity.GoodItem;
import com.imefuture.mapper.GoodItemDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodItemTest {

   /* @Autowired
    private GoodItemDao goodItemDao;
    @Test
    @Rollback(false)
    public void test1(){
        GoodItem goodItem = new GoodItem();
        goodItem.setName("RTX2080Ti");
//        goodItem = goodItemDao.insertGoodItem(goodItem);
        System.out.println(goodItem);

    }
    @Test
    public void test2(){

        List<GoodItem> goodItems = goodItemDao.goodItemList();
        System.out.println(goodItems);
    }
    @Test
    public void test3(){
        Integer integer = goodItemDao.delGoodItem(11);
        System.out.println(integer);
    }*/

}
