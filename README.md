# Snake

Ein klassisches Snake-Spiel mit ungewöhnlicher Steuerung und einem strategischen Twist: Seltene Früchte füllen eine Effekt-Leiste, die per Tastendruck aktiviert werden können.

Entstanden im Rahmen des Kurses **Grundlagen der Softwareentwicklung** an der Technischen Hochschule Augsburg.

!\[Gameplay Screenshot](Snake-StartGame.png)



## Features

* **Steuerung per Mausrad**: Statt Pfeiltasten wird die Snake über das Scrollen des Mausrads gelenkt – Scrollen nach oben/unten dreht die Snake nach links bzw. rechts.
* **Drei Früchte-Typen**:

  * 🍎 **Äpfel** (rot) – spawnen am häufigsten, normales Wachstum
  * 🫐 **Blaubeeren** (blau) – füllen die Effekt-Leiste mit blauen Quadraten
  * 🍌 **Bananen** (gelb) – füllen die Effekt-Leiste mit gelben Quadraten
* **Effekt-System**: Beim Sammeln von Blaubeeren und Bananen füllt sich die Effektleiste. Ist sie voll, kann per Tastendruck ein zufälliger Effekt ausgelöst werden:

  * Ein Übergewicht an Blaubeeren erhöht die Wahrscheinlichkeit, dass die Snake für einige Sekunden **schneller** wird.
  * Ein Übergewicht an Bananen erhöht die Wahrscheinlichkeit, dass die Snake für einige Sekunden **langsamer** wird.
  * Das genaue Verhältnis der gesammelten Früchte beeinflusst also die Erfolgschancen des jeweiligen Effekts.



## Steuerung

|Aktion|Eingabe|
|-|-|
|Snake nach links drehen|Mausrad nach oben scrollen|
|Snake nach rechts drehen|Mausrad nach unten scrollen|
|Effekt auslösen (wenn Leiste voll)|Mausklick|



