package com.zee.zee5app;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//import java.lang.reflect.Array;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//import com.zee.zee5app.dto.Employee;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;
//import com.zee.zee5app.repo.EmployeeRepository;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.MovieServiceImpl;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;
import com.zee.zee5app.service.WebSeriesService;

@SpringBootApplication
public class Zee5appApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(Zee5appApplication.class, args);
		
		
		
		
//		ConfigurableApplicationContext context = null; 
//		 context = SpringApplication.run(Zee5appApplication.class, args);
////		DataSource dataSource = context.getBean(DataSource.class);
////		System.out.println(dataSource!=null);
////		
//
//////		
//		 UserService impl =  context.getBean(UserService.class);
////		 impl.insertUser(new User("abhi","chivate","kuldeepi",LocalDate.now(),LocalDate.of(1988, 12, 9));
////		User user = ;
//		 
//		try {
//			impl.insertUser(new User("000kkks2","kul3","deep3","kuldeep4@gmail.com",LocalDate.now(),LocalDate.of(2022, 1, 1),true,"username4","password2"));
//		} catch (UNableToGenerateIdException | UsernameExistsExecption | InvalidEmainException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		
		
		
		
//		impl.insertUser(new User(1,"kul","deep","kuldeepraj@gmail.com",LocalDate.now(),LocalDate.of(2001, 1, 2),true));
			
//		try {
//			System.out.println("del----->   "+impl.deleteUser(2));
//		} catch (NoDataFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 System.out.println("alll----->   "+impl.getAllUsers());
		
//		String[] actors = {"a","b","c"};
////		String[] genre = {"ag","bg","cg"};
//		String[] lan = {"al","bl","cl"};
		
		
		
		
		
		
////		
//		MovieService impl = context.getBean(MovieService.class);
		
//		try {
//			impl.insertMovie(new Movie("rr107","actors" ,"rrr12","director","HORROR",
//					"production","lan",(float) 2.0,"C:\\Users\\kuldeep.raj\\Downloads\\vid.mp4" ));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UNableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		List<Movie> mov =  impl.getAllMoviesByName("rrr").get();
//		for (Movie movie : mov) {
//			System.out.println(movie);
//		}
		
		
//		try {
//			impl.insertMovie(new Movie());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UNableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		private int WebsId;
//		private String WebsName;
//		private int totalSeason;
//		private String[] audioLanguage;
//		private LocalDate realseDate;
//		private String Director;
//		private String[] cast;
//		private String languages[];
//		private Genre genre;
		
		
//		WebSeriesService  series = context.getBean(WebSeriesService.class);
//		
//		series.insertWebs(new WebSeries("ab1","series",2,lan,LocalDate.now(),"director",actors,lan,Genre.DRAMA));
		
//		private Long id;
//		private String name;
//		private String dept;
//		private int salary;
		
		
		
//		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//		
////		employeeRepository.save(new Employee((long) 500,"name1","dept5",1002));
//		 List<Employee> em =  employeeRepository.findBySalaryGreaterThanEqual(1000);
////		 System.out.println(em);
//		for (Employee employee : em) {
//			System.out.println(employee);
//		}
		
		
//		
		
		
		
		
		
		
		
//		
//		context.close();
	}

}
