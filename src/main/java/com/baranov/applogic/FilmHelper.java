package com.baranov.applogic;

import java.util.List;

import com.baranov.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	List<String> search(String title);
	boolean IsErrorsPresent();
	public String searchFilmTitle (String title);

}
