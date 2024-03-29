package com.mybatis;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.pojo.Student;
import com.mybatis.pojo.StudentWithEnum;
import com.mybatis.session.SqlSessionBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Gary
 * @since 2019/11/28 10:46
 */
public class SqlSessionCreator {

    private static final String RESOURCE = "mybatis/mybatis-config.xml";

    public static void main(String[] args) {
        /*
         * 保证SqlSession会关闭*/
        //SqlSession sqlSession = sqlSessionBuilderWithXml();
        /*try (SqlSession sqlSession = sqlSessionBuilderWithXml()) {
            *//*
             *映射器是一些由你创建的、绑定你映射的语句的接口。映射器接口的实例是从 SqlSession 中获得的。因此从技术层面讲，
             * 任何映射器实例的最大作用域是和请求它们的 SqlSession 相同的。尽管如此，映射器实例的最佳作用域是方法作用域。
             * 也就是说，映射器实例应该在调用它们的方法中被请求，用过之后即可丢弃。
             * 并不需要显式地关闭映射器实例，尽管在整个请求作用域保持映射器实例也不会有什么问题，
             * 但是你很快会发现，像 SqlSession 一样，在这个作用域上管理太多的资源的话会难于控制。
             * 为了避免这种复杂性，最好把映射器放在方法作用域内。*//*
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectStudent("01");
            sqlSession.commit();
            System.out.println(student);
            List<Student> students = sqlSession.selectList("com.mybatis_learn.mapper.StudentMapper.selectAllStudents");
            System.out.println(students);
            StudentWithEnum studentWithEnum = studentMapper.selectForEnum();
            System.out.println(studentWithEnum);
        }*/
        // closeSqlSession(sqlSession);
        for (int i = 0; i < 1; i++) {
            new Thread(SqlSessionCreator::testOne).start();
        }
    }

    private static void testOne() {
        long time = System.currentTimeMillis();
        SqlSessionFactory sqlSessionFactory = SqlSessionBuilder.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectStudent("01");
            StudentWithEnum studentWithEnum = studentMapper.selectForEnum();
            System.out.println(studentWithEnum);
            System.out.println(studentWithEnum.getSSex().getCode() + " "+studentWithEnum.getSSex().getValue());
        }
        System.out.println("testOne spend time: " + (System.currentTimeMillis() - time));
    }



    /**
     * 这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。
     * 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。
     * 你可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但是最好还是不要让其一直存在，
     * 以保证所有的 XML 解析资源可以被释放给更重要的事情。
     */
    private static SqlSession sqlSessionBuilderWithXml() {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。
         * 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。
         * 因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*
         * 每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，
         * 所以它的最佳的作用域是请求或方法作用域。 绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。
         * 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。
         * 如果你现在正在使用一种 Web 框架，要考虑 SqlSession 放在一个和 HTTP 请求对象相似的作用域中。
         * 换句话说，每次收到的 HTTP 请求，就可以打开一个 SqlSession，返回一个响应，就关闭它。
         * 这个关闭操作是很重要的，你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭。*/
        return sqlSessionFactory.openSession();
    }

    private static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    private static DataSource getDataSource() {
        //构建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        return dataSource;
    }

    private static SqlSession sqlSessionBuilder() {
        DataSource dataSource = getDataSource();
        //构建数据库事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建数据库运行环境
        Environment environment = new Environment("development", transactionFactory, dataSource);
        //构建configuration对象
        Configuration configuration = new Configuration(environment);
        //注册一个Mybatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
        //加入一个映射器
        configuration.addMapper(StudentMapper.class);
        //使用sqlSessionFactoryBuilder构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory.openSession();
    }
}
