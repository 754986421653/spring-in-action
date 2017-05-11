package com.bakhtiyor.spittr.repositories;

import java.util.List;

import com.bakhtiyor.spittr.models.Spittle;

public interface SpittleRepository {

	List<Spittle> findSpittles(long max, int count);
}