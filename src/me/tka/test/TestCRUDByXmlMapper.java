package me.tka.test;

import me.tka.domain.User;
import me.tka.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCRUDByXmlMapper {
    @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        String stmt = "me.tka.mapping.userMapper.addUser";

        User user = new User();
        user.setName("Niuniu");
        user.setAge(2);

        int ret = sqlSession.insert(stmt, user);

        // 手动提交事务
//        sqlSession.commit();
        sqlSession.close();

        System.out.println(ret);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        String stmt = "me.tka.mapping.userMapper.deleteUser";

        int ret = sqlSession.delete(stmt, 1);

        sqlSession.close();

        System.out.println(ret);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        String stmtUpdate = "me.tka.mapping.userMapper.updateUser";

        User user = new User();
        user.setAge(20);
        user.setName("Niuniu");
        user.setId(9);
        int ret = sqlSession.update(stmtUpdate, user);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(ret);
    }

    @Test
    public void testGetUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        String stmt = "me.tka.mapping.userMapper.getUser";

        User user = sqlSession.selectOne(stmt, 9);

        sqlSession.close();

        System.out.println(user);
    }

    @Test
    public void testGetAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        String stmt = "me.tka.mapping.userMapper.getAllUsers";

        List<User> userList = sqlSession.selectList(stmt);

        sqlSession.close();

        System.out.println(userList);
    }
}
