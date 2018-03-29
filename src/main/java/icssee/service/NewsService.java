package icssee.service;

import java.util.List;

import icssee.domain.News;

public interface NewsService {

	Iterable<News> findAll();

	List<News> search(String q);

	News findOne(int id);

	void save(News news);

	void delete(int id);
}
