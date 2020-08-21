package com.kjil.utils;


import com.kjil.domain.Participant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CSVReaderTest {
    private static final String EMPTY_CSV = "src/test/resources/empty.csv";
    private static final String NON_EXISTS_CSV = "src/test/resources/rrr.csv";
    private static final String CSV_FILE_WITH_INCORRECT_VALUE_ON_TWO_LINE = "src/test/resources/with_incorrect_value.csv";
    private static final String CSV_FILE_WITH_EMPTY_VALUE_ON_THREE_LINE = "src/test/resources/with_empty_value.csv";
    private static final String CORRECT_CSV_FILE = "src/test/resources/correct.csv";

    private static Reader csvReader;

    @BeforeAll
    static void beforeAll() {
        csvReader = new CSVReader();
    }

    @Test
    void testParseEmptyCSVFile() throws IOException {
        List<Participant> participants = csvReader.parse(EMPTY_CSV);

        assertEquals(participants.size(), 0);
    }

    @Test
    void testParseNonExistsFile() {
        assertThrows(IOException.class, () -> {
            csvReader.parse(NON_EXISTS_CSV);
        });
    }

    @Test
    void testParseCSVFileWithIncorrectValueOnTwoLine() throws IOException {
        List<Participant> participants = csvReader.parse(CSV_FILE_WITH_INCORRECT_VALUE_ON_TWO_LINE);

        assertEquals(participants.size(), 2);
    }

    @Test
    void testParseCSVFileWithEmptyValue() throws IOException {
        List<Participant> participants = csvReader.parse(CSV_FILE_WITH_EMPTY_VALUE_ON_THREE_LINE);

        assertEquals(participants.size(), 1);
    }

    @Test
    void testCorrectParseCSVFile() throws IOException {
        List<Participant> participants = csvReader.parse(CORRECT_CSV_FILE);

        assertEquals(participants.size(), 4);
    }

}