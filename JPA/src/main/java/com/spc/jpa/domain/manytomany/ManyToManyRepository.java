package com.spc.jpa.domain.manytomany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "categries", itemResourceRel = "category", collectionResourceRel = "categries")
public interface ManyToManyRepository extends JpaRepository<Category, String> {

	/**
	 * 사용자 목록 조회 (페이징)
	 * 
	 * @param pageable
	 * @return Page<Board>
	 */
	public Page<Category> findAll(Pageable pageable);
	
}
