package com.bakhtiyor.spittr.repositories;

import com.bakhtiyor.spittr.models.Spitter;

public interface SpitterRepository {

	Spitter save(Spitter spitter);

	Spitter findOneByUsername(String username);
}