package icssee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import icssee.domain.News;;

public interface NewsRepository extends CrudRepository<News, Integer>{

	List<News> findBycreaterContaining(String q);
}
