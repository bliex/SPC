package com.spc.jpa.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "users", itemResourceRel = "user", collectionResourceRel = "users", excerptProjection = BasicUserProjection.class)
public interface UserRepository extends JpaRepository<User, String> {

	User findByIdAndPassword(String id, String password);

	/**
	 * 동일 아이디 갯수
	 * 
	 * @param id
	 * @return
	 */
	long countById(String id);

	/**
	 * 사용자 목록 조회
	 * 
	 * @param pageable
	 * @return Page<User>
	 */
	public Page<User> findAll(Pageable pageable);
}
