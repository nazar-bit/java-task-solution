package pjv.hello.vasylnaz.xml_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pjv.hello.vasylnaz.xml_task.service.DataService;

@SpringBootApplication
public class XmlTaskApplication implements CommandLineRunner {

	private final DataService dataService;

	public XmlTaskApplication(DataService dataService) {
		this.dataService = dataService;
	}

	public static void main(String[] args) {
		SpringApplication.run(XmlTaskApplication.class, args);
	}

	@Override
	public void run(String... args) {
		dataService.processXmlData();
	}
}