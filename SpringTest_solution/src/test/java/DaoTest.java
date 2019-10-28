import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pms.model.dao.PhoneDao;
import com.ssafy.pms.model.dto.Phone;

@RunWith(SpringRunner.class)		//단위 테스트를 동작 시킬 대상을 지정
//@Transactional			//transaction이 필요한경우
@ContextConfiguration("classpath:/spring/application-config.xml")		//spring을 위한 bean configuration 설정
public class DaoTest {

	@Autowired
	PhoneDao dao;	//test할 dao
	
	@Test			//단위(함수, 기능)별 테스트
	public void testBean() {
		assertThat(dao, is(notNullValue()));
		//fail("Not yet implemented");
	}
	
	@Test
	public void insertPhoneTest() {
		Phone phone = new Phone("s1234", "note8", 100, "10");
		dao.insert(phone);
		Phone find = dao.search("s1234");
		assertThat(find, is(notNullValue()));
	}
	
	@Test
	public void deletePhoneTest() {
		List<String> list = Arrays.asList("s1234");
		dao.delete(list);
		Phone find = dao.search("s1234");
		assertThat(find, is(nullValue()));
	}

}
