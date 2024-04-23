package repository;

import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

// JDBC -> MyBatis(mybatis.org) -> Spring MyBatis -> Hibernate(ORM) -> JPA
// JDBC : Java + SQL : 유지보수 어렵다, 생산성이 떨어진다.
public class BookDAO {
    private static SqlSessionFactory sqlSessionFactory;
    // 초기화 블록
    static {
        try {
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CRUD method
    public List<Book> findAll() {
        // SqlSession 꺼내오기
        SqlSession session = sqlSessionFactory.openSession();

        // select * from book : SQL 전송(BookMapper.xml)
        List<Book> books = session.selectList("findAll");
        session.close();

        return books;
    }

    public int save(Book book) {
        // SqlSession 꺼내오기
        SqlSession session = sqlSessionFactory.openSession();

        // insert
        int cnt = session.insert("save", book);
        session.commit();   // 완료
        session.close();

        return cnt;
    }

}
