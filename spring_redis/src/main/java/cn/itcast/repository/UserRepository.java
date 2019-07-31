package cn.itcast.repository;

import cn.itcast.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Integer>{
}
