Compulsory:
-
- creat clasele Event, Room si Main
- creat Enum-ul Type
- implementat setters si getters pentru variabilele private din Event si Room
- override al metodei toString() in clasele Event si Room
- creat functii statice pentru creare obiecte de tipul event, room si pentru afisarea specifica a lor.

Homework:
-
- creat clase separate:
  - Room : clasa abstracta
  - LectureHall: clasa mostenita din Room 
  - LabRoom: clasa mostenita din Room
  - Event
  - Problem: clasa ce descrie instanta problemei
  - Solution: clasa ce descrie implementarea solutiei problemei 
- implementat setters si getters pentru atributele clasei Room, respectiv lecture si Laboratory si clasa Event
- implementare override la metoda toString
- implementare ovveride la metoda equals dupa criteriul nume al obiectului de tip Room
- implementare functii addRoom si addEvent
- implementare functii printRooms si printEvents
- implementare constructori pentru clasele Problem si Solution
- implementare comparatoare pentru obiectele Event si Room pentru sortarea crescatoare:
  - La Event: dupa start time
  - La Room: dupa capacitate
- implementare algoritm minimizare numar de camere folosite
- creare Java documentation

Bonus:
-
- creat clase separata pentru algoritmul de colorare:
  - DSatur
