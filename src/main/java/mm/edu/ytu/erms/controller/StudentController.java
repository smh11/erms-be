package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.edu.ytu.erms.model.Student;

import mm.edu.ytu.erms.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public List<Student> getAll(){
		return studentService.getAll();
	}
	@GetMapping(value = "{entrance_id}")
	public Student getOne(@PathVariable String entrance_id) {
		return studentService.getOne(entrance_id);
	}
	@PostMapping
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}
	@RequestMapping(method = RequestMethod.PUT)
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @RequestMapping(value = "{entrance_id}", method = RequestMethod.DELETE)
    public void deleteByCode(@PathVariable String entrance_id){
        studentService.deleteById(entrance_id);
    }
	
}
