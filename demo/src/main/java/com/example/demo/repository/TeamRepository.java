package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	@Query(value = "from Team t where t.id=:id")
	Team getTeamById(@Param("id") Long id);
    
	@Query(value= "from Team t where t.teamName=teamName")
	Team getTeamByName(@Param("teamName") String teamName);
	
	
}
