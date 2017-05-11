package io.jenkins.blueocean.service.embedded.util;

import org.apache.oro.text.GlobCompiler;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.Perl5Matcher;

public final class GlobMatcher {

    private static final GlobCompiler GLOB_COMPILER = new GlobCompiler();
    private static final Perl5Matcher MATCHER = new Perl5Matcher();
    private final Pattern pattern;

    public GlobMatcher(String patternStr) {
        try {
            this.pattern = GLOB_COMPILER.compile(patternStr, GlobCompiler.CASE_INSENSITIVE_MASK);
        } catch (MalformedPatternException e) {
            throw new IllegalArgumentException("bad pattern", e);
        }
    }

    public boolean matches(String input) {
        return MATCHER.matches(input, pattern);
    }
}
