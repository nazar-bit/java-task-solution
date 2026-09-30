# XML Parser & Importer

## 1. Spuštění přes Docker

Kompletní prostředí (aplikace i databáze) běží v kontejnerech. Databázové schéma se vytvoří automaticky při startu databázového kontejneru ze souboru `init.sql`.



### Postup
V kořenové složce projektu spusťte:
   ```bash
   docker-compose up --build
```


## 2. Spuštění lokálně

### Postup
1. Vytvořte databázi xml_task_db.
2. Ručně spusťte SQL příkazy ze souboru init.sql.
3. V souboru src/main/resources/application.properties nastavte přihlašovací údaje k vaší databázi.
4. Spustit pomocí Maven:
    ```bash
   mvn spring-boot:run
