package org.gowtham.fullstackecommercebackend.Repository;

import org.gowtham.fullstackecommercebackend.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<Users,Long> {
}
