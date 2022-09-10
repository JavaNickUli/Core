package uli.nick.ylab.taskstwo.task3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static uli.nick.ylab.taskstwo.task3.FuzzySearch.fuzzySearch;
import static uli.nick.ylab.taskstwo.task3.FuzzySearch.fuzzySearchByStream;

class FuzzySearchTest {

    @Test
    void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        FuzzySearch.main(null);

        String actual = out.toString();
        String ln = System.lineSeparator();
        String expected =
                String.join(ln, "true", "true", "true", "true", "false", "false") + ln;

        then(actual).isEqualTo(expected);
    }

    @Test
    void fuzzySearchTest0() {
        String origin = "cat";
        String target = "cdaotg";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isTrue();
        then(actualStream).isTrue();
    }

    @Test
    void fuzzySearchTest1() {
        String origin = "cat";
        String target = "dcaotg";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isTrue();
        then(actualStream).isTrue();
    }

    @Test
    void fuzzySearchTest2() {
        String origin = "cat";
        String target = "dcatog";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isTrue();
        then(actualStream).isTrue();
    }

    @Test
    void fuzzySearchTest3() {
        String origin = "cat";
        String target = "cat";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isTrue();
        then(actualStream).isTrue();
    }

    @Test
    void fuzzySearchTest4() {
        String origin = "cat";
        String target = "c c a a t t";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isTrue();
        then(actualStream).isTrue();
    }

    @Test
    void fuzzySearchTest5() {
        String origin = "t";
        String target = "cat";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isTrue();
        then(actualStream).isTrue();
    }

    @Test
    void fuzzySearchTest6() {
        String origin = "cat";
        String target = "CAT";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest7() {
        String origin = "cat";
        String target = "tac";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest8() {
        String origin = "cat";
        String target = "tactacac";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest9() {
        String origin = "c";
        String target = "dog";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest10() {
        String origin = "";
        String target = "dog";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest11() {
        String origin = "cat";
        String target = "";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest12() {
        String origin = null;
        String target = "dog";

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest13() {
        String origin = "cat";
        String target = null;

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }

    @Test
    void fuzzySearchTest14() {
        String origin = null;
        String target = null;

        boolean actual = fuzzySearch(origin, target);
        boolean actualStream = fuzzySearchByStream(origin, target);

        then(actual).isFalse();
        then(actualStream).isFalse();
    }
}