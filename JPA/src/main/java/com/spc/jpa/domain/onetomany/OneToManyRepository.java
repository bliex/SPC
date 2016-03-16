package com.spc.jpa.domain.onetomany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "members", itemResourceRel = "member", collectionResourceRel = "members")
public interface OneToManyRepository extends JpaRepository<Member, String> {

	/**
	 * 사용자 목록 조회 (페이징)
	 * 
	 * @param pageable
	 * @return Page<Board>
	 */
	public Page<Member> findAll(Pageable pageable);
	
}
