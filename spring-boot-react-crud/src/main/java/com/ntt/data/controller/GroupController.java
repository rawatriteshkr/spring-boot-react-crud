package com.ntt.data.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.data.model.Group;
import com.ntt.data.service.GroupService;

@RestController
@RequestMapping("/api")
public class GroupController {

	private final Logger log = LoggerFactory.getLogger(GroupController.class);

	@Autowired
	private GroupService groupService;

	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("/groups")
	public List<Group> findAllGroups() {
		return groupService.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("/group/{id}")
	public ResponseEntity<Group> getGroup(@PathVariable Long id) {
		Optional<Group> group = groupService.getGroup(id);
		return group.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@CrossOrigin(origins = {"http://localhost:3000"})
	@PostMapping("/group/save")
	public ResponseEntity<Group> saveGroup(@RequestBody Group group) throws URISyntaxException {
		Group result = groupService.saveGroup(group);
		return ResponseEntity.created(new URI("/api/group/" + result.getId())).body(result);
	}

	@CrossOrigin(origins = {"http://localhost:3000"})
	@PutMapping("/group/update/{id}")
	ResponseEntity<Group> updateGroup(@RequestBody Group group) {
		log.info("Request to update group: {}", group);
		Group result = groupService.saveGroup(group);
		return ResponseEntity.ok().body(result);
	}

	@CrossOrigin(origins = {"http://localhost:3000"})
	@DeleteMapping("/group/delete/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
		log.info("Request to delete group: {}", id);
		groupService.deleteGroupById(id);
		return ResponseEntity.ok().build();
	}
}
