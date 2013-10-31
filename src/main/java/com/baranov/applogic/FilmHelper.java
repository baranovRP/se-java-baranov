package com.baranov.applogic;

import java.util.List;

import com.baranov.model.Film;

public interface FilmHelper {

	void create(Film film);

	String delete(String film);

	List<String> search(String title);

	boolean IsErrorsPresent();

	public String searchFilmTitle(String title);

	String filmNotFound(String title);

}
