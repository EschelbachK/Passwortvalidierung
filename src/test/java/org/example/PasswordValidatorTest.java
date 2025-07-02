package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    void hasMinimumLength() {
        // Test mit Passwort genau 8 Zeichen lang – sollte gültig sein
        assertTrue(PasswordValidator.hasMinimumLength("abcdefgh"));

        // Test mit Passwort länger als 8 Zeichen – sollte gültig sein
        assertTrue(PasswordValidator.hasMinimumLength("abcdefghi"));

        // Test mit Passwort zu kurz (3 Zeichen) – sollte ungültig sein
        assertFalse(PasswordValidator.hasMinimumLength("abc"));

        // Test mit null als Eingabe – sollte ungültig sein
        assertFalse(PasswordValidator.hasMinimumLength(null));

        // Test mit leerem Passwort – sollte ungültig sein
        assertFalse(PasswordValidator.hasMinimumLength(""));
    }

    @Test
    void minimumDigit() {
        // Test mit einem Passwort, das eine Zahl enthält – sollte gültig sein
        assertTrue(PasswordValidator.minimumDigit("abc1def"));

        // Test mit einem Passwort, das nur aus einer Zahl besteht – sollte gültig sein
        assertTrue(PasswordValidator.minimumDigit("1"));

        // Test mit einem Passwort ohne Zahlen – sollte ungültig sein
        assertFalse(PasswordValidator.minimumDigit("abcdef"));

        // Test mit leerem Passwort – sollte ungültig sein
        assertFalse(PasswordValidator.minimumDigit(""));

        // Test mit null als Eingabe – sollte ungültig sein
        assertFalse(PasswordValidator.minimumDigit(null));
    }

    @Test
    void containsUpperAndLowerCase() {
        // Test mit Groß- und Kleinbuchstaben – sollte gültig sein
        assertTrue(PasswordValidator.containsUpperAndLowerCase("Abcdef"));

        // Test mit nur Kleinbuchstaben – sollte ungültig sein
        assertFalse(PasswordValidator.containsUpperAndLowerCase("abcdef"));

        // Test mit nur Großbuchstaben – sollte ungültig sein
        assertFalse(PasswordValidator.containsUpperAndLowerCase("ABCDEF"));

        // Test mit leerem Passwort – sollte ungültig sein
        assertFalse(PasswordValidator.containsUpperAndLowerCase(""));

        // Test mit null als Eingabe – sollte ungültig sein
        assertFalse(PasswordValidator.containsUpperAndLowerCase(null));

        // Test mit nur einem Groß- und einem Kleinbuchstaben – sollte gültig sein
        assertTrue(PasswordValidator.containsUpperAndLowerCase("aA"));
    }

    @Test
    void isCommonPassword() {
        // Test mit sehr häufigem Passwort – sollte als häufig erkannt werden
        assertTrue(PasswordValidator.isCommonPassword("123456"));

        // Test mit häufigem Passwort in gemischter Groß-/Kleinschreibung – sollte erkannt werden
        assertTrue(PasswordValidator.isCommonPassword("Password"));

        // Test mit deutschem Standardpasswort – sollte erkannt werden
        assertTrue(PasswordValidator.isCommonPassword("passwort"));

        // Test mit Großbuchstaben – sollte erkannt werden
        assertTrue(PasswordValidator.isCommonPassword("ADMIN"));

        // Test mit sicherem, individuellem Passwort – sollte nicht als häufig erkannt werden
        assertFalse(PasswordValidator.isCommonPassword("EinSicheresPasswort123"));

        // Test mit leerem Passwort – sollte nicht als häufig erkannt werden
        assertFalse(PasswordValidator.isCommonPassword(""));

        // Test mit null als Eingabe – sollte nicht als häufig erkannt werden
        assertFalse(PasswordValidator.isCommonPassword(null));
    }

    @Test
    void containsSpecialCharacter() {
        // Test mit Sonderzeichen im Passwort – sollte gültig sein
        assertTrue(PasswordValidator.containsSpecialCharacter("abc!def"));

        // Test ohne Sonderzeichen – sollte ungültig sein
        assertFalse(PasswordValidator.containsSpecialCharacter("abcdef"));

        // Test mit null als Eingabe – sollte ungültig sein
        assertFalse(PasswordValidator.containsSpecialCharacter(null));

        // Test mit leerem Passwort – sollte ungültig sein
        assertFalse(PasswordValidator.containsSpecialCharacter(""));
    }
}
