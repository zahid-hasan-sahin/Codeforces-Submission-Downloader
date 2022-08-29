package com.codeforcessubmissiondownloader.operators;

import java.util.HashMap;

public class ProgrammingLanguageToFileExtention {

    private static HashMap<String, String> ext = new HashMap<String, String>();
    private static boolean isFirstTime = true;

    static String getExtention(String language) {
        if (isFirstTime) {
            makeExt();
            isFirstTime = false;
        }
        return ext.getOrDefault(language, "txt");
    }

    static void makeExt() {

        ext.put("GNU C11", "c");
        ext.put("Clang++20 Diagnostics", "cpp");
        ext.put("Clang++17 Diagnostics", "cpp");
        ext.put("GNU C++14", "cpp");
        ext.put("GNU C++17", "cpp");
        ext.put("GNU C++20 (64)", "cpp");
        ext.put("MS C++ 2017", "cpp");
        ext.put("GNU C++17 (64)", "cpp");
        ext.put("C# 8", "cs");
        ext.put("C# 10", "cs");
        ext.put("Mono C#", "cs");
        ext.put("D", "d");
        ext.put("Go", "go");
        ext.put("Haskell", "hs");
        ext.put("Java 11", "java");
        ext.put("Java 17", "java");
        ext.put("Java 8", "java");
        ext.put("Kotlin 1.4", "kt");
        ext.put("Kotlin 1.5", "kt");
        ext.put("Kotlin 1.6", "kt");
        ext.put("Ocaml", "ml");
        ext.put("Delphi", "dpr");
        ext.put("PascalABC.NET", "pas");
        ext.put("Perl", "pl");
        ext.put("PHP", "php");
        ext.put("Python 2", "py");
        ext.put("Python 3", "py");
        ext.put("PyPy 2", "py");
        ext.put("PyPy 3-64", "py");
        ext.put("Ruby 3", "rb");
        ext.put("Rust 2021", "rs");
        ext.put("Scala", "scala");
        ext.put("JavaScript", "js");
        ext.put("Node.js", "js");
        ext.put("Tcl", "tcl");
        ext.put("Io", "io");
        ext.put("Pike", "pike");
        ext.put("Befunge", "befunge");
        ext.put("Cobol", "cob");
        ext.put("Factor", "factor");
        ext.put("Secret_171", "txt");
        ext.put("Roco", "cpp");
        ext.put("Ada", "adb");
        ext.put("Mysterious Language", "txt");
        ext.put("FALSE", "f");
        ext.put("Picat", "Picat");
        ext.put("GNU C++11 ZIP", "cpp");
        ext.put("Java 8 ZIP", "java");
        ext.put("J", "ijs");
        ext.put("Q#", "q");
        ext.put("Text", "txt");
        ext.put("UnknownX", "txt");
        ext.put("Secret 2021", "txt");

    }

}
