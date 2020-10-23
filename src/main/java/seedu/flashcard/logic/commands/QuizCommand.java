package seedu.flashcard.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.flashcard.logic.commands.exceptions.CommandException;
import seedu.flashcard.model.Model;

public class QuizCommand extends Command {

    public static final String COMMAND_WORD = "quiz";

    public static final String MESSAGE_INITIATE_REVIEW_SUCCESS = "Entered quiz mode";
    public static final String MESSAGE_INITIATE_REVIEW_ERROR = "There are no flashcards to review";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.getFilteredFlashcardList().size() == 0) {
            throw new CommandException(MESSAGE_INITIATE_REVIEW_ERROR);
        }

        return new CommandResult(MESSAGE_INITIATE_REVIEW_SUCCESS, false, false, false, true);
    }
}
