package stuService.ewq.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@OneToMany(mappedBy = "permission")
	private Set<StudentPermission> studentPermission;

	public Permission() {
		super();
	}

	public Permission(Long id, String title, Set<StudentPermission> studentPermission) {
		super();
		this.id = id;
		this.title = title;
		this.studentPermission = studentPermission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<StudentPermission> getStudentPermission() {
		return studentPermission;
	}

	public void setStudentPermission(Set<StudentPermission> studentPermission) {
		this.studentPermission = studentPermission;
	}

}
