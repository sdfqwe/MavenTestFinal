package SubPackage;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class MyBatisTest {

    @Inject
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testFactory() {
        System.out.println(sqlSessionFactoryBean);
    }

    @Test
    public void testSession() throws Exception {
        try (SqlSession session = sqlSessionFactoryBean.getObject().openSession()){
            System.out.println(session);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

