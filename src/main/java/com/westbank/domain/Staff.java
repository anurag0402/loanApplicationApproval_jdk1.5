package com.westbank.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {
	private static final long serialVersionUID = 3307266703100699329L;

	@Id
	protected String staffId;

	@Basic
	protected String firstName;

	@Basic
	protected String lastName;

	@Basic
	protected String password;

	@ManyToMany(
			targetEntity = Role.class,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE },
			fetch = FetchType.LAZY  // Explicitly set to LAZY (default, but good to be explicit)
	)
	@JoinTable(
			name = "staff_role",
			joinColumns = @JoinColumn(name = "staff_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	protected List<Role> role;

	public Staff() {
		this.role = new ArrayList<Role>(); // Initialize collection to avoid null pointer issues
	}

	public Staff(String staffId, String firstName, String lastName, String password, List<Role> role) {
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role != null ? role : new ArrayList<Role>();
	}

	public String getStaffId() {
		return staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		if (role == null) {
			role = new ArrayList<Role>();
		}
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role != null ? role : new ArrayList<Role>();
	}

	public void addRole(Role newRole) {
		if (newRole != null) {
			if (role == null) {
				role = new ArrayList<Role>();
			}
			if (!role.contains(newRole)) { // Avoid duplicate roles
				role.add(newRole);
			}
		}
	}

	public void removeRole(Role roleToRemove) {
		if (role != null && roleToRemove != null) {
			role.remove(roleToRemove);
		}
	}

	public boolean hasRole(String roleName) {
		if (role == null || roleName == null) {
			return false;
		}
		// Replaced Stream API with a traditional for-loop (Java 5 compatibility)
		for (Role r : role) {
			if (roleName.equals(r.getRoleName())) {
				return true;
			}
		}
		return false;
	}

	public String getFullName() {
		return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Staff staff = (Staff) obj;
		return staffId != null ? staffId.equals(staff.staffId) : staff.staffId == null;
	}

	@Override
	public int hashCode() {
		return staffId != null ? staffId.hashCode() : 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Staff: ").append(staffId)
				.append(": ").append(firstName).append(" ").append(lastName);

		// Safe toString for roles to avoid lazy loading issues in toString
		if (role != null) {
			try {
				sb.append("; roles=").append(role.size()).append(" role(s)");
			} catch (Exception e) {
				sb.append("; roles=<not loaded>");
			}
		} else {
			sb.append("; roles=none");
		}

		return sb.toString();
	}
}
