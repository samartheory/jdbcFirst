package first;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class jdbcTest {

    @Test
    void test1() throws SQLException {
        jdbc obj = new jdbc();
        obj.test();
        ResultSet rs = obj.select();
        int i=0;
        while(rs.next()){
            i++;
        }
        assertEquals(3,i);
    }
}