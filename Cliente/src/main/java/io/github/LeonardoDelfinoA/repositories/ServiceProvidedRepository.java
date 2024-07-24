package io.github.LeonardoDelfinoA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.LeonardoDelfinoA.model.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

	@Query( "select s from ServiceProvided s join s.client c "
			+ " where upper(c.name) like upper(:name) and MONTH(s.date) =:month ")
	List<ServiceProvided> findByClientNameAndMonth(
			@Param("name") String name, @Param("month") Integer month);
}
