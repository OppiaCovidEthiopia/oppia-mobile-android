package database;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.digitalcampus.oppia.database.DbHelper;
import org.digitalcampus.oppia.model.QuizAttempt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class QuizTest extends BaseDBTests {

    @Test
    public void getUnexportedQuizAttempts() {

        addUsers();
        addCourses();

        QuizAttempt qa = new QuizAttempt();
        qa.setCourseId(1);
        qa.setUserId(1);
        qa.setSent(true);
        getDbHelper().insertQuizAttempt(qa);

        ArrayList<QuizAttempt> quizAttempts = (ArrayList<QuizAttempt>)
                getDbHelper().getUnexportedQuizAttempts(1);
        assertEquals(0, quizAttempts.size());

        // TODO this test is not passing. insertQuizAttempt method does not add "sent" value.
    }

    // getGlobalQuizAttempts
    @Test
    public void getGlobalQuizAttempts() {

        // TODO - add some test data here to really check
        List<QuizAttempt> quizAttempts = (ArrayList<QuizAttempt>)
                getDbHelper().getGlobalQuizAttempts(1, "en");
        assertEquals(0, quizAttempts.size());

    }

    // TODO getQuizAttempt
    // TODO getAllQuizAttemtps
    // TODO getQuizAttempts
    // TODO updateQuizAttempt
    // TODO insertQuizAttempts
    // TODO getUnsentQuizAttempts
    // TODO getUnexportedQuizAttempts
    // TODO markQuizSubmitted
    // TODO deleteQuizAttempts
    // TODO isQuizFirstAttempt
    // TODO isQuizFirstAttemptToday
}
