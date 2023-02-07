package com.svj.graphqlpaging.repository;

import com.svj.graphqlpaging.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {
}
