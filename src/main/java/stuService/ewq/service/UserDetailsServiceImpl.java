package stuService.ewq.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stuService.ewq.model.Student;
import stuService.ewq.model.StudentPermission;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private stuService.ewq.service.StudentService studentService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

		Student student = studentService.findOne(Long.parseLong(id));
		if (student != null) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (StudentPermission sp : student.getStudentPermissions()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(sp.getPermission().getTitle()));
			}
			return new User(student.getIme(), student.getLozinka(), grantedAuthorities);
		}
		return null;
	}

}
