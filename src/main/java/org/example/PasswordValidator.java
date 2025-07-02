package org.example;

import java.util.Set;

public class PasswordValidator {

    // Prüft, ob das Passwort mindestens 8 Zeichen lang ist
    public static boolean hasMinimumLength(String password) {
        // Rückgabe: true, wenn das Passwort nicht null ist und mindestens 8 Zeichen hat
        return password != null && password.length() >= 8;
    }

    // Prüft, ob das Passwort mindestens eine Ziffer (0–9) enthält
    public static boolean minimumDigit(String password) {
        // Wenn das Passwort null ist, geben wir false zurück
        if (password == null) return false;

        // Wir gehen jeden Buchstaben/Zahl im Passwort durch
        for (char c : password.toCharArray()) {
            // Wenn das aktuelle Zeichen eine Ziffer ist, geben wir true zurück
            if (Character.isDigit(c)) {
                return true;
            }
        }
        // Wenn keine Ziffer gefunden wurde, geben wir false zurück
        return false;
    }

    // Prüft, ob das Passwort sowohl Groß- als auch Kleinbuchstaben enthält
    public static boolean containsUpperAndLowerCase(String password) {
        // Wenn das Passwort null ist, geben wir false zurück
        if (password == null) return false;

        // Zwei Kontrollvariablen, um Groß- und Kleinbuchstaben zu erkennen
        boolean hasUpper = false;
        boolean hasLower = false;

        // Wir gehen jedes Zeichen im Passwort durch
        for (char c : password.toCharArray()) {
            // Wenn das Zeichen ein Großbuchstabe ist, setzen wir hasUpper auf true
            if (Character.isUpperCase(c)) hasUpper = true;

            // Wenn das Zeichen ein Kleinbuchstabe ist, setzen wir hasLower auf true
            if (Character.isLowerCase(c)) hasLower = true;

            // Wenn beides true ist, enthält das Passwort beides – wir geben true zurück
            if (hasUpper && hasLower) return true;
        }

        // Wenn nur eines oder keins vorhanden ist, geben wir false zurück
        return false;
    }

    // Prüft, ob das Passwort zu den häufig verwendeten (unsicheren) Passwörtern gehört
    public static boolean isCommonPassword(String password) {
        // Wenn das Passwort null ist, geben wir false zurück
        if (password == null) return false;

        // Eine Liste der häufigsten (unsicheren) Passwörter
        // Wir verwenden ein Set, weil es schneller prüft als eine Liste
        Set<String> commonPasswords = Set.of(
                "123456", "password", "12345678", "passwort", "abc123",
                "111111", "123123", "admin", "welcome", "iloveyou",
                "1234", "000000", "654321", "12345", "1q2w3e4r",
                "qwertz", "test123", "hallo", "asdfgh", "meinpasswort",
                "passwort1", "passwort123", "hallo123", "qwerty", "letmein",
                "monkey", "dragon", "user", "default", "login"
        );

        // Wir prüfen, ob das Passwort (in Kleinbuchstaben) in der Liste enthalten ist
        return commonPasswords.contains(password.toLowerCase());
    }

    // Prüft, ob das Passwort mindestens ein Sonderzeichen enthält
    public static boolean containsSpecialCharacter(String password) {
        // Wenn das Passwort null ist, geben wir false zurück
        if (password == null) return false;

        // Eine Liste von gängigen Sonderzeichen, die erlaubt sind
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/\\`~";

        // Wir gehen jedes Zeichen im Passwort durch
        for (char c : password.toCharArray()) {
            // Wenn das Zeichen in der Liste der Sonderzeichen vorkommt, geben wir true zurück
            if (specialChars.indexOf(c) >= 0) {
                return true;
            }
        }

        // Wenn kein Sonderzeichen gefunden wurde, geben wir false zurück
        return false;
    }
}