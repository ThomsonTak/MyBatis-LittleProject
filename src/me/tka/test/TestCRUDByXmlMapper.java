package me.tka.test;

import me.tka.domain.User;
import me.tka.mapping.UserMapperI;
import me.tka.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCRUDByXmlMapper {
    @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user = new User();
        user.setName("Groot");
        user.setAge(20);
        int add = mapper.add(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(add);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        int ret = mapper.delete(3);
        sqlSession.close();
        System.out.println(ret);
    }
}
