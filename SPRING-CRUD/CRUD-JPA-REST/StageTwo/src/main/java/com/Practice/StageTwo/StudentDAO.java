package com.Practice.StageTwo;

import java.util.List;

public interface StudentDAO {
	public void save(Student theStudent); 
	public Student Retrieve(Integer id);
	public List<Student> findAll();
	public void Update(Student theStudent);
	public void delete(Student theStudent);
	public int deleteOnCondition();
	public int deleteAll();
}
