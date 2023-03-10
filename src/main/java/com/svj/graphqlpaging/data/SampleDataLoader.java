package com.svj.graphqlpaging.data;

import com.github.javafaker.Faker;
import com.svj.graphqlpaging.model.Address;
import com.svj.graphqlpaging.model.Person;
import com.svj.graphqlpaging.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final PersonRepository repository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository repository) {
        this.repository = repository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {

        // create 100 rows of people in the database
        List<Person> people = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                )).toList();

        repository.saveAll(people);
    }
}
