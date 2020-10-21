package seedu.flashcard.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.flashcard.commons.core.index.Index;
import seedu.flashcard.commons.util.StringUtil;
import seedu.flashcard.logic.parser.exceptions.ParseException;
import seedu.flashcard.model.flashcard.Answer;
import seedu.flashcard.model.flashcard.Category;
import seedu.flashcard.model.flashcard.Diagram;
import seedu.flashcard.model.flashcard.Note;
import seedu.flashcard.model.flashcard.Question;
import seedu.flashcard.model.flashcard.Rating;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String question} into a {@code Question}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code question} is invalid.
     */
    public static Question parseQuestion(String question) throws ParseException {
        requireNonNull(question);
        String trimmedQuestion = question.trim();
        if (!Question.isValidQuestion(trimmedQuestion)) {
            throw new ParseException(Question.MESSAGE_CONSTRAINTS);
        }
        return new Question(trimmedQuestion);
    }

    /**
     * Parses a {@code String answer} into a {@code Answer}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code answer} is invalid.
     */
    public static Answer parseAnswer(String answer) throws ParseException {
        requireNonNull(answer);
        String trimmedAnswer = answer.trim();
        if (!Answer.isValidAnswer(trimmedAnswer)) {
            throw new ParseException(Answer.MESSAGE_CONSTRAINTS);
        }
        return new Answer(trimmedAnswer);
    }

    /**
     * Parses a {@code String category} into a {@code Category}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code category} is invalid.
     */
    public static Category parseCategory(String category) throws ParseException {
        requireNonNull(category);
        String trimmedCategory = category.trim();
        if (!Category.isValidCategory(trimmedCategory)) {
            throw new ParseException(Category.MESSAGE_CONSTRAINTS);
        }
        return new Category(trimmedCategory);
    }

    /**
     * Parses {@code Collection<String> categories} into a {@code List<Category>}.
     */
    public static List<Category> parseCategories(Collection<String> categories) throws ParseException {
        requireNonNull(categories);
        final Set<Category> categorySet = new HashSet<>();
        for (String categoryName : categories) {
            categorySet.add(parseCategory(categoryName));
        }
        List<Category> categoryList = new ArrayList<>();
        categoryList.addAll(categorySet);
        return categoryList;
    }

    /**
     * Parses a {@code String note} into a {@code Note}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Note parseNote(String note) {
        requireNonNull(note);
        String trimmedNote = note.trim();
        return new Note(trimmedNote);
    }

    /**
     * Parses a {@code String rating} into a {@code Rating}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Rating parseRating(String rating) throws ParseException {
        requireNonNull(rating);
        String trimmedRating = rating.trim();
        if (!Rating.isValidRating(trimmedRating)) {
            throw new ParseException(Rating.MESSAGE_CONSTRAINTS);
        }
        return new Rating(trimmedRating);
    }

    /**
     * Parses a {@code String diagramFilePath } into a {@code Diagram}.
     * Leading and trailing whitespaces will be trimmed.
     */

    public static Diagram parseDiagram(String diagramFilePath) throws ParseException {
        requireNonNull(diagramFilePath);
        String trimmedDiagramFilePath = diagramFilePath.trim();
        if (trimmedDiagramFilePath.isEmpty()) {
            return new Diagram(trimmedDiagramFilePath);
        }
        if (!Diagram.isValidFile(trimmedDiagramFilePath)) {
            throw new ParseException(Diagram.MESSAGE_NON_EXISTENT_DIAGRAM_FILE_TYPE);
        }
        if (!Diagram.isValidImageFileType(trimmedDiagramFilePath)) {
            throw new ParseException(Diagram.MESSAGE_INVALID_DIAGRAM_FILE_TYPE);
        }
        return new Diagram(trimmedDiagramFilePath);
    }


    //    /**
    //     * Parses a {@code String tag} into a {@code Tag}.
    //     * Leading and trailing whitespaces will be trimmed.
    //     *
    //     * @throws ParseException if the given {@code tag} is invalid.
    //     */
    //    public static Tag parseTag(String tag) throws ParseException {
    //        requireNonNull(tag);
    //        String trimmedTag = tag.trim();
    //        if (!Tag.isValidTagName(trimmedTag)) {
    //            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
    //        }
    //        return new Tag(trimmedTag);
    //    }
    //
    //    /**
    //     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
    //     */
    //    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
    //        requireNonNull(tags);
    //        final Set<Tag> tagSet = new HashSet<>();
    //        for (String tagName : tags) {
    //            tagSet.add(parseTag(tagName));
    //        }
    //        return tagSet;
    //    }

}