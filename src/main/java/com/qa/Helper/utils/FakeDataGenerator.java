package com.qa.Helper.utils;

import java.util.Random;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	static Faker faker = new Faker();
	static Random random = new Random();

	public static String getFullName() {
		return faker.name().fullName();
	}

	public static String getEmail() {
		return faker.internet().emailAddress();
	}

	public static String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public static String getAddress() {
		return faker.address().fullAddress();
	}

	public static String getCity() {
		return faker.address().city();
	}

	public static int getCompanyId() {
		return 20154;
	}

	public static String getRandomPassword() {
		return faker.internet().password(8, 16, true, true);
	}

	public static String getCreditCardNumber() {
		return faker.finance().creditCard();
	}

	public static String getUUID() {
		return faker.internet().uuid();
	}
/*
//	public static float randomid() {
	//	return random.nextFloat(0, 0);
	}
*/
	public static String getRandomString() {

		return faker.address().secondaryAddress();
	}
/*
	public static int randomStructure() {
		return random.nextInt(101, 999);
	} */
}
