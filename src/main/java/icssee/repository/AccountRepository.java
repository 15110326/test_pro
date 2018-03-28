package icssee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import icssee.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

	List<Account> findByusernameContaining(String q);
}
