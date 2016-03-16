package com.spc.jpa.domain.onetoone;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "persons", itemResourceRel = "person", collectionResourceRel = "persons")
public interface OneToOneRepository extends JpaRepository<Person, String> {

	/**
	 * 사용자 목록 조회 (페이징)
	 * 
	 * @param pageable
	 * @return Page<Board>
	 */
	public Page<Person> findAll(Pageable pageable);
	
}
