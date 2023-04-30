package com.test.mybatis.test;


import com.test.mybatis.mapper.EmpMapper;
import com.test.mybatis.pojo.Emp;
import com.test.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void testMBG() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 查询所有数据
//            List<Emp> list =  mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("五哥").andAgeEqualTo(18);
//            example.or().andDidIsNotNull();
//            mapper.selectByExample(example).forEach(emp -> System.out.println(emp));
            mapper.updateByExampleSelective(new Emp(9, "三哥", 24, null, "123456@qq.com", 1), null);
//            mapper.updateByExample(new Emp(9, "三哥", 24, null, "123456@qq.com", 1), null);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
