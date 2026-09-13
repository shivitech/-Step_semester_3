public class LibraryISBNValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return firstThree + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        String pubCode = code.substring(0, 3);
        String body = code.substring(3);

        for (int i = 0; i < pubCode.length(); i++) {
            if (!Character.isLetter(pubCode.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();
        result.append("[").append(pubCode).append("] ");
        result.append("YEAR: ").append(year).append(" | ");
        result.append("CATALOG: ").append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        String raw = " pen2026004251 ";
        String normalized = normalizeCode(raw);
        System.out.println(validateAndFormat(normalized)); // [PEN] YEAR: 2026 | CATALOG: 004251
    }
}