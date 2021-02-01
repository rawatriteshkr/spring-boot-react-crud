package com.ntt.data.initializer;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ntt.data.model.Group;
import com.ntt.data.service.GroupService;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private GroupService groupService;

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Denver JUG", "Utah JUG", "Seattle JUG", "Richmond JUG")
				.forEach(name -> groupService.saveGroup(new Group(name)));

		groupService.findAll().forEach((n) -> System.out.println(n.getId() + "," + n.getName()));
	}

}
