package org.example;

public class Main {
    public static void main(String[] args) {
        // Eine Liste von Beispiel-Passwörtern, die wir testen wollen
        String[] testPasswords = {
                // Ein sehr häufig genutztes (unsicheres) Passwort
                "123456",

                // Ein Passwort mit mindestens 8 Zeichen, enthält eine Ziffer, Groß- und Kleinbuchstaben
                "Passwort1",

                // Zu kurz, enthält keine Ziffer, nur Kleinbuchstaben
                "abc",

                // Nur Großbuchstaben, keine Ziffer
                "ABCDEFGH",

                // Kleinbuchstaben und Ziffer, aber kein Großbuchstabe
                "abcdefg1",

                // Erfüllt alle Anforderungen: Länge, Ziffer, Groß- und Kleinbuchstaben
                "Hallo123",

                // Auch ein häufiges Passwort, aber zu kurz und ohne Ziffer
                "welcome"
        };

        // Für jedes Passwort in der Liste prüfen wir verschiedene Regeln
        for (String pw : testPasswords) {
            // Zeigt das aktuelle Passwort an
            System.out.println("Passwort: " + pw);

            // Prüft, ob das Passwort mindestens 8 Zeichen lang ist
            System.out.println("  Mindestens 8 Zeichen? " + PasswordValidator.hasMinimumLength(pw));

            // Prüft, ob das Passwort mindestens eine Ziffer enthält
            System.out.println("  Mindestens eine Ziffer? " + PasswordValidator.minimumDigit(pw));

            // Prüft, ob sowohl Groß- als auch Kleinbuchstaben vorhanden sind
            System.out.println("  Groß- UND Kleinbuchstaben? " + PasswordValidator.containsUpperAndLowerCase(pw));

            // Prüft, ob das Passwort in der Liste der häufigen Passwörter steht
            System.out.println("  Häufiges Passwort? " + PasswordValidator.isCommonPassword(pw));

            // Leerzeile für bessere Lesbarkeit der Ausgabe
            System.out.println();
        }
    }
}
