package study.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.*;
import javax.persistence.EntityManager;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
class QuerydslApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		Hello hello = new Hello();
		em.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QHello qHello = QHello.hello;

		Hello result = query
				.selectFrom(qHello)
				.fetchOne();

		assertThat(result).isEqualTo(hello);
		assertThat(result.getId()).isEqualTo(hello.getId());
	}

	@Test
	void startQueryDsl() throws Exception{

		Team team = new Team("재성팀");

		Member member = new Member("김재성", 29, team);
		em.persist(member);

		//given
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
		QMember m = new QMember("m");

		Member findMember = jpaQueryFactory
				.select(m)
				.from(m)
				.where(m.username.eq("김재성"))
				.fetchOne();

		//when

		//then
		assertThat(findMember.getUsername()).isEqualTo("김재성");
	}

}
