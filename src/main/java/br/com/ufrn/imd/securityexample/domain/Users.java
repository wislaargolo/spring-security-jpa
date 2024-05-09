package br.com.ufrn.imd.securityexample.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Users {
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USR")
	@SequenceGenerator(name="SEQ_USR", sequenceName="id_seq_usr", allocationSize=1)
    private Long id;

	@NotEmpty(message = "Username is required.")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    private String username;

	@NotEmpty(message = "Password is required.")
	@Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;
    private boolean active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}

