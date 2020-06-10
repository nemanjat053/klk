package stuService.ewq.controller;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stuService.ewq.model.Student;
import stuService.ewq.model.StudentPermission;
import stuService.ewq.repository.PermissionRepository;
import stuService.ewq.repository.StudentRepository;
import stuService.ewq.service.StudentService;
import stuService.ewq.utils.TokenUtils;

@Controller
@RequestMapping(path = "api/")
public class LoginController {

	@Autowired
	private StudentRepository sr;

	@Autowired
	private PermissionRepository pr;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> login(@RequestBody Student student) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(student.getIme(),
					student.getLozinka());
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = userDetailsService.loadUserByUsername(student.getId().toString());
			String userToken = tokenUtils.generateToken(userDetails);
			HashMap<String, String> data = new HashMap<>();

			data.put("token", userToken);
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Student student) {
		student.setLozinka(passwordEncoder.encode(student.getLozinka()));

		student = sr.save(student);
		student.setStudentPermissions(new HashSet<>());
		student.getStudentPermissions().add(new StudentPermission(null, student, pr.findById(1l).get()));
		sr.save(student);
		return new ResponseEntity<String>(student.getIme(), HttpStatus.OK);

	}

	@Secured("ROLE_STUDENT")
	@RequestMapping(path = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Authorized", HttpStatus.OK);
	}
}
