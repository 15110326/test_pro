package icssee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icssee.domain.Account;
import icssee.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Iterable<Account> findAll(){
		return accountRepository.findAll();
	}
	
	@Override
	public List<Account> search(String q){
		return accountRepository.findByusernameContaining(q);
	}
	
	@Override
	public Account findOne (int id) {
		return accountRepository.findOne(id);
	}
	
	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	@Override
	public void delete(int id) {
		accountRepository.delete(id);
	}
}
