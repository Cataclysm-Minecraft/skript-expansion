package com.github.snowpyon.skriptexpansion;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacement<T> {

    private Pattern placeholder;
    private Function<T, String> replacement;

    public Replacement(Function<T, String> replacement, Pattern placeholder) {
        this.placeholder = placeholder;
        this.replacement = replacement;
    }

    public Replacement(Function<T, String> replacement, String placeholder) {
        this.placeholder = Pattern.compile("[{%]" + placeholder + "[}%]");
        this.replacement = replacement;
    }

    // TODO: cache?
    public String apply(String input, T from) {
        Matcher m = placeholder.matcher(input);
        return m.replaceAll(replacement.apply(from));
    }

    public static <T> String applyAll(String input, T from, Replacement<T>... replacements) {
        String output = input;

        for (Replacement<T> replacement : replacements)
                output = replacement.apply(output, from);

        return output;
    }

}
