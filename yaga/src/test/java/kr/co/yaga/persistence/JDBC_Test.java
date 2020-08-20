package kr.co.yaga.persistence;

import static org.junit.Assert.fail;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

@Log4j
public class JDBC_Test {

	static {
		try {
				Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@Test
	public void connTest() {
		
		try(Connection con = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/test", "yaga", "xpfks86!@")) {
			
			log.info("Conn Success ~!");
			
		} catch (Exception e) {	
			e.printStackTrace();				
			fail(e.getMessage());
				
		}
	}
}
