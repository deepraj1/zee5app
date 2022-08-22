package com.zee.zee5app.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	 UserService service;
	
	
	@PostMapping("/create") // post method+requestmapping - 4.3
	public ResponseEntity<?> createUser(@RequestBody User user) throws UNableToGenerateIdException, UsernameExistsExecption, InvalidEmainException {
//		User user2=null;
//		try {
		User user2 = service.insertUser(user);
//		} catch (UNableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////			response with json based message stating that unable to create the id 
//			HashMap<String	, String> resData = new HashMap<>();
//			resData.put("status", "internal id creation problem");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resData);
//		} catch (UsernameExistsExecption e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			HashMap<String	, String> resData = new HashMap<>();
//			resData.put("status", "username already exists");
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(resData);
//			
//		} catch (InvalidEmainException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			HashMap<String	, String> resData = new HashMap<>();
//			resData.put("status", "email already exists");
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(resData);
//			
//		}
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	@PutMapping()
	public String updateUser(User user) {
		return "updated";
	}
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		return service.getUserById(id).get();
	}
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return service.getAllUsers().get();
	}
	@DeleteMapping( "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
		String res="kul";
		try {
			res = service.deleteUser(id);
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
//			System.out.println("sdsbkib");
			e.printStackTrace();
			HashMap<String	, String> resData = new HashMap<>();
			resData.put("status", "no data found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resData);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
		
	}

}




//{
//    "userId":"kul101",
//    "firstName":"jjjj",
//    "lastName":"deep",
//    "email":"kuldeep1005000@gmail",
//    "doj":"11-11-2011",
//    "dob":"10-10-2010",
//    "active":true,
//    "userName":"kuls10900000",
//    "password":"password"
//}
