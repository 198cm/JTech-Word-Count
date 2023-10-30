package com.WordCounterConsumer.wordcounterclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class WordCounterClientApplication {


	public static String wordCountURL = "";
	private static final Logger log = LoggerFactory.getLogger(WordCounterClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WordCounterClientApplication.class, args);
	}

	public static void displayMenu() {
		System.out.println("Choose a function:");
		System.out.println("1. Calculate the highest frequency word in a text");
		System.out.println("2. Calculate the frequency of a given word in the text");
		System.out.println("3. Calculate the 'n' words with highest frequency in the text");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	public static int getUserChoice(Scanner scanner) {
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		return choice;
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			String inputText;
			String inputWord;
			int inputN;
			String response;

			while (true) {
				displayMenu();
				int choice = getUserChoice(scanner);

				switch (choice) {
					case 1:
						System.out.print("Enter text: ");
						inputText = scanner.nextLine();
						wordCountURL = String.format("http://localhost:8080/v1/calculateHighestFrequency?text=%s", inputText);
						response = restTemplate.getForObject(wordCountURL, String.class);
						log.info("Response from the API: " + response);
						break;
					case 2:
						System.out.print("Enter text: ");
						inputText = scanner.nextLine();
						System.out.print("Enter a word: ");
						inputWord = scanner.nextLine();
						wordCountURL = String.format("http://localhost:8080/v1/calculateFrequencyForWord?text=%s&word=%s", inputText, inputWord);
						response = restTemplate.getForObject(wordCountURL, String.class);
						log.info("Response from the API: " + response);
						break;
					case 3:
						System.out.print("Enter text: ");
						inputText = scanner.nextLine();
						System.out.print("Enter number: ");
						inputN = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character
						wordCountURL = String.format("http://localhost:8080/v1/calculateMostFrequentNWords?text=%s&n=%d", inputText, inputN);
						response = restTemplate.getForObject(wordCountURL, String.class);
						log.info("Response from the API: " + response);
						break;
					case 0:
						System.out.println("Exiting the program. Goodbye!");
						return;
					default:
						System.out.println("Invalid choice. Please enter a number between 1 and 3.");
				}
			}
		};
	}





}
