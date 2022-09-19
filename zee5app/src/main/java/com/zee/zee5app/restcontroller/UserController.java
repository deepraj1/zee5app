package com.zee.zee5app.restcontroller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.EROLE;
import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
//import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.repo.RoleRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	@Autowired
	 UserService service;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtils jwtUtils;
	
	
	@PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername()
						, loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetailsImpl.getAuthorities()
				.stream()
				.map(i->i.getAuthority())
				.collect(Collectors.toList());
		
		
	
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetailsImpl.getId(),
				userDetailsImpl.getUsername(),
				userDetailsImpl.getEmail(),
				roles));
//		return ResponseEntity.status(HttpStatus.OK).body("han ho gaya");
	}
	@PostMapping("/signup") // post method+requestmapping - 4.3
	public ResponseEntity<?> createUser(@Valid @RequestBody SignupRequest signupRequest) throws UNableToGenerateIdException, UsernameExistsExecption, InvalidEmainException {
		
		
		User user  = new User(signupRequest.getFirstName(),signupRequest.getLastName()
				,signupRequest.getEmail(),LocalDate.now(),null
				,true,signupRequest.getUsername(), 
				   encoder.encode(signupRequest.getPassword()));
		
		
		
//		Set<String> strRoles = signupRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			System.out.println("inside the if condition");
//			Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Error:role not found"));
//			roles.add(userRole);
//		}
//
//		else {
//			strRoles.forEach(e -> {
//				switch (e) {
//				case "admin":
//					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error:role not found"));
//					roles.add(roleAdmin);
//					break;
//
//				case "mod":
//					Role roleMod = roleRepository.findByRoleName(EROLE.ROLE_MODERATOR)
//							.orElseThrow(() -> new RuntimeException("Error:role not found"));
//					roles.add(roleMod);
//					break;
//
//				default:
//					Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error:role not found"));
//					roles.add(userRole);
//				}
//			});
//
//		}
////		System.out.println(roles);
//		user.setRoles(roles);
		service.insertUser(user);
		
		HashMap<String	, String> resData = new HashMap<>();
		resData.put("status", "user created successfully");
		return ResponseEntity.status(201).body(resData);
		
		
//		System.out.println(user);
//		return ResponseEntity.status(201).body(user);
//		User user2=null;
//		try {
//		User user2 = service.insertUser(user);
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
//		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	@PutMapping("/update")
	public String updateUser(@Valid @RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		service.updateUser(user).get();
		return "user updated succesfully ";
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

//{
//	   "firstName":"jjjj",
//	   "lastName":"deep",
//	   "email":"kuldeep1005000111@gmail",
//	   "dob":"10-10-2010-03-22-22",
//	   "username":"kuls10900000111",
//	   "password":"password",
//	    "role":["admin","mod"]
//	}
//{
//	   "firstName":"AKnkAXK",
//	   "lastName":"SKXNAksBXJKSAb",
//	   "email":"kul@gmail",
//	   "dob":"10-10-2010-03-22-22",
//	   "username":"kulll2l",
//	   "password":"XSAXSANXKJASXASlNX",
//	    "role":["admin","mod"]
//	}


//what is role in user dto why roles is not in the user table
//how to handle duplicates in movie and webs


//{
//	   "firstName":"Kuldeep",
//	   "lastName":"Raj",
//	   "email":"kuldeep@gmail",
//	   "username":"kuldeepraj",
//	   "password":"password1"
//	}
//{
//    "userId": "KR0000000002",
//    "firstName": "Kuldeep",
//    "lastName": "Rohlan",
//    "email": "kuldeep@gmail",
//    "doj": "14-09-2022",
//    "dob": "10-10-2010-03-22-22",
//    "active": true,
//    "userName": "kuldeepraj",
//    "password": "password",
//    "roles": []
//}