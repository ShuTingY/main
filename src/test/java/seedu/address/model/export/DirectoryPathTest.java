//@@author LeowWB

package seedu.address.model.export;

import static org.junit.jupiter.api.Assertions.fail;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DirectoryPathTest {

    @Test
    public void directoryPath_invalidPath_throwsException() {
        String[] invalidDirectoryPathStrings = {
            "directory\\?????\\directory2",
            "directory/?????/directory2",
            "directory/*****/directory2",
            "directory\\*****\\directory2"
        };

        for (String invalidDirectoryPathString : invalidDirectoryPathStrings) {
            assertThrows(
                IllegalArgumentException.class, () ->
                    new DirectoryPath(
                    invalidDirectoryPathString
                )
            );
        }
    }

    @Test
    public void directoryPath_validPath_success() {
        String[] validDirectoryPathStrings = {
            "directory",
            "/directory/",
            "\\directory\\",
            "\\b c\\d",
            "/b c/d",
            "C:\\Users\\User\\Desktop\\",
            "~/Desktop/",
            "../",
            "..\\"
        };

        for (String validDirectoryPathString : validDirectoryPathStrings) {
            try {
                new DirectoryPath(validDirectoryPathString);
            } catch (IllegalArgumentException e) {
                fail("Valid directory file path was not recognized as being valid");
            }
        }
    }
}