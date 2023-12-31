## Kristian Karlson

Inlämningsuppgift YH Campus Mölndal Jinv23 Systemintegration 45 YHP

### Beskrivning av projektet

Skapat ett projekt med 4 moduler. En konsol Client, WebApi/Kafka Producer, Kafka consumer som sparar i mySQL databas. En
Modul med Objektet som används av alla moduler.
Klientapplikationen slumpar fram fiktiva Pokémon som skickas till ett webAPI. 
webApi skickar sen vidare payload på ett Kafka topic. Topic läses av en Kafka consumer som sparar objekten i en mySQL databas. 
Klientapplikationen läser av samma topic så man kan visuellt bekräfta att informationen har skickats på topic.

### Flödesschema

```mermaid
stateDiagram-v2
    [*] --> ClientApplication
    ClientApplication --> webAPI/KafkaProducer: pokemon
    webAPI/KafkaProducer
    webAPI/KafkaProducer --> KafkaTopic: pokemon
    KafkaTopic --> mySQL/KafkaConsumer: pokemon
    KafkaTopic --> ClientApplication: pokemon
```

En pokemon är ett objekt. Den separata modulen skapar alla objekt. I Json ser en pokemon ut såhär:  
```json
{  
    "pokedexNumber": 6,  
    "name": "Charizard",  
    "total": 240,  
    "hp": 78,  
    "attack": 84,  
    "defence": 78,  
    "types":[  
        {  
        "slot": "first",  
        "type": "FIRE"  
        },  
        {  
        "slot": "second",  
        "type": "FLYING"  
        }  
    ]  
}  
``` 
### Starta applikationen

Applikationen är testad med java Amazon Corretto 17.0.8 och med Java 21

1. Ladda ner Apache Kafka från https://kafka.apache.org/ applikationen är testad med version 3.5.1  
2. Extrahera nedladdningen till valfri mapp på din dator.
3. Kopiera filerna server1.properties, server2.properties & server3.properties från DWSJ/kafkaConfigs till din installation av Kafka/config
4. I varje server.properties fil på rad 62 konfigurera mappen som kafkas message broker ska logga filerna, varje broker kräver en separat mapp. Exempel: log.dirs=C:\temp\kakfa\logs\broker92\kafka-logs
5. Öppna filen kafka/config/zookeeper.properties och ställ in lämplig mapp för loggning exempelvis: dataDir=C:\temp\kakfa\logs\zookeeper
6. Öppna fyra stycken terminaler i din kafka mapp. Kör ett kommando i vardera terminal  
   1. .\bin\windows\zookeeper-server-start.sh config\zookeeper.properties
   2. .\bin\windows\kafka-server-start.sh config\server1.properties
   3. .\bin\windows\kafka-server-start.sh config\server2.properties
   4. .\bin\windows\kafka-server-start.sh config\server3.properties
7. Installera mySQL server https://www.mysql.com/ på port 3306
8. Skapa schema "pokedb" och koppla till användare "user" med lösenord "password" med rättigheter till schemat
   1. Alternativt ändra i filen /DWSJ/Pokemon-Consume-SQL/src/main/resources/application.properties
9. Frivilligt, skapa schema "testdb" med användare "test" lösenord "test" och rättigheter till schemat
   1.  Alternativt ändra i filen /DWSJ/Pokemon-Consume-SQL/src/test/resources/application-test.properties
10. Starta modulen kafkaProducer-restApi den använder port 8080, denna modul skapar kafka topic
11. Starta modulen kafkaConsumer-mySQL
12. Starta modulen User-Client, använd klient applikationen. 



### Konfiguration av Kafka kluster

#### Skriv dokumentation som beskriver ditt Apache Kafka-klusters konfiguration och hur producenten och konsumenterna är implementerade.
För projektet används ett kafkakluster med en zookeeper och tre stycken brokers. Alla instanser kördes lokalt.
Producer har timeout på 60 sekunder finns inga brokers under den tiden får klientapplikationen felkod ifrån restAPI.

För att göra systemet mer tillgängligt i produktionsmiljö ska man använda sig av flera (mer en 3) zookeepers och brokers som körs på olika
hårdvara och beroende på applikationens användningsområde ska de ha olika internetanslutningar. Det säkerställer tillgänglighet och redundans.
Det är möjligt att i zookeeper begränsa antalet ansluta brokers från samma ip.
Antalet partitioner till varje topic är kvar på 1, har man topics med mycket trafik kan den ökas för att förbättra parallellisering av konsumtion.

Brokers ska gå på olika servrar ha unikt rack id när så är fallet, och vara placerade på ett lämpligt sätt bland
producerande och konsumerande klienter för säkerställa snabb meddelandeöverföring.

Det är kritiskt att man ställer replikeringsfaktorn för topic till tre eller högre för säkerställa att meddelanden
sprids över flera brokers. Det säkerställer att topic är tillgänglig även om server är nere för planerat eller oplanerat underhåll.
Kafka kommer själv balansera vilka brokers som hanterar vilka topics.  
"Log Flush Policy" är inställningar för när data på en kafka broker skrivs till hårddisk. Det är en balansgång mellan
stora skrivjobb som kan ge laggspikar och små skrivjobb som ger mer söktid. 

Om man ska skapa en kafka consumer som läser ifrån flera topics så använder man sig av java regex för att ange topics.
Har man redan i planeringsskedet tänkt till med topic namnen blir regex uttrycket mycket lättare att skapa.

Kafka consumers kan delas in i grupper varje grupp kan bara konsumera meddelanden en gång. Det Möjliggör att man lätt
kan parallellisera konsumerande av meddelanden ifall det krävs. I det här fallet är konsumenten som skickar till databasen i en grupp och användare klienten i en annan.  

Optimering: Utvärdera och implementera effektiva sätt att
skicka och behandla meddelanden i ditt Kafka-kluster.

### Utöka dokumentationen med en djupare förståelse av de val du gjort avseende konfiguration, säkerhet och optimering.
Implementeringen av är inte säkrad, anslutande producers och consumers är anonyma. Det innebär att alla kan skicka meddelanden och skapa topics. Meddelanden skickas okrypterat. 

För att höja säkerheten behöver ändra så det krävs autentisering för att veta vem som ansluter och auktorisering för vilka rättigheter som ges i broker. Det krävs även att man ställer in så brokers behöver autentisera med zookeeper och varandra.

Steget därefter är att analysera om trafiken behöver krypteras. I utvecklingsmiljö är det inte aktuellt men i produktionsmiljö ställs krav på att skydda personuppgifter och företagskänsligt data.
Även om uppgifter av den karaktären inte hanteras initial finns risken att så sker senare och kryptering ska införas från start.
Krypteringsalternativen är SSL (Bra för molnlösningar) eller SASL SSL är företag med befintligt autentiserings lösning med Kerberos.
Det är flera delar av trafiken som behöver krypteras dels från producers, consumers, trafiken mellan brokers och trafiken till Zookeeper. Även data på disk kommer behöva krypteras.
Men i tex krasch dumpar kommer data vara okrypterad. Har man mycket känslig data eller har en molnbaserad lösning ska trafiken krypteras end-to-end.

Zookeepers behöver skyddas i nätverksmiljön det är bara administreringsverktyg och brokers som kan få nå dom.
Man behöver även fundera på hur man skyddar sina brokers från distributed denial-of-service attacker (DDoS).

Bra introduktion till kafka och säkerhet -> https://developer.confluent.io/courses/security/intro/
I sista filmen summerar de alla säkerhetsåtgärderna till en checklista. 

## Arbetet och dess genomförande

### Vad som varit svårt

Inledningsvis fanns det problem med att hanterandet av objekten då de definierades i alla moduler. När det bröts ut till
egen modul blev ändringar lättare att genomföra.  
Det var krångel med att flytta med rätt dependecys till rätt modul.

### Beskriv lite olika lösningar du gjort
Beslutade mig en bit in i utvecklandet att bryta ner programmet i flera moduler för att tydliggöra ansvarsområdena.
Objekten blev egen modul, det underlättade genomförandet av förändringar i objektet. Ändringar följer med till alla moduler. Använde mig av "create-drop" av
databasen för att snabbt kunna testa olika lösningar.
Kört MySQL och Kafka i Docker containers, väldigt smidigt!
Skapade CI flöde i Github Actions och en in memory databas före tester med H2.

### Beskriv något som var besvärligt att få till
Springboot och Annoteringar var nytt för mig, blir lite annorlunda sätt att skriva kod.  
Spara pokemon objekten i databasen, kopplingen med underobjekten och huvudobjektet. Min första lösning fungerade inte i JPA kontext.  
Dezerializera json kafka meddelanden som objekt, min första lösning var onödigt krånglig och utnyttjade inte effektiviteten i kafka och springboot.

### Beskriv om du fått byta lösning och varför i sådana fall

Inledningsvis deserializerade jag json objekten med Jacksons object-mapper, för att kunna skapa "bättre" utformade
objekt för att spara i databasen. Det skapade ömtålig datastruktur.

## Slutsatser

Springboot är väldigt kraftfullt och besparar mycket skrivande av kod. Integration med Kafka är lätt att genomföra och
meddelanden skickas väldigt fort genom systemet. 

### Vad gick bra

Applikationerna fungerar bra, lätt att bygga vidare på förändringar i objekten som skickas behöver bara ske på ett
ställe. Linux är mycket stabil och bra utvecklingsmiljö för Java Springboot och Kafka projekt.

### Vad gick dåligt

Skrev massa kul kod för att hantera objekt och tables i databaser, helt i onödan.  
Av för mig okänd anledning är jackson-databind krav i modulen som interagerar med sql databasen, ser inte var den nyttjas.

### Vad har du lärt dig

Vikten av att definiera mvp gränserna för projektet tidigt. Vilket är utmanande med nya tekniker men oupptäckta förmågor.
Det är lite annorlunda strategi för att lära sig framework contra grundläggande programming. Lösningarna på problemen finns redan
de ska bara användas på ett korrekt. Det blir viktigare att gå igenom tutorials och dokumentation innan man börjar skapa egna lösningar.

Springboot, modulära projekt, skapa webAPI, SQL hantering med JPA, Apache Kafka, Docker.

Provat att automatgenerera tester med plugin Diffblue Cover. Insikten att det skapar textväggar till test som är tar tid att förstå.
Man missar dessutom testdriven utveckling som är viktigt för framtida underhåll av koden.  

### Vad hade du gjort annorlunda om ni gjort om projektet

Redan från början skapat projektet med moduler. Tittat på säkerhetsimplementeringar i tidigare skede.
Genomfört en tydligare planeringsfas i varje delmoment och arbetat med kanban board för att skapa bättre överblick över genomförda uppgifter.
Tagit mig tid att testa ännu fler olika lösningar.

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
En förståelse för systemintegration och vad för alternativ som finns. 
Implementera och använda kafkalösningar för kommunikation mellan appar. Smidigt lagrade av data med JPA. 
