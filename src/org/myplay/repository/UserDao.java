package org.myplay.repository;

import java.util.List;

import org.myplay.entity.Role;
import org.myplay.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, String> {
	User findByScreenName(String screenName);

	@Query(" select o from Role o where o.id = ? ")
	List<Role> getRole(String userId);
}
