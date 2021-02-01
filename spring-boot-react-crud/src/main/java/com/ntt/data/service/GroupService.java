package com.ntt.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.data.dao.GroupRepository;
import com.ntt.data.model.Group;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	public Group saveGroup(Group group) {
		return groupRepository.save(group);
	}
	
	public List<Group> findAll(){
		return groupRepository.findAll();
	}
	
	public Optional<Group> getGroup(Long id) {
		return groupRepository.findById(id);
	}
	
	public void deleteGroupById(Long id) {
		groupRepository.deleteById(id);
	}
}
