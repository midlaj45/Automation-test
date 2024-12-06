package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Team;
import com.example.demo.repository.TeamRepository;

@RestController
@RequestMapping(value = "/training/")
public class TestController {

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public Optional<Team> print() {
		System.out.println("-----first api");

		Team t = teamRepository.getTeamById(51L);

		Team t1 = new Team();
		t1.setTeamName("ABC");
		
		Optional<Team> t2 = teamRepository.findById(51l);
		
		teamRepository.save(t1);
		teamRepository.delete(t);

		return t2;

	}

	@RequestMapping(value = "/print/{name}", method = RequestMethod.GET)
	public Team printing(@PathVariable("name") String name) {
		System.out.println("-----first api");

		Team t = teamRepository.getTeamByName(name);

		return t;
	}
}
