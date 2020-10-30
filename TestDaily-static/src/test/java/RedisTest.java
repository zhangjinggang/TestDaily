import com.zjg.test.Application;
import com.zjg.test.service.RedisTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zjg
 * @description:
 * @date 2020/4/9 11:08
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class RedisTest {


    @Autowired
    RedisTestService redisTestService;
    /**
     * 结算方式
     */
    @Test
    public void testRedis() {
        redisTestService.setKey("one","1");
        System.out.println(redisTestService.getValue("one"));
    }
}