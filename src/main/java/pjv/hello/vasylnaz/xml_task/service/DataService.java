package pjv.hello.vasylnaz.xml_task.service;

import org.springframework.stereotype.Service;
import pjv.hello.vasylnaz.xml_task.client.XmlFetcher;
import pjv.hello.vasylnaz.xml_task.parser.XmlParser;
import pjv.hello.vasylnaz.xml_task.repository.VillagePartRepository;
import pjv.hello.vasylnaz.xml_task.repository.VillageRepository;

import java.io.InputStream;

@Service
public class DataService {

    private final XmlFetcher fetcher;
    private final XmlParser parser;
    private final VillageRepository villageRepository;
    private final VillagePartRepository villagePartRepository;

    private static final String XML_URL = "https://www.smartform.cz/download/kopidlno.xml.zip";

    public DataService(XmlFetcher fetcher,
                       XmlParser parser,
                       VillageRepository villageRepository,
                       VillagePartRepository villagePartRepository) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.villageRepository = villageRepository;
        this.villagePartRepository = villagePartRepository;
    }

    public void processXmlData() {
        try {
            InputStream xmlStream = fetcher.fetchAsInputStream(XML_URL);
            XmlParser.ParsedData data = parser.parse(xmlStream);

            villageRepository.saveAll(data.villages());
            villagePartRepository.saveAll(data.villageParts());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}